-- schema.sql for Highracy Library Management System (MySQL)
-- ----------------------------------------------------------
-- Author: Your Name
-- Created: 2025-04-22
-- Description: Defines the schema for users, books, transactions, fines, and more.

-- Drop tables if they exist (in correct order)
DROP TABLE IF EXISTS BookRating;
DROP TABLE IF EXISTS BookRequest;
DROP TABLE IF EXISTS Notification;
DROP TABLE IF EXISTS Fine;
DROP TABLE IF EXISTS Transaction;
DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Librarian;
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS User;

-- ----------------------------------------------------------
-- Base User Table
-- ----------------------------------------------------------
CREATE TABLE User (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    role ENUM('Admin', 'Librarian', 'Student') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Admin (inherits User)
-- ----------------------------------------------------------
CREATE TABLE Admin (
    admin_id INT PRIMARY KEY,
    FOREIGN KEY (admin_id) REFERENCES User(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Librarian (inherits User)
-- ----------------------------------------------------------
CREATE TABLE Librarian (
    librarian_id INT PRIMARY KEY,
    FOREIGN KEY (librarian_id) REFERENCES User(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Student (inherits User)
-- ----------------------------------------------------------
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    course VARCHAR(100),
    year INT,
    FOREIGN KEY (student_id) REFERENCES User(user_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Book Table
-- ----------------------------------------------------------
CREATE TABLE Book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    publisher VARCHAR(255),
    isbn VARCHAR(20) UNIQUE,
    genre VARCHAR(50),
    total_copies INT DEFAULT 1,
    available_copies INT DEFAULT 1,
    added_date DATE DEFAULT CURRENT_DATE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Transaction Table
-- ----------------------------------------------------------
CREATE TABLE Transaction (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    student_id INT NOT NULL,
    issue_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Fine Table
-- ----------------------------------------------------------
CREATE TABLE Fine (
    fine_id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    is_paid BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (transaction_id) REFERENCES Transaction(transaction_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- Notification Table
-- ----------------------------------------------------------
CREATE TABLE Notification (
    notification_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    message TEXT,
    sent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_read BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES User(user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- BookRequest Table
-- ----------------------------------------------------------
CREATE TABLE BookRequest (
    request_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    book_title VARCHAR(255),
    author VARCHAR(255),
    request_date DATE DEFAULT CURRENT_DATE,
    status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------------------------------------
-- BookRating Table
-- ----------------------------------------------------------
CREATE TABLE BookRating (
    rating_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    student_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    review TEXT,
    rating_date DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (book_id) REFERENCES Book(book_id),
    FOREIGN KEY (student_id) REFERENCES Student(student_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- End of schema.sql
