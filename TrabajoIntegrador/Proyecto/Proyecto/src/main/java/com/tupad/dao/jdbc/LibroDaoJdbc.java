package com.tupad.dao.jdbc;

import com.tupad.dao.LibroDao;
import com.tupad.entities.FichaBibliografica;
import com.tupad.entities.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDaoJdbc implements LibroDao {

    @Override
    public Libro crear(Connection conn, Libro l) throws SQLException {
        String sql = "INSERT INTO libro (eliminado, titulo, autor, editorial, anio_edicion, ficha_id) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setBoolean(1, l.isEliminado());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getEditorial());
            if (l.getAnioEdicion()!=null) ps.setInt(5, l.getAnioEdicion()); else ps.setNull(5, Types.INTEGER);
            if (l.getFicha() != null) ps.setLong(6, l.getFicha().getId());
            else ps.setNull(6, Types.BIGINT);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) l.setId(rs.getLong(1));
            }
            return l;
        }
    }

    @Override
    public Libro leer(Connection conn, long id) throws SQLException {
        String sql = "SELECT l.id AS l_id, l.eliminado AS l_eliminado, l.titulo, l.autor, l.editorial, l.anio_edicion, " +
                "f.id AS f_id, f.eliminado AS f_eliminado, f.isbn, f.clasificacion_dewey, f.estanteria, f.idioma " +
                "FROM libro l LEFT JOIN ficha_bibliografica f ON f.id = l.ficha_id WHERE l.id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    FichaBibliografica f = null;
                    long fId = rs.getLong("f_id");
                    if (!rs.wasNull()) {
                        f = new FichaBibliografica(fId, rs.getBoolean("f_eliminado"),
                                rs.getString("isbn"), rs.getString("clasificacion_dewey"),
                                rs.getString("estanteria"), rs.getString("idioma"));
                    }
                    Integer anio = rs.getObject("anio_edicion") == null ? null : rs.getInt("anio_edicion");
                    return new Libro(rs.getLong("l_id"), rs.getBoolean("l_eliminado"),
                            rs.getString("titulo"), rs.getString("autor"),
                            rs.getString("editorial"), anio, f);
                }
                return null;
            }
        }
    }

    @Override
    public List<Libro> leerTodos(Connection conn) throws SQLException {
        String sql = "SELECT l.id AS l_id, l.eliminado AS l_eliminado, l.titulo, l.autor, l.editorial, l.anio_edicion, " +
                "f.id AS f_id, f.eliminado AS f_eliminado, f.isbn, f.clasificacion_dewey, f.estanteria, f.idioma " +
                "FROM libro l LEFT JOIN ficha_bibliografica f ON f.id = l.ficha_id";
        List<Libro> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FichaBibliografica f = null;
                long fId = rs.getLong("f_id");
                if (!rs.wasNull()) {
                    f = new FichaBibliografica(fId, rs.getBoolean("f_eliminado"),
                            rs.getString("isbn"), rs.getString("clasificacion_dewey"),
                            rs.getString("estanteria"), rs.getString("idioma"));
                }
                Integer anio = rs.getObject("anio_edicion") == null ? null : rs.getInt("anio_edicion");
                list.add(new Libro(rs.getLong("l_id"), rs.getBoolean("l_eliminado"),
                        rs.getString("titulo"), rs.getString("autor"),
                        rs.getString("editorial"), anio, f));
            }
        }
        return list;
    }

    @Override
    public Libro actualizar(Connection conn, Libro l) throws SQLException {
        String sql = "UPDATE libro SET eliminado=?, titulo=?, autor=?, editorial=?, anio_edicion=?, ficha_id=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, l.isEliminado());
            ps.setString(2, l.getTitulo());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getEditorial());
            if (l.getAnioEdicion()!=null) ps.setInt(5, l.getAnioEdicion()); else ps.setNull(5, Types.INTEGER);
            if (l.getFicha() != null) ps.setLong(6, l.getFicha().getId());
            else ps.setNull(6, Types.BIGINT);
            ps.setLong(7, l.getId());
            ps.executeUpdate();
            return l;
        }
    }

    @Override
    public boolean eliminarLogico(Connection conn, long id) throws SQLException {
        String sql = "UPDATE libro SET eliminado=true WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Libro buscarPorIsbn(Connection conn, String isbn) throws SQLException {
        String sql = "SELECT l.id FROM libro l JOIN ficha_bibliografica f ON f.id = l.ficha_id WHERE f.isbn=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbn);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return leer(conn, rs.getLong(1));
                return null;
            }
        }
    }
}
