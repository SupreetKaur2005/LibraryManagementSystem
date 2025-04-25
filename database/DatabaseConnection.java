package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

class DatabaseConnectionCode {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();

                InputStream input = DatabaseConnectionCode.class.getClassLoader().getResourceAsStream("config.properties");
                if (input == null) {
                    throw new IOException("config.properties not found. Create one from config-template.properties.");
                }
                props.load(input);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database is successfully connected");

            } catch (SQLException | IOException e) {
                System.err.println("Connection Failed: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }
}


public class DatabaseConnection {
    public static void main(String[] args) {
        // Attempt to get a connection
        Connection conn = DatabaseConnectionCode.getConnection();

        // Check if the connection is not null
        if (conn != null) {
            System.out.println(" Test: Connection established successfully!");
        } else {
            System.out.println("Test: Connection failed.");
        }

        // Close the connection to clean up
        DatabaseConnectionCode.closeConnection();
    }
}
