package model;

import java.util.Date;

public class Fine {

    private int fineId;
    private int userId;
    private double amount;
    private Date fineDate;

    public Fine(int fineId, int userId, double amount, Date fineDate) {
        this.fineId = fineId;
        this.userId = userId;
        this.amount = amount;
        this.fineDate = fineDate;
    }

    // ✅ New constructor for quick fine creation
    public Fine(int userId, double amount) {
        this.userId = userId;
        this.amount = amount;
        this.fineDate = new Date(); // fine date as today
    }

    public Fine() {
    }

    public int getFineId() {
        return fineId;
    }

    public void setFineId(int fineId) {
        this.fineId = fineId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getFineDate() {
        return fineDate;
    }

    public void setFineDate(Date fineDate) {
        this.fineDate = fineDate;
    }
}
