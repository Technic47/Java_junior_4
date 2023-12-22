package ru.gb.lesson4.hw.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
        "jdbc:h2:mem:books.db;DB_CLOSE_DELAY=-1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
