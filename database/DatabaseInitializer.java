// package database;

// import java.sql.Connection;
// import java.sql.Statement;

// public class DatabaseInitializer {

//     @SuppressWarnings("CallToPrintStackTrace")
//     public static void initializeDatabase() {
//         try (Connection connection = DatabaseConnection.getConnection();
//              Statement statement = connection.createStatement()) {

//             // Create schema
//             createSchema(statement);

//             // Insert initial data
//             insertInitialData(statement);

//             System.out.println("Database schema created and initial data inserted successfully!");

//         } catch (Exception e) {
//             e.printStackTrace();  // Prints the stack trace of the exception
//         }
//     }

//     private static void createSchema(Statement statement) throws Exception {
//         String schemaSQL = """
//             -- User Table
//             CREATE TABLE IF NOT EXISTS User (
//                 user_id INT PRIMARY KEY AUTO_INCREMENT,
//                 username VARCHAR(50) UNIQUE NOT NULL,
//                 password VARCHAR(100) NOT NULL,
//                 name VARCHAR(100),
//                 email VARCHAR(100) UNIQUE,
//                 role ENUM('Admin', 'Librarian', 'Student') NOT NULL,
//                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//             );

//             -- Admin Table
//             CREATE TABLE IF NOT EXISTS Admin (
//                 admin_id INT PRIMARY KEY,
//                 FOREIGN KEY (admin_id) REFERENCES User(user_id) ON DELETE CASCADE
//             );

//             -- Librarian Table
//             CREATE TABLE IF NOT EXISTS Librarian (
//                 librarian_id INT PRIMARY KEY,
//                 FOREIGN KEY (librarian_id) REFERENCES User(user_id) ON DELETE CASCADE
//             );

//             -- Student Table
//             CREATE TABLE IF NOT EXISTS Student (
//                 student_id INT PRIMARY KEY,
//                 course VARCHAR(100),
//                 year INT,
//                 FOREIGN KEY (student_id) REFERENCES User(user_id) ON DELETE CASCADE
//             );

//             -- Book Table
//             CREATE TABLE IF NOT EXISTS Book (
//                 book_id INT PRIMARY KEY AUTO_INCREMENT,
//                 title VARCHAR(255) NOT NULL,
//                 author VARCHAR(255),
//                 publisher VARCHAR(255),
//                 isbn VARCHAR(20) UNIQUE,
//                 genre VARCHAR(50),
//                 total_copies INT DEFAULT 1,
//                 available_copies INT DEFAULT 1,
//                 added_date DATE DEFAULT CURRENT_DATE
//             );

//             -- Transaction Table
//             CREATE TABLE IF NOT EXISTS Transaction (
//                 transaction_id INT PRIMARY KEY AUTO_INCREMENT,
//                 book_id INT NOT NULL,
//                 student_id INT NOT NULL,
//                 issue_date DATE NOT NULL,
//                 due_date DATE NOT NULL,
//                 return_date DATE,
//                 FOREIGN KEY (book_id) REFERENCES Book(book_id),
//                 FOREIGN KEY (student_id) REFERENCES Student(student_id)
//             );

//             -- Fine Table
//             CREATE TABLE IF NOT EXISTS Fine (
//                 fine_id INT PRIMARY KEY AUTO_INCREMENT,
//                 transaction_id INT NOT NULL,
//                 amount DECIMAL(10,2) NOT NULL,
//                 is_paid BOOLEAN DEFAULT FALSE,
//                 FOREIGN KEY (transaction_id) REFERENCES Transaction(transaction_id)
//             );

//             -- Notification Table
//             CREATE TABLE IF NOT EXISTS Notification (
//                 notification_id INT PRIMARY KEY AUTO_INCREMENT,
//                 user_id INT NOT NULL,
//                 message TEXT,
//                 sent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//                 is_read BOOLEAN DEFAULT FALSE,
//                 FOREIGN KEY (user_id) REFERENCES User(user_id)
//             );

//             -- BookRequest Table
//             CREATE TABLE IF NOT EXISTS BookRequest (
//                 request_id INT PRIMARY KEY AUTO_INCREMENT,
//                 student_id INT NOT NULL,
//                 book_title VARCHAR(255),
//                 author VARCHAR(255),
//                 request_date DATE DEFAULT CURRENT_DATE,
//                 status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
//                 FOREIGN KEY (student_id) REFERENCES Student(student_id)
//             );

