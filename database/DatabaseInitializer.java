package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DatabaseInitializer {
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String DB_NAME;

    public static void main(String[] args) {
        loadConfig();
        createDatabase();
        createTables();
    }

    private static void loadConfig() {
        try {
            Properties props = new Properties();
            InputStream input = DatabaseInitializer.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new IOException("config.properties not found. Please create it from config-template.properties.");
            }
            props.load(input);

            URL = props.getProperty("db.baseurl"); 
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");
            DB_NAME = props.getProperty("db.name");

        } catch (IOException e) {
            System.err.println("Error loading config: " + e.getMessage());
            System.exit(1);
        }
    }


    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(sql);
            System.out.println("Database created or already exists.");

        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    public static void createTables() {
        String dbUrl = URL + DB_NAME;
        try (Connection conn = DriverManager.getConnection(dbUrl, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR(255) NOT NULL," +
                    "author VARCHAR(255)," +
                    "published_year INT" +
                    ")";
            stmt.executeUpdate(createBooksTable);
            System.out.println("Tables created or already exist.");

        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }
}
