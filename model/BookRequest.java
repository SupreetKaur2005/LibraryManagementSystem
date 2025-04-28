package model;

import java.time.LocalDate;

public class BookRequest {

    private int id; // Changed from requestId for consistency with DAO
    private int userId; // Changed from studentId for consistency with DAO
    private int bookId; // Added to align with DAO
    private LocalDate requestDate; // Added to align with DAO
    private String status; // Added to align with DAO (e.g., "pending", "approved", "rejected")

    // Constructor for creating a new request
    public BookRequest(int userId, int bookId, LocalDate requestDate, String status) {
        this.userId = userId;
        this.bookId = bookId;
        this.requestDate = requestDate;
        this.status = status;
    }

    // Default constructor
    public BookRequest() {
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

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}