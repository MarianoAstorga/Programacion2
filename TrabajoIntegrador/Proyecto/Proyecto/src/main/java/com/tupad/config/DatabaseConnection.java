package com.tupad.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static final Properties props = new Properties();
    static {
        try (InputStream in = DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (in == null) throw new RuntimeException("No se encontró database.properties en resources");
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Error cargando database.properties: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, pass);
    }
}
