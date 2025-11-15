package com.tupad.service;

import com.tupad.config.DatabaseConnection;
import com.tupad.dao.FichaBibliograficaDao;
import com.tupad.dao.LibroDao;
import com.tupad.dao.jdbc.FichaBibliograficaDaoJdbc;
import com.tupad.dao.jdbc.LibroDaoJdbc;
import com.tupad.entities.FichaBibliografica;
import com.tupad.entities.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibroService implements GenericService<Libro> {

    private final LibroDao libroDao = new LibroDaoJdbc();
    private final FichaBibliograficaDao fichaDao = new FichaBibliograficaDaoJdbc();

    @Override
    public Libro insertar(Libro l) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                validar(l);
                if (l.getFicha() != null && l.getFicha().getId() != null) {
                    Libro existente = buscarPorFicha(conn, l.getFicha().getId());
                    if (existente != null) throw new IllegalStateException("La ficha ya está asociada a otro libro (id=" + existente.getId() + ")");
                }
                Libro created = libroDao.crear(conn, l);
                conn.commit();
                return created;
            } catch (Exception ex) {
                conn.rollback();
                throw ex instanceof SQLException ? (SQLException) ex : new SQLException(ex);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    @Override
    public Libro actualizar(Libro l) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                validar(l);
                if (l.getFicha() != null && l.getFicha().getId() != null) {
                    Libro existente = buscarPorFicha(conn, l.getFicha().getId());
                    if (existente != null && !existente.getId().equals(l.getId()))
                        throw new IllegalStateException("La ficha ya está asociada a otro libro (id=" + existente.getId() + ")");
                }
                Libro updated = libroDao.actualizar(conn, l);
                conn.commit();
                return updated;
            } catch (Exception ex) {
                conn.rollback();
                throw ex instanceof SQLException ? (SQLException) ex : new SQLException(ex);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    @Override
    public boolean eliminar(long id) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                boolean ok = libroDao.eliminarLogico(conn, id);
                conn.commit();
                return ok;
            } catch (Exception ex) {
                conn.rollback();
                throw ex instanceof SQLException ? (SQLException) ex : new SQLException(ex);
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }

    @Override
    public Libro getById(long id) throws SQLException { return libroDao.leer(id); }

    @Override
    public List<Libro> getAll() throws SQLException { return libroDao.leerTodos(); }

    public Libro buscarPorIsbn(String isbn) throws SQLException { 
        try (Connection conn = DatabaseConnection.getConnection()) {
            return libroDao.buscarPorIsbn(conn, isbn);
        }
    }

    private Libro buscarPorFicha(Connection conn, long fichaId) throws SQLException {
        String sql = "SELECT id FROM libro WHERE ficha_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, fichaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return libroDao.leer(conn, rs.getLong("id"));
                return null;
            }
        }
    }

    private void validar(Libro l) {
        if (l == null) throw new IllegalArgumentException("Libro no puede ser null");
        if (l.getTitulo() == null || l.getTitulo().isBlank() || l.getTitulo().length() > 150) 
            throw new IllegalArgumentException("Título obligatorio (<=150)");
        if (l.getAutor() == null || l.getAutor().isBlank() || l.getAutor().length() > 120) 
            throw new IllegalArgumentException("Autor obligatorio (<=120)");
        if (l.getEditorial() != null && l.getEditorial().length() > 100) 
            throw new IllegalArgumentException("Editorial <=100");
        // ficha opcional, pero si viene con id debe existir (se valida por integridad referencial al persistir)
    }
}
