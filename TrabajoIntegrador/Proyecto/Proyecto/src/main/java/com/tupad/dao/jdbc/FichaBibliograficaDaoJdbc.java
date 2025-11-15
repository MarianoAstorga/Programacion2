package com.tupad.dao.jdbc;

import com.tupad.dao.FichaBibliograficaDao;
import com.tupad.entities.FichaBibliografica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FichaBibliograficaDaoJdbc implements FichaBibliograficaDao {

    @Override
    public FichaBibliografica crear(Connection conn, FichaBibliografica f) throws SQLException {
        String sql = "INSERT INTO ficha_bibliografica (eliminado, isbn, clasificacion_dewey, estanteria, idioma) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setBoolean(1, f.isEliminado());
            ps.setString(2, f.getIsbn());
            ps.setString(3, f.getClasificacionDewey());
            ps.setString(4, f.getEstanteria());
            ps.setString(5, f.getIdioma());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) f.setId(rs.getLong(1));
            }
            return f;
        }
    }

    @Override
    public FichaBibliografica leer(Connection conn, long id) throws SQLException {
        String sql = "SELECT id, eliminado, isbn, clasificacion_dewey, estanteria, idioma FROM ficha_bibliografica WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    FichaBibliografica f = new FichaBibliografica();
                    f.setId(rs.getLong("id"));
                    f.setEliminado(rs.getBoolean("eliminado"));
                    f.setIsbn(rs.getString("isbn"));
                    f.setClasificacionDewey(rs.getString("clasificacion_dewey"));
                    f.setEstanteria(rs.getString("estanteria"));
                    f.setIdioma(rs.getString("idioma"));
                    return f;
                }
                return null;
            }
        }
    }

    @Override
    public List<FichaBibliografica> leerTodos(Connection conn) throws SQLException {
        String sql = "SELECT id, eliminado, isbn, clasificacion_dewey, estanteria, idioma FROM ficha_bibliografica";
        List<FichaBibliografica> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                FichaBibliografica f = new FichaBibliografica();
                f.setId(rs.getLong("id"));
                f.setEliminado(rs.getBoolean("eliminado"));
                f.setIsbn(rs.getString("isbn"));
                f.setClasificacionDewey(rs.getString("clasificacion_dewey"));
                f.setEstanteria(rs.getString("estanteria"));
                f.setIdioma(rs.getString("idioma"));
                list.add(f);
            }
        }
        return list;
    }

    @Override
    public FichaBibliografica actualizar(Connection conn, FichaBibliografica f) throws SQLException {
        String sql = "UPDATE ficha_bibliografica SET eliminado=?, isbn=?, clasificacion_dewey=?, estanteria=?, idioma=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, f.isEliminado());
            ps.setString(2, f.getIsbn());
            ps.setString(3, f.getClasificacionDewey());
            ps.setString(4, f.getEstanteria());
            ps.setString(5, f.getIdioma());
            ps.setLong(6, f.getId());
            ps.executeUpdate();
            return f;
        }
    }

    @Override
    public boolean eliminarLogico(Connection conn, long id) throws SQLException {
        String sql = "UPDATE ficha_bibliografica SET eliminado=true WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
