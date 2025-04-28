package model;

import java.time.LocalDateTime;

public class Notification {

    private int id; // Changed from notificationId
    private int userId;
    private String message;
    private String type; // Added to align with DAO
    private LocalDateTime dateSent; // Added to align with DAO
    private String status; // Added to align with DAO

    public Notification(int userId, String message, String type) {
        this.userId = userId;
        this.message = message;
        this.type = type;
        this.dateSent = LocalDateTime.now();
        this.status = "Unread"; // Default status
    }

    public Notification() {}

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDateTime dateSent) {
        this.dateSent = dateSent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}