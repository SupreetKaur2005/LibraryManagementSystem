package model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<Book> borrowedBooks;
    private List<Notification> notifications;

    public Student(int userId, String name, String email, String password, boolean isActive) {
        super(userId, name, email, password, "Student", isActive);
        this.borrowedBooks = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public Student() {
        super();
        this.borrowedBooks = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    // Borrow Book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println("Book " + book.getTitle() + " borrowed by " + this.getName());
    }

    // Return Book and Pay Fine
    public void returnBook(Book book, double fineAmount) {
        borrowedBooks.removeIf(b -> b.getBookId() == book.getBookId());
        if (fineAmount > 0) {
            System.out.println("Fine of " + fineAmount + " paid for book: " + book.getTitle());
        }
        System.out.println("Book " + book.getTitle() + " returned.");
    }

    // View Borrowing Status
    public void viewBorrowingStatus() {
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }

    // Request New Book
    public void requestNewBook(String bookTitle) {
        System.out.println("Request for new book titled '" + bookTitle + "' submitted.");
    }

    // Request Hold on Book (for a week)
    public void requestHoldOnBook(Book book) {
        System.out.println("Request to hold book '" + book.getTitle() + "' for a week.");
    }

    // Reissue Borrowed Book
    public void reissueBook(Book book) {
        System.out.println("Reissue request for book '" + book.getTitle() + "' submitted.");
    }

    // View Notifications
    public void viewNotifications() {
        System.out.println("Notifications for " + this.getName() + ":");
        for (Notification notification : notifications) {
            System.out.println("- " + notification.getMessage());
        }
    }

    // Add Notification
    public void addNotification(String message) {
        Notification notification = new Notification(this.getUserId(), message);
        notifications.add(notification);
        System.out.println("Notification added: " + message);
    }

    // Logout
    public void logout() {
        System.out.println("Student logged out.");
    }
}
