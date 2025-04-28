package model;

import java.util.ArrayList;
import java.util.List;

public class Librarian extends User {

    private final List<Transaction> transactions = new ArrayList<>();
    private final List<Fine> fines = new ArrayList<>();

    public Librarian(int userId, String name, String email, String password) {
        super(userId, name, email, password, "Librarian", true);
    }

    // Issue a book to a student
    public void issueBook(Student student, Book book) {
        Transaction transaction = new Transaction(student.getUserId(), book.getBookId());
        transaction.setBorrowDate(java.time.LocalDate.now());
        transaction.setDueDate(transaction.getBorrowDate().plusWeeks(2)); // Adding a due date
        transaction.setStatus("Borrowed"); // Setting default status

        transactions.add(transaction);
        System.out.println("Book '" + book.getTitle() + "' issued to " + student.getName());
    }

    // Return a book from a student and calculate fine if applicable
    public void returnBook(Student student, Book book, int daysLate) {
        transactions.removeIf(transaction ->
            transaction.getUserId() == student.getUserId() &&
            transaction.getBookId() == book.getBookId()
        );

        double fineAmount = calculateFine(daysLate);
        if (fineAmount > 0) {
            Fine fine = new Fine(student.getUserId(), fineAmount);
            fines.add(fine);
            System.out.println("Fine generated: $" + fineAmount);
        }

        System.out.println("Book '" + book.getTitle() + "' returned by " + student.getName());
    }

    // Calculate fine for late returns
    private double calculateFine(int daysLate) {
        final double FINE_PER_DAY = 5.0;  // Fine amount can be adjusted here
        return daysLate > 0 ? daysLate * FINE_PER_DAY : 0.0;
    }

    // Get all transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Get all fines
    public List<Fine> getFines() {
        return fines;
    }
}