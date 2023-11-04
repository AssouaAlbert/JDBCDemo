    package org.peronal;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/ericapt6_wpgxx";
        String user = "root";
        String password = "";

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 1. Establish a connection to the MySQL database
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the MySQL database!");
            // 2. Create Statement Object
            Statement myStat = connection.createStatement();

            // 3. Execute Query
            ResultSet myRes =  myStat.executeQuery("select comment_author_email, comment_date, user_id  from yag_comments limit 100;");
            // 4. Process Result Set
            while(myRes.next()){
               String authorEmail = myRes.getNString("comment_author_email");
               Date date = myRes.getDate("comment_date");
               long userId = myRes.getLong("user_id");
                System.out.println(authorEmail + " - " + date + " - " + userId );
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the MySQL database!");
            e.printStackTrace();
        }
    }
}