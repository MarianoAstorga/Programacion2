package com.tupad.service;

import java.sql.SQLException;
import java.util.List;

public interface GenericService<T> {
    T insertar(T t) throws SQLException;
    T actualizar(T t) throws SQLException;
    boolean eliminar(long id) throws SQLException;
    T getById(long id) throws SQLException;
    List<T> getAll() throws SQLException;
}
