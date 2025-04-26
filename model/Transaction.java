package model;

import java.util.Date;

public class Transaction {

    private int transactionId;
    private int bookId;
    private int userId;
    private Date issueDate;
    private Date returnDate;
    private double fineAmount;

    public Transaction(int transactionId, int bookId, int userId, Date issueDate, Date returnDate, double fineAmount) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    // ✅ New constructor to allow easy creation while issuing
    public Transaction(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.issueDate = new Date();
        this.returnDate = null;
        this.fineAmount = 0.0;
    }

    public Transaction() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }
}
