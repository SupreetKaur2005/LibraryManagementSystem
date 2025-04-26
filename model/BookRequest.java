package model;

public class BookRequest {

    private int requestId;
    private int studentId;
    private String bookTitle;
    private boolean isApproved;

    public BookRequest(int requestId, int studentId, String bookTitle, boolean isApproved) {
        this.requestId = requestId;
        this.studentId = studentId;
        this.bookTitle = bookTitle;
        this.isApproved = isApproved;
    }

    public BookRequest() {
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
