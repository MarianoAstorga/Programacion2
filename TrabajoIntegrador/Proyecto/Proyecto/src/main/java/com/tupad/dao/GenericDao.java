package com.tupad.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    T crear(Connection conn, T t) throws SQLException;
    T leer(Connection conn, long id) throws SQLException;
    List<T> leerTodos(Connection conn) throws SQLException;
    T actualizar(Connection conn, T t) throws SQLException;
    boolean eliminarLogico(Connection conn, long id) throws SQLException;

    default T crear(T t) throws SQLException { try (Connection c = com.tupad.config.DatabaseConnection.getConnection()) { return crear(c, t); } }
    default T leer(long id) throws SQLException { try (Connection c = com.tupad.config.DatabaseConnection.getConnection()) { return leer(c, id); } }
    default java.util.List<T> leerTodos() throws SQLException { try (Connection c = com.tupad.config.DatabaseConnection.getConnection()) { return leerTodos(c); } }
    default T actualizar(T t) throws SQLException { try (Connection c = com.tupad.config.DatabaseConnection.getConnection()) { return actualizar(c, t); } }
    default boolean eliminarLogico(long id) throws SQLException { try (Connection c = com.tupad.config.DatabaseConnection.getConnection()) { return eliminarLogico(c, id); } }
}
