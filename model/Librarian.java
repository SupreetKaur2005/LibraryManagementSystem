package model;

import java.util.ArrayList;
import java.util.List;

public class Librarian extends User {

    private List<Book> books;
    private List<Transaction> issuedBooks;
    private List<Student> students;

    public Librarian(int userId, String name, String email, String password, boolean isActive) {
        super(userId, name, email, password, "Librarian", isActive);
        this.books = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Librarian() {
        super();
        this.books = new ArrayList<>();
        this.issuedBooks = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Transaction> getIssuedBooks() {
        return issuedBooks;
    }

    public void setIssuedBooks(List<Transaction> issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // View Books
    public List<Book> viewBooks() {
        return books;
    }

    // Delete Book
    public boolean deleteBook(int bookId) {
        return books.removeIf(book -> book.getBookId() == bookId);
    }

    // Issue Book to Student
    public void issueBook(Student student, Book book) {
        Transaction transaction = new Transaction(student.getUserId(), book.getBookId());
        issuedBooks.add(transaction);
        System.out.println("Book " + book.getTitle() + " issued to " + student.getName());
    }

    // Return Book and Calculate Fine
    public double returnBook(Student student, Book book, int daysLate) {
        issuedBooks.removeIf(t -> t.getStudentId() == student.getUserId() && t.getBookId() == book.getBookId());
        double fineAmount = daysLate > 0 ? daysLate * 5.0 : 0.0; // 5 currency units per day
        if (fineAmount > 0) {
            Fine fine = new Fine(student.getUserId(), fineAmount);
            System.out.println("Fine generated: " + fineAmount);
        }
        System.out.println("Book " + book.getTitle() + " returned by " + student.getName());
        return fineAmount;
    }

    // Manage Student Records (Add Student)
    public void addStudent(Student student) {
        students.add(student);
    }

    // View Students
    public List<Student> viewStudents() {
        return students;
    }

    // Request Approval (dummy)
    public void requestApproval() {
        System.out.println("Approval requested for operations.");
    }

    // View Overdue Books (dummy)
    public void viewOverdueBooks() {
        System.out.println("Viewing overdue books...");
    }

    // Notify Students about Overdue Books
    public void notifyStudent(Student student, String message) {
        Notification notification = new Notification(student.getUserId(), message);
        System.out.println("Notification sent to " + student.getName() + ": " + message);
    }

    // Logout
    public void logout() {
        System.out.println("Librarian logged out.");
    }
}
