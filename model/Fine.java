package model;

import java.util.Date;

public class Fine {

    private int id; // Renamed from fineId to match DAO
    private int transactionId; // Added to align with DAO
    private double amount;
    private String status; // Added to align with DAO
    private Date fineDate;

    public Fine(int id, int transactionId, double amount, String status, Date fineDate) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
        this.fineDate = fineDate;
    }

    // ✅ New constructor for quick fine creation
    public Fine(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = "Unpaid"; // Default status
        this.fineDate = new Date(); // fine date as today
    }

    public Fine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }
}