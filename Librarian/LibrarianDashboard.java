// package Librarian;

// import java.awt.*;
// import javax.swing.*;

// public class LibrarianDashboard extends JFrame {
//     public LibrarianDashboard() {
//         setTitle("Librarian Dashboard");
//         setSize(400, 400);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new GridLayout(6, 1, 10, 10));

//         JButton bookManagementButton = new JButton("Manage Books");
//         JButton issueBookButton = new JButton("Issue Book");
//         JButton returnBookButton = new JButton("Return Book");
//         JButton studentRecordsButton = new JButton("Student Records");
//         JButton overdueButton = new JButton("Overdue Records");
//         JButton logoutButton = new JButton("Logout");

//         add(bookManagementButton);
//         add(issueBookButton);
//         add(returnBookButton);
//         add(studentRecordsButton);
//         add(overdueButton);
//         add(logoutButton);

//         bookManagementButton.addActionListener(e -> new BookManagementPanel());
//         issueBookButton.addActionListener(e -> new IssueBookPanel());
//         returnBookButton.addActionListener(e -> new ReturnBookPanel());
//         studentRecordsButton.addActionListener(e -> new StudentRecordsPanel());
//         overdueButton.addActionListener(e -> new OverduePanel());
//         logoutButton.addActionListener(e -> System.exit(0));

//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         new LibrarianDashboard();
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;
// import ui.MainFrame;

// public class LibrarianDashboard extends JPanel {
//     private MainFrame parentFrame;

//     public LibrarianDashboard(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Librarian Dashboard", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Buttons Panel
//         JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 10));

//         JButton bookManagementButton = new JButton("Manage Books");
//         JButton issueBookButton = new JButton("Issue Book");
//         JButton returnBookButton = new JButton("Return Book");
//         JButton studentRecordsButton = new JButton("Student Records");
//         JButton overdueButton = new JButton("Overdue Records");
//         JButton logoutButton = new JButton("Logout");

//         // Adding buttons to the panel
//         buttonPanel.add(bookManagementButton);
//         buttonPanel.add(issueBookButton);
//         buttonPanel.add(returnBookButton);
//         buttonPanel.add(studentRecordsButton);
//         buttonPanel.add(overdueButton);
//         buttonPanel.add(logoutButton);

//         add(buttonPanel, BorderLayout.CENTER);

//         // Button actions
//         bookManagementButton.addActionListener(e -> parentFrame.openPanel(new BookManagementPanel()));
//         issueBookButton.addActionListener(e -> parentFrame.openPanel(new IssueBookPanel()));
//         returnBookButton.addActionListener(e -> parentFrame.openPanel(new ReturnBookPanel()));
//         studentRecordsButton.addActionListener(e -> parentFrame.openPanel(new StudentRecordsPanel()));
//         overdueButton.addActionListener(e -> parentFrame.openPanel(new OverduePanel()));
//         logoutButton.addActionListener(e -> parentFrame.openPanel(new ui.LoginPanel(parentFrame)));
//     }
// }

package Librarian;

import javax.swing.*;
import java.awt.*;
import ui.MainFrame;

public class LibrarianDashboard extends JPanel {
    private MainFrame parentFrame;

    public LibrarianDashboard(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        // Title label
        JLabel label = new JLabel("Librarian Dashboard", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 10));

        JButton bookManagementButton = new JButton("Manage Books");
        JButton issueBookButton = new JButton("Issue Book");
        JButton returnBookButton = new JButton("Return Book");
        JButton studentRecordsButton = new JButton("Student Records");
        JButton overdueButton = new JButton("Overdue Records");
        JButton logoutButton = new JButton("Logout");

        // Add buttons to the panel
        buttonPanel.add(bookManagementButton);
        buttonPanel.add(issueBookButton);
        buttonPanel.add(returnBookButton);
        buttonPanel.add(studentRecordsButton);
        buttonPanel.add(overdueButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Button actions
        bookManagementButton.addActionListener(e -> parentFrame.openPanel(new BookManagementPanel()));
        issueBookButton.addActionListener(e -> parentFrame.openPanel(new IssueBookPanel()));
        returnBookButton.addActionListener(e -> parentFrame.openPanel(new ReturnBookPanel()));
        studentRecordsButton.addActionListener(e -> parentFrame.openPanel(new StudentRecordsPanel()));
        overdueButton.addActionListener(e -> parentFrame.openPanel(new OverduePanel()));
        logoutButton.addActionListener(e -> parentFrame.openPanel(new ui.LoginPanel(parentFrame)));
    }
}