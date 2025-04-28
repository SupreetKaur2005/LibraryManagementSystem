package model;

import java.time.LocalDate;

public class Transaction {

    private int id;
    private int userId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;

    // Default constructor
    public Transaction() {
    }

    // Constructor for creating a new transaction
    public Transaction(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = LocalDate.now(); // Set the borrow date to the current date
        this.dueDate = borrowDate.plusWeeks(2); // Default due date is 2 weeks from borrow date
        this.status = "Borrowed"; // Default status
    }

    // Full constructor for initializing all fields
    public Transaction(int id, int userId, int bookId, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}