//             -- BookRating Table
//             CREATE TABLE IF NOT EXISTS BookRating (
//                 rating_id INT PRIMARY KEY AUTO_INCREMENT,
//                 book_id INT NOT NULL,
//                 student_id INT NOT NULL,
//                 rating INT CHECK (rating BETWEEN 1 AND 5),
//                 review TEXT,
//                 rating_date DATE DEFAULT CURRENT_DATE,
//                 FOREIGN KEY (book_id) REFERENCES Book(book_id),
//                 FOREIGN KEY (student_id) REFERENCES Student(student_id)
//             );
//         """;

//         statement.executeUpdate(schemaSQL);
//     }

//     private static void insertInitialData(Statement statement) throws Exception {
//         String initialDataSQL = """
//             -- Insert Users
//             INSERT INTO User (username, password, name, email, role)
//             VALUES
//                 ('admin01', 'adminpass', 'Alice Admin', 'admin@highracy.com', 'Admin'),
//                 ('lib01', 'libpass', 'Bob Librarian', 'librarian@highracy.com', 'Librarian'),
//                 ('stud01', 'studpass', 'Charlie Student', 'charlie@student.com', 'Student');

//             -- Link Admin
//             INSERT INTO Admin (admin_id)
//             SELECT user_id FROM User WHERE username = 'admin01';

//             -- Link Librarian
//             INSERT INTO Librarian (librarian_id)
//             SELECT user_id FROM User WHERE username = 'lib01';

//             -- Link Student
//             INSERT INTO Student (student_id, course, year)
//             SELECT user_id, 'Computer Science', 2 FROM User WHERE username = 'stud01';

//             -- Insert Books
//             INSERT INTO Book (title, author, publisher, isbn, genre, total_copies, available_copies)
//             VALUES
//                 ('Clean Code', 'Robert C. Martin', 'Prentice Hall', '9780132350884', 'Programming', 5, 5),
//                 ('The Pragmatic Programmer', 'Andrew Hunt & David Thomas', 'Addison-Wesley', '9780201616224', 'Software Engineering', 3, 3),
//                 ('Introduction to Algorithms', 'Cormen et al.', 'MIT Press', '9780262033848', 'Algorithms', 4, 4);

//             -- Issue Book to Student
//             INSERT INTO Transaction (book_id, student_id, issue_date, due_date)
//             VALUES (
//                 (SELECT book_id FROM Book WHERE title = 'Clean Code'),
//                 (SELECT student_id FROM Student WHERE student_id = (SELECT user_id FROM User WHERE username = 'stud01')),
//                 '2025-04-01',
//                 '2025-04-15'
//             );

//             -- Add Notification
//             INSERT INTO Notification (user_id, message)
//             VALUES (
//                 (SELECT user_id FROM User WHERE username = 'stud01'),
//                 'Welcome to Highracy! Your library account has been created.'
//             );

//             -- Book Request
//             INSERT INTO BookRequest (student_id, book_title, author)
//             VALUES (
//                 (SELECT student_id FROM Student WHERE student_id = (SELECT user_id FROM User WHERE username = 'stud01')),
//                 'Artificial Intelligence: A Modern Approach',
//                 'Stuart Russell & Peter Norvig'
//             );

//             -- Book Rating
//             INSERT INTO BookRating (book_id, student_id, rating, review)
//             VALUES (
//                 (SELECT book_id FROM Book WHERE title = 'Clean Code'),
//                 (SELECT student_id FROM Student WHERE student_id = (SELECT user_id FROM User WHERE username = 'stud01')),
//                 5,
//                 'Excellent book for writing maintainable code!'
//             );
//         """;

//         statement.executeUpdate(initialDataSQL);
//     }
// }

// package database;

// import java.sql.Connection;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class DatabaseInitializer {

//     public static void initializeDatabase() {
//         Connection con = null;
//         Statement st = null;

//         try {
//             // Get the connection
//             con = DatabaseConnection.getConnection();
//             st = con.createStatement();

//             // Create schema
//             createSchema(st);

//             // Insert initial data
//             insertInitialData(st);

//             System.out.println("Database schema created and initial data inserted successfully!");

//         } catch (SQLException e) {
//             System.err.println("Error: Database initialization failed");
//             e.printStackTrace();
//         } finally {
//             // Close resources
//             try {
//                 if (st != null)
//                     st.close();
//                 if (con != null)
//                     DatabaseConnection.closeConnection();
//                 System.out.println("---Database initialization completed---");
//             } catch (SQLException e) {
//                 System.err.println("Error closing resources");
//                 e.printStackTrace();
//             }
//         }
//     }

