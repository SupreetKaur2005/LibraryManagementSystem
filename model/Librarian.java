package model;

import java.util.ArrayList;
import java.util.List;

public class Librarian extends User {

    private List<Transaction> transactions = new ArrayList<>();
    private List<Fine> fines = new ArrayList<>();

    public Librarian(int userId, String name, String email, String password) {
        super(userId, name, email, password, "Librarian", true);
    }

    public void issueBook(Student student, Book book) {
        Transaction transaction = new Transaction(student.getUserId(), book.getBookId());
        transactions.add(transaction);
        System.out.println("Book '" + book.getTitle() + "' issued to " + student.getName());
    }

    public void returnBook(Student student, Book book, int daysLate) {
        transactions.removeIf(t -> t.getUserId() == student.getUserId() && t.getBookId() == book.getBookId());

        double fineAmount = daysLate > 0 ? daysLate * 5.0 : 0.0;
        if (fineAmount > 0) {
            Fine fine = new Fine(student.getUserId(), fineAmount);
            fines.add(fine);
            System.out.println("Fine generated: " + fineAmount);
        }
        System.out.println("Book '" + book.getTitle() + "' returned by " + student.getName());
    }
}
