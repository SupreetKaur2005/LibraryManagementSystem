package Librarian;

import java.awt.*;
import javax.swing.*;

public class LibrarianDashboard extends JFrame {
    public LibrarianDashboard() {
        setTitle("Librarian Dashboard");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton bookManagementButton = new JButton("Manage Books");
        JButton issueBookButton = new JButton("Issue Book");
        JButton returnBookButton = new JButton("Return Book");
        JButton studentRecordsButton = new JButton("Student Records");
        JButton overdueButton = new JButton("Overdue Records");
        JButton logoutButton = new JButton("Logout");

        add(bookManagementButton);
        add(issueBookButton);
        add(returnBookButton);
        add(studentRecordsButton);
        add(overdueButton);
        add(logoutButton);

        bookManagementButton.addActionListener(e -> new BookManagementPanel());
        issueBookButton.addActionListener(e -> new IssueBookPanel());
        returnBookButton.addActionListener(e -> new ReturnBookPanel());
        studentRecordsButton.addActionListener(e -> new StudentRecordsPanel());
        overdueButton.addActionListener(e -> new OverduePanel());
        logoutButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new LibrarianDashboard();
    }
}
