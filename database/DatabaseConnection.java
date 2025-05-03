// // package database;

// // import java.io.IOException;
// // import java.io.InputStream;
// // import java.sql.Connection;
// // import java.sql.DriverManager;
// // import java.sql.SQLException;
// // import java.util.Properties;

// // public class DatabaseConnection {

// //     private static Connection connection = null;

// //     /**
// //      * Establishes and returns a connection to the database.
// //      * 
// //      * @return Connection object
// //      * @throws SQLException if a database access error occurs
// //      */
// //     public static Connection getConnection() {
// //         if (connection == null) {
// //             try {
// //                 Properties props = new Properties();

// //                 // Load database configuration from properties file
// //                 InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties");
// //                 if (input == null) {
// //                     throw new IOException("config.properties not found. Create one from config-template.properties.");
// //                 }
// //                 props.load(input);

// //                 // Retrieve credentials from the properties file
// //                 String url = props.getProperty("db.url");
// //                 String user = props.getProperty("db.user");
// //                 String password = props.getProperty("db.password");

// //                 // Establish a database connection
// //                 connection = DriverManager.getConnection(url, user, password);
// //                 System.out.println("Database is successfully connected");

// //             } catch (SQLException | IOException e) {
// //                 System.err.println("Connection Failed: " + e.getMessage());
// //             }
// //         }
// //         return connection;
// //     }

// //     /**
// //      * Closes the database connection if it is open.
// //      */
// //     public static void closeConnection() {
// //         try {
// //             if (connection != null && !connection.isClosed()) {
// //                 connection.close();
// //                 System.out.println("Database connection closed.");
// //             }
// //         } catch (SQLException e) {
// //             System.err.println("Error closing database connection: " + e.getMessage());
// //         }
// //     }

// //     public static void main(String[] args) {
// //         // Test the database connection
// //         Connection conn = DatabaseConnection.getConnection();

// //         if (conn != null) {
// //             System.out.println("Test: Connection established successfully!");
// //         } else {
// //             System.out.println("Test: Connection failed.");
// //         }

// //         // Close the connection after testing
// //         DatabaseConnection.closeConnection();
// //     }
// // }

// package database;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.util.Properties;
// import java.io.InputStream;
// import java.io.IOException;

// public class DatabaseConnection {

//     private static Connection connection = null;

//     /**
//      * Establishes and returns a connection to the database.
//      * 
//      * @return Connection object
//      * @throws SQLException if a database access error occurs
//      */
//     public static Connection getConnection() {
//         if (connection == null) {
//             try {
//                 Properties props = new Properties();

//                 // Load database configuration from properties file
//                 InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties");
//                 if (input == null) {
//                     throw new IOException("config.properties not found. Create one from config-template.properties.");
//                 }
//                 props.load(input);

//                 // Retrieve credentials from the properties file
//                 String url = props.getProperty("db.url");
//                 String user = props.getProperty("db.user");
//                 String password = props.getProperty("db.password");

//                 // Establish a database connection
//                 connection = DriverManager.getConnection(url, user, password);
//                 System.out.println("Database is successfully connected");

//             } catch (SQLException | IOException e) {
//                 System.err.println("Connection Failed: " + e.getMessage());
//             }
//         }
//         return connection;
//     }

//     /**
//      * Closes the database connection if it is open.
//      */
//     public static void closeConnection() {
//         try {
//             if (connection != null && !connection.isClosed()) {
//                 connection.close();
//                 System.out.println("Database connection closed.");
//             }
//         } catch (SQLException e) {
//             System.err.println("Error closing database connection: " + e.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         // Test the database connection
//         Connection conn = DatabaseConnection.getConnection();

//         if (conn != null) {
//             System.out.println("Test: Connection established successfully!");
//         } else {
//             System.out.println("Test: Connection failed.");
//         }

//         // Close the connection after testing
//         DatabaseConnection.closeConnection();
//     }
// }


package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection connection = null;

    /**
     * Establishes and returns a connection to the database.
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();

                // Load database configuration from properties file
                InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties");
                if (input == null) {
                    throw new IOException("config.properties not found. Create one from config-template.properties.");
                }
                props.load(input);

                // Retrieve credentials from the properties file
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String password = props.getProperty("db.password");
                String databaseName = url.substring(url.lastIndexOf("/") + 1);

                // Driver registration (optional in newer JDBC versions)
                String driverClassName = props.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
                Class.forName(driverClassName);

                // Connect without specifying the database to check/create it
                String baseUrl = url.substring(0, url.lastIndexOf("/") + 1);
                Connection tempConnection = DriverManager.getConnection(baseUrl, user, password);

                // Create the database if it doesn't exist
                try (Statement stmt = tempConnection.createStatement()) {
                    String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + databaseName;
                    stmt.executeUpdate(createDatabaseSQL);
                    System.out.println("Database checked and created if not exists: " + databaseName);
                }

                // Close the temporary connection and reconnect with the database
                tempConnection.close();

                // Establish the final connection
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database is successfully connected");

            } catch (ClassNotFoundException e) {
                System.err.println("Error: MySQL JDBC Driver not found");
                e.printStackTrace();
            } catch (SQLException | IOException e) {
                System.err.println("Error: Database connection failed");
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Closes the database connection if it is open.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Test the database connection
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Test: Connection established successfully!");
        } else {
            System.out.println("Test: Connection failed.");
        }

        // Close the connection after testing
        DatabaseConnection.closeConnection();
    }
}