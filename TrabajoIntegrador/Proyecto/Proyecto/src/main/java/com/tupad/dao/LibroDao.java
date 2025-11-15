package com.tupad.dao;

import com.tupad.entities.Libro;

public interface LibroDao extends GenericDao<Libro> {
    Libro buscarPorIsbn(java.sql.Connection conn, String isbn) throws java.sql.SQLException;
    default Libro buscarPorIsbn(String isbn) throws java.sql.SQLException {
        try (java.sql.Connection c = com.tupad.config.DatabaseConnection.getConnection()) {
            return buscarPorIsbn(c, isbn);
        }
    }
}
