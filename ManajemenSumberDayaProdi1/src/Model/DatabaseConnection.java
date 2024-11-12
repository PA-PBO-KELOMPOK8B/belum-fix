// Package untuk kelas model
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Kelas ini digunakan untuk mengatur koneksi ke database
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/manajemen_prodi";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword";

    // Method untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