//     private static void createSchema(Statement st) throws SQLException {
//         String[] schemaStatements = {
//                 "CREATE TABLE IF NOT EXISTS User (" +
//                         "user_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "username VARCHAR(50) UNIQUE NOT NULL," +
//                         "password VARCHAR(100) NOT NULL," +
//                         "name VARCHAR(100)," +
//                         "email VARCHAR(100) UNIQUE," +
//                         "role ENUM('Admin', 'Librarian', 'Student') NOT NULL," +
//                         "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS Admin (" +
//                         "admin_id INT PRIMARY KEY," +
//                         "FOREIGN KEY (admin_id) REFERENCES User(user_id) ON DELETE CASCADE" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS Librarian (" +
//                         "librarian_id INT PRIMARY KEY," +
//                         "FOREIGN KEY (librarian_id) REFERENCES User(user_id) ON DELETE CASCADE" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS Student (" +
//                         "student_id INT PRIMARY KEY," +
//                         "course VARCHAR(100)," +
//                         "year INT," +
//                         "FOREIGN KEY (student_id) REFERENCES User(user_id) ON DELETE CASCADE" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS Book (" +
//                         "book_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "title VARCHAR(255) NOT NULL," +
//                         "author VARCHAR(255)," +
//                         "publisher VARCHAR(255)," +
//                         "isbn VARCHAR(20) UNIQUE," +
//                         "genre VARCHAR(50)," +
//                         "total_copies INT DEFAULT 1," +
//                         "available_copies INT DEFAULT 1," +
//                         "added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS BookTransaction (" +
//                         "transaction_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "book_id INT NOT NULL," +
//                         "student_id INT NOT NULL," +
//                         "issue_date DATE NOT NULL," +
//                         "due_date DATE NOT NULL," +
//                         "return_date DATE," +
//                         "FOREIGN KEY (book_id) REFERENCES Book(book_id)," +
//                         "FOREIGN KEY (student_id) REFERENCES Student(student_id)" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS Fine (" +
//                         "fine_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "transaction_id INT NOT NULL," +
//                         "amount DECIMAL(10,2) NOT NULL," +
//                         "is_paid BOOLEAN DEFAULT FALSE," +
//                         "FOREIGN KEY (transaction_id) REFERENCES Transaction(transaction_id)" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS Notification (" +
//                         "notification_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "user_id INT NOT NULL," +
//                         "message TEXT," +
//                         "sent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
//                         "is_read BOOLEAN DEFAULT FALSE," +
//                         "FOREIGN KEY (user_id) REFERENCES User(user_id)" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS BookRequest (" +
//                         "request_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "student_id INT NOT NULL," +
//                         "book_title VARCHAR(255)," +
//                         "author VARCHAR(255)," +
//                         "request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
//                         "status ENUM('Pending','Approved','Rejected') DEFAULT 'Pending'," +
//                         "FOREIGN KEY (student_id) REFERENCES Student(student_id)" +
//                         ") ENGINE=InnoDB",
//                 "CREATE TABLE IF NOT EXISTS BookRating (" +
//                         "rating_id INT PRIMARY KEY AUTO_INCREMENT," +
//                         "book_id INT NOT NULL," +
//                         "student_id INT NOT NULL," +
//                         "rating INT CHECK (rating BETWEEN 1 AND 5)," +
//                         "review TEXT," +
//                         "rating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
//                         "FOREIGN KEY (book_id) REFERENCES Book(book_id)," +
//                         "FOREIGN KEY (student_id) REFERENCES Student(student_id)" +
//                         ") ENGINE=InnoDB"
//         };
//         for (String sql : schemaStatements) {
//             st.executeUpdate(sql);
//         }
//     }

//     private static void insertInitialData(Statement st) throws SQLException {
//         String userDataSQL = """
//                     INSERT INTO User (username, password, name, email, role)
//                     VALUES ('admin', 'admin123', 'Admin User', 'admin@library.com', 'Admin')
//                     ON DUPLICATE KEY UPDATE username=username;
//                 """;
//         st.executeUpdate(userDataSQL);
//     }

//     public static void main(String[] args) {
//         System.out.println("Initializing the database...");
//         initializeDatabase();
//     }
// }

