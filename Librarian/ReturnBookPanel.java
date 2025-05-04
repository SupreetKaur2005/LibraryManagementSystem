// package Librarian;
// import javax.swing.*;
// public class ReturnBookPanel extends JFrame {
//     public ReturnBookPanel() {
//         setTitle("Return Book");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Return Book from Student");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class ReturnBookPanel extends JPanel {
//     public ReturnBookPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Return Book", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("Return Book from Student", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }

package Librarian;

import ui.BackButton;
import ui.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReturnBookPanel extends JPanel {
    private MainFrame parentFrame;
    
    // Form components
    private JTextField bookIdField;
    private JTextField studentIdField;
    private JButton searchButton;
    private JButton returnButton;
    private JTextArea resultArea;
    
    // Book details
    private JLabel titleValueLabel;
    private JLabel authorValueLabel;
    private JLabel issueDateValueLabel;
    private JLabel dueDateValueLabel;
    private JLabel fineValueLabel;
    
    public ReturnBookPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout(10, 10));
        
        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Return Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
        
        // Main Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Search Panel
        JPanel searchPanel = new JPanel(new GridLayout(3, 2, 5, 10));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Book"));
        
        searchPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField(20);
        searchPanel.add(bookIdField);
        
        searchPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField(20);
        searchPanel.add(studentIdField);
        
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
        searchPanel.add(searchButton);
        
        returnButton = new JButton("Return Book");
        returnButton.setEnabled(false);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });
        searchPanel.add(returnButton);
        
        contentPanel.add(searchPanel, BorderLayout.NORTH);
        
        // Book Details Panel
        JPanel detailsPanel = new JPanel(new GridLayout(5, 2, 5, 10));
        detailsPanel.setBorder(BorderFactory.createTitledBorder("Book Details"));
        
        detailsPanel.add(new JLabel("Title:"));
        titleValueLabel = new JLabel("-");
        detailsPanel.add(titleValueLabel);
        
        detailsPanel.add(new JLabel("Author:"));
        authorValueLabel = new JLabel("-");
        detailsPanel.add(authorValueLabel);
        
        detailsPanel.add(new JLabel("Issue Date:"));
        issueDateValueLabel = new JLabel("-");
        detailsPanel.add(issueDateValueLabel);
        
        detailsPanel.add(new JLabel("Due Date:"));
        dueDateValueLabel = new JLabel("-");
        detailsPanel.add(dueDateValueLabel);
        
        detailsPanel.add(new JLabel("Fine (if any):"));
        fineValueLabel = new JLabel("$0.00");
        detailsPanel.add(fineValueLabel);
        
        contentPanel.add(detailsPanel, BorderLayout.CENTER);
        
        // Result Panel
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder("Status"));
        
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        
        contentPanel.add(resultPanel, BorderLayout.SOUTH);
        
        add(contentPanel, BorderLayout.CENTER);
        
        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
    
    private void searchBook() {
        String bookId = bookIdField.getText().trim();
        String studentId = studentIdField.getText().trim();
        
        if (bookId.isEmpty() || studentId.isEmpty()) {
            resultArea.setText("Please enter both Book ID and Student ID.");
            return;
        }
        
        // Reset fields
        resetDetails();
        
        try {
            // Replace with your actual database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "username", "password");
            
            // Query to check if the book is issued to the specified student
            String query = "SELECT b.title, b.author, i.issue_date, i.due_date " +
                          "FROM books b JOIN issued_books i ON b.id = i.book_id " +
                          "WHERE i.book_id = ? AND i.student_id = ? AND i.return_date IS NULL";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, bookId);
            stmt.setString(2, studentId);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Book found
                String title = rs.getString("title");
                String author = rs.getString("author");
                Date issueDate = rs.getDate("issue_date");
                Date dueDate = rs.getDate("due_date");
                
                // Display book details
                titleValueLabel.setText(title);
                authorValueLabel.setText(author);
                issueDateValueLabel.setText(issueDate.toString());
                dueDateValueLabel.setText(dueDate.toString());
                
                // Calculate fine if any
                double fine = calculateFine(dueDate);
                fineValueLabel.setText("$" + String.format("%.2f", fine));
                
                // Enable return button
                returnButton.setEnabled(true);
                
                resultArea.setText("Book found and can be returned.");
            } else {
                resultArea.setText("No record found for this Book ID and Student ID combination or the book has already been returned.");
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            resultArea.setText("Database error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private double calculateFine(Date dueDate) {
        // Get current date
        LocalDate today = LocalDate.now();
        LocalDate due = ((java.sql.Date) dueDate).toLocalDate();
        
        // Calculate days overdue
        long daysOverdue = ChronoUnit.DAYS.between(due, today);
        
        // If not overdue, no fine
        if (daysOverdue <= 0) {
            return 0.0;
        }
        
        // Calculate fine (e.g., $0.50 per day)
        double fineRate = 0.50;
        return daysOverdue * fineRate;
    }
    
    private void returnBook() {
        String bookId = bookIdField.getText().trim();
        String studentId = studentIdField.getText().trim();
        
        try {
            // Replace with your actual database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "username", "password");
            
            // Begin transaction
            conn.setAutoCommit(false);
            
            // Update issued_books table to mark the book as returned
            String updateQuery = "UPDATE issued_books SET return_date = CURRENT_DATE " +
                                "WHERE book_id = ? AND student_id = ? AND return_date IS NULL";
            
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, bookId);
            updateStmt.setString(2, studentId);
            
            int rowsUpdated = updateStmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                // Update books table to mark the book as available
                String bookUpdateQuery = "UPDATE books SET status = 'Available' WHERE id = ?";
                PreparedStatement bookUpdateStmt = conn.prepareStatement(bookUpdateQuery);
                bookUpdateStmt.setString(1, bookId);
                bookUpdateStmt.executeUpdate();
                
                // If there's a fine, record it
                double fine = Double.parseDouble(fineValueLabel.getText().substring(1));
                if (fine > 0) {
                    String fineQuery = "INSERT INTO fines (student_id, book_id, amount, payment_status, date) " +
                                      "VALUES (?, ?, ?, 'Unpaid', CURRENT_DATE)";
                    PreparedStatement fineStmt = conn.prepareStatement(fineQuery);
                    fineStmt.setString(1, studentId);
                    fineStmt.setString(2, bookId);
                    fineStmt.setDouble(3, fine);
                    fineStmt.executeUpdate();
                    fineStmt.close();
                }
                
                // Commit transaction
                conn.commit();
                
                resultArea.setText("Book successfully returned!\n" + 
                                  (fine > 0 ? "Fine of $" + String.format("%.2f", fine) + " has been recorded." : "No fine was charged."));
                
                // Reset fields and disable return button
                resetDetails();
                returnButton.setEnabled(false);
                bookIdField.setText("");
                studentIdField.setText("");
                
                bookUpdateStmt.close();
            } else {
                conn.rollback();
                resultArea.setText("Error: Could not return the book. Please check your inputs.");
            }
            
            updateStmt.close();
            conn.setAutoCommit(true);
            conn.close();
            
        } catch (SQLException ex) {
            resultArea.setText("Database error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void resetDetails() {
        titleValueLabel.setText("-");
        authorValueLabel.setText("-");
        issueDateValueLabel.setText("-");
        dueDateValueLabel.setText("-");
        fineValueLabel.setText("$0.00");
    }
}