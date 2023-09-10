package org.peronal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "";

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Establish a connection to the MySQL database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the MySQL database!");
        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL database!");
            e.printStackTrace();
        }
    }
}