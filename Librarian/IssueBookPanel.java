// package Librarian;

// import javax.swing.*;

// public class IssueBookPanel extends JFrame {
//     public IssueBookPanel() {
//         setTitle("Issue Book");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Issue Book to Student");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class IssueBookPanel extends JPanel {
//     public IssueBookPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Issue Book", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("Issue Book to Student", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }

package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IssueBookPanel extends JPanel {
    private MainFrame parentFrame;
    
    // Form components
    private JTextField bookIdField;
    private JTextField bookTitleField;
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField issueDateField;
    private JTextField dueDateField;
    private JButton searchBookButton;
    private JButton searchStudentButton;
    private JButton issueButton;
    private JButton clearButton;
    
    public IssueBookPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());
        
        // Title Label
        JLabel titleLabel = new JLabel("Issue Book", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        // Main Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Book Details Section
        JPanel bookDetailsPanel = createSectionPanel("Book Details");
        JPanel bookFormPanel = new JPanel(new GridBagLayout());
        
        // Book ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        bookFormPanel.add(new JLabel("Book ID:"), gbc);
        
        gbc.gridx = 1;
        bookIdField = new JTextField(15);
        bookFormPanel.add(bookIdField, gbc);
        
        gbc.gridx = 2;
        searchBookButton = new JButton("Search");
        searchBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
        bookFormPanel.add(searchBookButton, gbc);
        
        // Book Title
        gbc.gridx = 0;
        gbc.gridy = 1;
        bookFormPanel.add(new JLabel("Book Title:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        bookTitleField = new JTextField(20);
        bookTitleField.setEditable(false);
        bookFormPanel.add(bookTitleField, gbc);
        
        bookDetailsPanel.add(bookFormPanel);
        
        // Student Details Section
        JPanel studentDetailsPanel = createSectionPanel("Student Details");
        JPanel studentFormPanel = new JPanel(new GridBagLayout());
        
        // Student ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        studentFormPanel.add(new JLabel("Student ID:"), gbc);
        
        gbc.gridx = 1;
        studentIdField = new JTextField(15);
        studentFormPanel.add(studentIdField, gbc);
        
        gbc.gridx = 2;
        searchStudentButton = new JButton("Search");
        searchStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });
        studentFormPanel.add(searchStudentButton, gbc);
        
        // Student Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        studentFormPanel.add(new JLabel("Student Name:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        studentNameField = new JTextField(20);
        studentNameField.setEditable(false);
        studentFormPanel.add(studentNameField, gbc);
        
        studentDetailsPanel.add(studentFormPanel);
        
        // Issue Details Section
        JPanel issueDetailsPanel = createSectionPanel("Issue Details");
        JPanel issueFormPanel = new JPanel(new GridBagLayout());
        
        // Issue Date
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        issueFormPanel.add(new JLabel("Issue Date:"), gbc);
        
        gbc.gridx = 1;
        issueDateField = new JTextField(20);
        issueDateField.setEditable(false);
        // Set current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        issueDateField.setText(dateFormat.format(new Date()));
        issueFormPanel.add(issueDateField, gbc);
        
        // Due Date
        gbc.gridx = 0;
        gbc.gridy = 1;
        issueFormPanel.add(new JLabel("Due Date:"), gbc);
        
        gbc.gridx = 1;
        dueDateField = new JTextField(20);
        dueDateField.setEditable(false);
        // Set due date (current date + 14 days)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        dueDateField.setText(dateFormat.format(calendar.getTime()));
        issueFormPanel.add(dueDateField, gbc);
        
        issueDetailsPanel.add(issueFormPanel);
        
        // Add all sections to the form panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        formPanel.add(bookDetailsPanel, gbc);
        
        gbc.gridy = 1;
        formPanel.add(studentDetailsPanel, gbc);
        
        gbc.gridy = 2;
        formPanel.add(issueDetailsPanel, gbc);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        issueButton = new JButton("Issue Book");
        issueButton.setBackground(new Color(46, 125, 50));
        issueButton.setForeground(Color.WHITE);
        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueBook();
            }
        });
        buttonPanel.add(issueButton);
        
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        buttonPanel.add(clearButton);
        
        gbc.gridy = 3;
        formPanel.add(buttonPanel, gbc);
        
        // Add the form panel to the center
        add(formPanel, BorderLayout.CENTER);
        
        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
    
    // Helper method to create a section panel with title
    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }
    
    // Method to search for a book
    private void searchBook() {
        String bookId = bookIdField.getText().trim();
        if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Book ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // TODO: Implement actual database search logic
        // For now, we'll just simulate a search result
        if (bookId.equals("B001")) {
            bookTitleField.setText("Introduction to Java Programming");
        } else if (bookId.equals("B002")) {
            bookTitleField.setText("Data Structures and Algorithms");
        } else {
            JOptionPane.showMessageDialog(this, "Book not found", "Error", JOptionPane.ERROR_MESSAGE);
            bookTitleField.setText("");
        }
    }
    
    // Method to search for a student
    private void searchStudent() {
        String studentId = studentIdField.getText().trim();
        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // TODO: Implement actual database search logic
        // For now, we'll just simulate a search result
        if (studentId.equals("S001")) {
            studentNameField.setText("John Doe");
        } else if (studentId.equals("S002")) {
            studentNameField.setText("Jane Smith");
        } else {
            JOptionPane.showMessageDialog(this, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
            studentNameField.setText("");
        }
    }
    
    // Method to issue a book
    private void issueBook() {
        if (bookTitleField.getText().isEmpty() || studentNameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please search for valid book and student first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // TODO: Implement actual database logic to issue the book
        
        JOptionPane.showMessageDialog(this, 
            "Book '" + bookTitleField.getText() + "' has been issued to " + 
            studentNameField.getText() + " until " + dueDateField.getText(), 
            "Success", JOptionPane.INFORMATION_MESSAGE);
        
        clearForm();
    }
    
    // Method to clear the form
    private void clearForm() {
        bookIdField.setText("");
        bookTitleField.setText("");
        studentIdField.setText("");
        studentNameField.setText("");
        
        // Reset dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        issueDateField.setText(dateFormat.format(new Date()));
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        dueDateField.setText(dateFormat.format(calendar.getTime()));
    }
}