package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    /**
     * Initializes the database by creating necessary tables and inserting initial data.
     */
    public static void initialize() {
        Connection con = null;
        Statement st = null;

        try {
            // Get the connection
            con = DatabaseConnection.getConnection();
            st = con.createStatement();

            // Create schema
            createSchema(st);

            // Insert initial data
            insertInitialData(st);

            System.out.println("Database schema created and initial data inserted successfully!");

        } catch (SQLException e) {
            System.err.println("Error: Database initialization failed");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (st != null)
                    st.close();
                if (con != null)
                    DatabaseConnection.closeConnection();
                System.out.println("---Database initialization completed---");
            } catch (SQLException e) {
                System.err.println("Error closing resources");
                e.printStackTrace();
            }
        }
    }

    private static void createSchema(Statement st) throws SQLException {
        String[] schemaStatements = {
                "CREATE TABLE IF NOT EXISTS User (" +
                        "user_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "username VARCHAR(50) UNIQUE NOT NULL," +
                        "password VARCHAR(100) NOT NULL," +
                        "name VARCHAR(100)," +
                        "email VARCHAR(100) UNIQUE," +
                        "role ENUM('Admin', 'Librarian', 'Student') NOT NULL," +
                        "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS Admin (" +
                        "admin_id INT PRIMARY KEY," +
                        "FOREIGN KEY (admin_id) REFERENCES User(user_id) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS Librarian (" +
                        "librarian_id INT PRIMARY KEY," +
                        "FOREIGN KEY (librarian_id) REFERENCES User(user_id) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS Student (" +
                        "student_id INT PRIMARY KEY," +
                        "course VARCHAR(100)," +
                        "year INT," +
                        "FOREIGN KEY (student_id) REFERENCES User(user_id) ON DELETE CASCADE" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS Book (" +
                        "book_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "title VARCHAR(255) NOT NULL," +
                        "author VARCHAR(255)," +
                        "publisher VARCHAR(255)," +
                        "isbn VARCHAR(20) UNIQUE," +
                        "genre VARCHAR(50)," +
                        "total_copies INT DEFAULT 1," +
                        "available_copies INT DEFAULT 1," +
                        "added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS BookTransaction (" +
                        "transaction_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "book_id INT NOT NULL," +
                        "student_id INT NOT NULL," +
                        "issue_date DATE NOT NULL," +
                        "due_date DATE NOT NULL," +
                        "return_date DATE," +
                        "FOREIGN KEY (book_id) REFERENCES Book(book_id)," +
                        "FOREIGN KEY (student_id) REFERENCES Student(student_id)" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS Fine (" +
                        "fine_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "transaction_id INT NOT NULL," +
                        "amount DECIMAL(10,2) NOT NULL," +
                        "is_paid BOOLEAN DEFAULT FALSE," +
                        "FOREIGN KEY (transaction_id) REFERENCES BookTransaction(transaction_id)" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS Notification (" +
                        "notification_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "user_id INT NOT NULL," +
                        "message TEXT," +
                        "sent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                        "is_read BOOLEAN DEFAULT FALSE," +
                        "FOREIGN KEY (user_id) REFERENCES User(user_id)" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS BookRequest (" +
                        "request_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "student_id INT NOT NULL," +
                        "book_title VARCHAR(255)," +
                        "author VARCHAR(255)," +
                        "request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                        "status ENUM('Pending','Approved','Rejected') DEFAULT 'Pending'," +
                        "FOREIGN KEY (student_id) REFERENCES Student(student_id)" +
                        ") ENGINE=InnoDB",
                "CREATE TABLE IF NOT EXISTS BookRating (" +
                        "rating_id INT PRIMARY KEY AUTO_INCREMENT," +
                        "book_id INT NOT NULL," +
                        "student_id INT NOT NULL," +
                        "rating INT CHECK (rating BETWEEN 1 AND 5)," +
                        "review TEXT," +
                        "rating_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                        "FOREIGN KEY (book_id) REFERENCES Book(book_id)," +
                        "FOREIGN KEY (student_id) REFERENCES Student(student_id)" +
                        ") ENGINE=InnoDB"
        };
        for (String sql : schemaStatements) {
            st.executeUpdate(sql);
        }
    }

    private static void insertInitialData(Statement st) throws SQLException {
        String userDataSQL = """
                    INSERT INTO User (username, password, name, email, role)
                    VALUES ('admin', 'admin123', 'Admin User', 'admin@library.com', 'Admin')
                    ON DUPLICATE KEY UPDATE username=username;
                """;
        st.executeUpdate(userDataSQL);
    }

    public static void main(String[] args) {
        System.out.println("Initializing the database...");
        initialize();
    }
}