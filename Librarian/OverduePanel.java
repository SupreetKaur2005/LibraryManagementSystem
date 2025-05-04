// package Librarian;
// import javax.swing.*;
// public class OverduePanel extends JFrame {
//     public OverduePanel() {
//         setTitle("Overdue Records");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("List of Overdue Books");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class OverduePanel extends JPanel {
//     public OverduePanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Overdue Records", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("List of Overdue Books", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }
package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class OverduePanel extends JPanel {
    private MainFrame parentFrame;
    private JTable overdueTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton refreshButton;
    private JButton notifyButton;
    
    // Sample data structure for overdue books
    private List<OverdueBook> overdueBooks;
    
    public OverduePanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout(10, 10));
        
        // Initialize with sample data
        loadOverdueBooks();
        
        // Title Label
        JLabel titleLabel = new JLabel("Overdue Books", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout(5, 5));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Search Panel
        JPanel searchPanel = createSearchPanel();
        contentPanel.add(searchPanel, BorderLayout.NORTH);
        
        // Table Panel
        JPanel tablePanel = createTablePanel();
        contentPanel.add(tablePanel, BorderLayout.CENTER);
        
        // Action Panel
        JPanel actionPanel = createActionPanel();
        contentPanel.add(actionPanel, BorderLayout.SOUTH);
        
        add(contentPanel, BorderLayout.CENTER);
        
        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        refreshButton = new JButton("Refresh");
        
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(refreshButton);
        
        // Add action listeners
        searchButton.addActionListener(e -> searchOverdueBooks());
        refreshButton.addActionListener(e -> refreshTable());
        
        return searchPanel;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        
        // Create table model with column names
        String[] columnNames = {"Book ID", "Title", "Borrower", "Due Date", "Days Overdue", "Fine ($)"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        
        // Create table and populate with data
        overdueTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(overdueTable);
        
        // Set table properties
        overdueTable.setFillsViewportHeight(true);
        overdueTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        overdueTable.getTableHeader().setReorderingAllowed(false);
        
        // Add table to panel
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // Populate table with data
        populateTable();
        
        return tablePanel;
    }
    
    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        notifyButton = new JButton("Send Notifications");
        JButton viewDetailsButton = new JButton("View Details");
        
        actionPanel.add(viewDetailsButton);
        actionPanel.add(notifyButton);
        
        // Add action listeners
        notifyButton.addActionListener(e -> sendNotifications());
        viewDetailsButton.addActionListener(e -> viewBookDetails());
        
        return actionPanel;
    }
    
    private void loadOverdueBooks() {
        // In a real application, this would load data from a database
        // For now, we'll use sample data
        overdueBooks = new ArrayList<>();
        
        // Add sample overdue books
        overdueBooks.add(new OverdueBook("B1001", "The Great Gatsby", "John Smith", "2025-04-15", 19));
        overdueBooks.add(new OverdueBook("B1002", "To Kill a Mockingbird", "Sarah Johnson", "2025-04-20", 14));
        overdueBooks.add(new OverdueBook("B1003", "1984", "Michael Brown", "2025-04-25", 9));
        overdueBooks.add(new OverdueBook("B1004", "Pride and Prejudice", "Emily Davis", "2025-04-10", 24));
        overdueBooks.add(new OverdueBook("B1005", "The Catcher in the Rye", "David Wilson", "2025-04-28", 6));
        overdueBooks.add(new OverdueBook("B1006", "Lord of the Flies", "Lisa Martinez", "2025-04-01", 33));
        overdueBooks.add(new OverdueBook("B1007", "Animal Farm", "James Taylor", "2025-04-18", 16));
        overdueBooks.add(new OverdueBook("B1008", "Brave New World", "Robert Anderson", "2025-04-05", 29));
    }
    
    private void populateTable() {
        // Clear existing data
        tableModel.setRowCount(0);
        
        // Add data rows
        for (OverdueBook book : overdueBooks) {
            Object[] rowData = {
                book.getBookId(),
                book.getTitle(),
                book.getBorrower(),
                book.getDueDate(),
                book.getDaysOverdue(),
                String.format("%.2f", book.calculateFine())
            };
            tableModel.addRow(rowData);
        }
    }
    
    private void searchOverdueBooks() {
        String searchTerm = searchField.getText().toLowerCase().trim();
        
        if (searchTerm.isEmpty()) {
            refreshTable();
            return;
        }
        
        tableModel.setRowCount(0);
        
        for (OverdueBook book : overdueBooks) {
            if (book.getTitle().toLowerCase().contains(searchTerm) ||
                book.getBorrower().toLowerCase().contains(searchTerm) ||
                book.getBookId().toLowerCase().contains(searchTerm)) {
                
                Object[] rowData = {
                    book.getBookId(),
                    book.getTitle(),
                    book.getBorrower(),
                    book.getDueDate(),
                    book.getDaysOverdue(),
                    String.format("%.2f", book.calculateFine())
                };
                tableModel.addRow(rowData);
            }
        }
    }
    
    private void refreshTable() {
        populateTable();
        searchField.setText("");
    }
    
    private void sendNotifications() {
        int selectedRow = overdueTable.getSelectedRow();
        
        if (selectedRow == -1) {
            // If no row is selected, notify all
            JOptionPane.showMessageDialog(this, 
                "Notifications sent to all borrowers with overdue books.",
                "Notifications Sent", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Notify specific borrower
            String borrower = (String) tableModel.getValueAt(selectedRow, 2);
            String title = (String) tableModel.getValueAt(selectedRow, 1);
            
            JOptionPane.showMessageDialog(this, 
                "Notification sent to " + borrower + " about overdue book: " + title,
                "Notification Sent", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void viewBookDetails() {
        int selectedRow = overdueTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a book to view details.",
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String bookId = (String) tableModel.getValueAt(selectedRow, 0);
        String title = (String) tableModel.getValueAt(selectedRow, 1);
        String borrower = (String) tableModel.getValueAt(selectedRow, 2);
        String dueDate = (String) tableModel.getValueAt(selectedRow, 3);
        int daysOverdue = (int) tableModel.getValueAt(selectedRow, 4);
        
        // In a real application, you would fetch more details from the database
        // and potentially open a new panel/dialog with complete information
        
        StringBuilder details = new StringBuilder();
        details.append("Book ID: ").append(bookId).append("\n");
        details.append("Title: ").append(title).append("\n");
        details.append("Borrower: ").append(borrower).append("\n");
        details.append("Due Date: ").append(dueDate).append("\n");
        details.append("Days Overdue: ").append(daysOverdue).append("\n");
        details.append("Fine Amount: $").append(String.format("%.2f", daysOverdue * 0.25)).append("\n");
        details.append("Borrower Contact: ").append(generateFakeBorrowerContact(borrower));
        
        JOptionPane.showMessageDialog(this, 
            details.toString(),
            "Book Details", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private String generateFakeBorrowerContact(String borrower) {
        // In a real application, this would come from the database
        return borrower.toLowerCase().replace(" ", ".") + "@email.com";
    }
    
    // Inner class to represent an overdue book
    private static class OverdueBook {
        private String bookId;
        private String title;
        private String borrower;
        private String dueDate;
        private int daysOverdue;
        
        public OverdueBook(String bookId, String title, String borrower, String dueDate, int daysOverdue) {
            this.bookId = bookId;
            this.title = title;
            this.borrower = borrower;
            this.dueDate = dueDate;
            this.daysOverdue = daysOverdue;
        }
        
        public String getBookId() {
            return bookId;
        }
        
        public String getTitle() {
            return title;
        }
        
        public String getBorrower() {
            return borrower;
        }
        
        public String getDueDate() {
            return dueDate;
        }
        
        public int getDaysOverdue() {
            return daysOverdue;
        }
        
        public double calculateFine() {
            // Calculate fine at $0.25 per day
            return daysOverdue * 0.25;
        }
    }
}