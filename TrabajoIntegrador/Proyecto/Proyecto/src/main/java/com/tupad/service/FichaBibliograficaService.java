package com.tupad.service;

import com.tupad.config.DatabaseConnection;
import com.tupad.dao.FichaBibliograficaDao;
import com.tupad.dao.jdbc.FichaBibliograficaDaoJdbc;
import com.tupad.entities.FichaBibliografica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FichaBibliograficaService implements GenericService<FichaBibliografica> {

    private final FichaBibliograficaDao dao = new FichaBibliograficaDaoJdbc();

    @Override
    public FichaBibliografica insertar(FichaBibliografica f) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                validar(f);
                FichaBibliografica created = dao.crear(conn, f);
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
    public FichaBibliografica actualizar(FichaBibliografica f) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                validar(f);
                FichaBibliografica updated = dao.actualizar(conn, f);
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
                boolean ok = dao.eliminarLogico(conn, id);
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
    public FichaBibliografica getById(long id) throws SQLException {
        return dao.leer(id);
    }

    @Override
    public List<FichaBibliografica> getAll() throws SQLException {
        return dao.leerTodos();
    }

    private void validar(FichaBibliografica f) {
        if (f == null) {
            throw new IllegalArgumentException("Ficha no puede ser null");
    }

    // ISBN obligatorio y con longitud máxima 17
        if (f.getIsbn() == null || f.getIsbn().isBlank()) {
            throw new IllegalArgumentException("ISBN obligatorio");
    }
        if (f.getIsbn().length() > 17) {
            throw new IllegalArgumentException("ISBN no puede superar 17 caracteres");
    }

    // Longitudes máximas recomendadas
        if (f.getClasificacionDewey() != null && f.getClasificacionDewey().length() > 20) {
            throw new IllegalArgumentException("Clasificación Dewey no puede superar 20 caracteres");
    }
        if (f.getEstanteria() != null && f.getEstanteria().length() > 20) {
            throw new IllegalArgumentException("Estantería no puede superar 20 caracteres");
    }
        if (f.getIdioma() != null && f.getIdioma().length() > 30) {
            throw new IllegalArgumentException("Idioma no puede superar 30 caracteres");
    }
}

}
