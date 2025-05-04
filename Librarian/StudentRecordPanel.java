// package Librarian;
// import javax.swing.*;
// public class StudentRecordsPanel extends JFrame {
//     public StudentRecordsPanel() {
//         setTitle("Student Records");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("View Students and Issued Books");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class StudentRecordsPanel extends JPanel {
//     public StudentRecordsPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Description Label
//         JLabel descriptionLabel = new JLabel("View Students and Issued Books", JLabel.CENTER);
//         descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(descriptionLabel, BorderLayout.CENTER);
//     }
// }

// package Librarian;

// import ui.BackButton;
// import ui.MainFrame;

// import javax.swing.*;
// import java.awt.*;

// public class StudentRecordPanel extends JPanel {
//     private MainFrame parentFrame;

//     public StudentRecordPanel(MainFrame parentFrame) {
//         this.parentFrame = parentFrame;
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
//         add(titleLabel, BorderLayout.NORTH);

//         // Content Panel (Placeholder for actual content)
//         JPanel contentPanel = new JPanel();
//         contentPanel.add(new JLabel("Student Records Content Goes Here"));
//         add(contentPanel, BorderLayout.CENTER);

//         // Back Button Panel
//         JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
//         backButtonPanel.add(backButton);
//         add(backButtonPanel, BorderLayout.SOUTH);
//     }
// }
package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class StudentRecordPanel extends JPanel {
    private MainFrame parentFrame;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton refreshButton;
    private JButton viewDetailsButton;
    private JButton notifyButton;
    
    // Data structure for student records
    private List<StudentRecord> studentRecords;
    
    public StudentRecordPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout(10, 10));
        
        // Initialize with sample data
        loadStudentRecords();
        
        // Title Label
        JLabel titleLabel = new JLabel("Student Records", JLabel.CENTER);
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
        searchButton.addActionListener(e -> searchStudentRecords());
        refreshButton.addActionListener(e -> refreshTable());
        
        return searchPanel;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        
        // Create table model with column names
        String[] columnNames = {"Student ID", "Name", "Email", "Contact", "Book ID", "Book Title", "Due Date", "Days Overdue", "Fine ($)"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        
        // Create table and populate with data
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        
        // Set table properties
        studentTable.setFillsViewportHeight(true);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.getTableHeader().setReorderingAllowed(false);
        
        // Add table to panel
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // Populate table with data
        populateTable();
        
        return tablePanel;
    }
    
    private JPanel createActionPanel() {
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        viewDetailsButton = new JButton("View Details");
        notifyButton = new JButton("Send Notifications");
        JButton addButton = new JButton("Add Student");
        JButton deleteButton = new JButton("Delete Student");
        
        actionPanel.add(viewDetailsButton);
        actionPanel.add(notifyButton);
        actionPanel.add(addButton);
        actionPanel.add(deleteButton);
        
        // Add action listeners
        viewDetailsButton.addActionListener(e -> viewStudentDetails());
        notifyButton.addActionListener(e -> sendNotifications());
        addButton.addActionListener(e -> addStudentRecord());
        deleteButton.addActionListener(e -> deleteStudentRecord());
        
        return actionPanel;
    }
    
    private void loadStudentRecords() {
        // In a real application, this would load data from a database
        // For now, we'll use sample data matching the overdue books list
        studentRecords = new ArrayList<>();
        
        // Add students from the overdue books list with matching names
        studentRecords.add(new StudentRecord("S1001", "John Smith", "john.smith@email.com", 
                                           "(555) 123-4567", 1, 1, 4.75));
        studentRecords.add(new StudentRecord("S1002", "Sarah Johnson", "sarah.johnson@email.com", 
                                           "(555) 234-5678", 1, 1, 3.50));
        studentRecords.add(new StudentRecord("S1003", "Michael Brown", "michael.brown@email.com", 
                                           "(555) 345-6789", 1, 1, 2.25));
        studentRecords.add(new StudentRecord("S1004", "Emily Davis", "emily.davis@email.com", 
                                           "(555) 456-7890", 1, 1, 6.00));
        studentRecords.add(new StudentRecord("S1005", "David Wilson", "david.wilson@email.com", 
                                           "(555) 567-8901", 1, 1, 1.50));
        studentRecords.add(new StudentRecord("S1006", "Lisa Martinez", "lisa.martinez@email.com", 
                                           "(555) 678-9012", 1, 1, 8.25));
        studentRecords.add(new StudentRecord("S1007", "James Taylor", "james.taylor@email.com", 
                                           "(555) 789-0123", 1, 1, 4.00));
        studentRecords.add(new StudentRecord("S1008", "Robert Anderson", "robert.anderson@email.com", 
                                           "(555) 890-1234", 1, 1, 7.25));
        
        // Add a few additional students without overdue books
        studentRecords.add(new StudentRecord("S1009", "Patricia Lewis", "patricia.lewis@email.com", 
                                           "(555) 901-2345", 2, 0, 0.00));
        studentRecords.add(new StudentRecord("S1010", "Thomas Clark", "thomas.clark@email.com", 
                                           "(555) 012-3456", 1, 0, 0.00));
    }
    
    private void populateTable() {
        // Clear existing data
        tableModel.setRowCount(0);
        
        // Add data rows for students with overdue books
        for (StudentRecord student : studentRecords) {
            if (student.getOverdueBooks() > 0) {
                // Get corresponding book information
                String bookId = getBookIdForStudent(student.getName());
                String bookTitle = generateSampleBookTitle(student.getName());
                String dueDate = generateSampleDueDate(true, student.getName());
                int daysOverdue = getDaysOverdueForStudent(student.getName());
                
                Object[] rowData = {
                    student.getStudentId(),
                    student.getName(),
                    student.getEmail(),
                    student.getContact(),
                    bookId,
                    bookTitle,
                    dueDate,
                    daysOverdue,
                    String.format("%.2f", student.getFineBalance())
                };
                tableModel.addRow(rowData);
            } else {
                // For students without overdue books, show blank in book-related fields
                Object[] rowData = {
                    student.getStudentId(),
                    student.getName(),
                    student.getEmail(),
                    student.getContact(),
                    "-",
                    "-",
                    "-",
                    0,
                    String.format("%.2f", student.getFineBalance())
                };
                tableModel.addRow(rowData);
            }
        }
    }
    
    private String getBookIdForStudent(String studentName) {
        if (studentName.equals("John Smith")) return "B1001";
        if (studentName.equals("Sarah Johnson")) return "B1002";
        if (studentName.equals("Michael Brown")) return "B1003";
        if (studentName.equals("Emily Davis")) return "B1004";
        if (studentName.equals("David Wilson")) return "B1005";
        if (studentName.equals("Lisa Martinez")) return "B1006";
        if (studentName.equals("James Taylor")) return "B1007";
        if (studentName.equals("Robert Anderson")) return "B1008";
        return "-";
    }
    
    private int getDaysOverdueForStudent(String studentName) {
        if (studentName.equals("John Smith")) return 19;
        if (studentName.equals("Sarah Johnson")) return 14;
        if (studentName.equals("Michael Brown")) return 9;
        if (studentName.equals("Emily Davis")) return 24;
        if (studentName.equals("David Wilson")) return 6;
        if (studentName.equals("Lisa Martinez")) return 33;
        if (studentName.equals("James Taylor")) return 16;
        if (studentName.equals("Robert Anderson")) return 29;
        return 0;
    }
    
    private void searchStudentRecords() {
        String searchTerm = searchField.getText().toLowerCase().trim();
        
        if (searchTerm.isEmpty()) {
            refreshTable();
            return;
        }
        
        tableModel.setRowCount(0);
        
        for (StudentRecord student : studentRecords) {
            if (student.getName().toLowerCase().contains(searchTerm) ||
                student.getEmail().toLowerCase().contains(searchTerm) ||
                student.getStudentId().toLowerCase().contains(searchTerm)) {
                
                // Get corresponding book information
                String bookId = getBookIdForStudent(student.getName());
                String bookTitle = generateSampleBookTitle(student.getName());
                String dueDate = generateSampleDueDate(student.getOverdueBooks() > 0, student.getName());
                int daysOverdue = student.getOverdueBooks() > 0 ? getDaysOverdueForStudent(student.getName()) : 0;
                
                Object[] rowData = {
                    student.getStudentId(),
                    student.getName(),
                    student.getEmail(),
                    student.getContact(),
                    student.getOverdueBooks() > 0 ? bookId : "-",
                    student.getOverdueBooks() > 0 ? bookTitle : "-",
                    student.getOverdueBooks() > 0 ? dueDate : "-",
                    daysOverdue,
                    String.format("%.2f", student.getFineBalance())
                };
                tableModel.addRow(rowData);
            }
        }
    }
    
    private void refreshTable() {
        populateTable();
        searchField.setText("");
    }
    
    private void viewStudentDetails() {
        int selectedRow = studentTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a student to view details.",
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String studentId = (String) tableModel.getValueAt(selectedRow, 0);
        StudentRecord student = findStudentById(studentId);
        
        if (student != null) {
            // In a real application, you would fetch more details from the database
            // and potentially open a new panel/dialog with complete information
            
            StringBuilder details = new StringBuilder();
            details.append("Student ID: ").append(student.getStudentId()).append("\n");
            details.append("Name: ").append(student.getName()).append("\n");
            details.append("Email: ").append(student.getEmail()).append("\n");
            details.append("Contact: ").append(student.getContact()).append("\n");
            details.append("Borrowed Books: ").append(student.getBorrowedBooks()).append("\n");
            details.append("Overdue Books: ").append(student.getOverdueBooks()).append("\n");
            details.append("Fine Balance: $").append(String.format("%.2f", student.getFineBalance())).append("\n\n");
            
            // Add some sample borrowed books
            details.append("Current Borrowed Books:\n");
            if (student.getBorrowedBooks() > 0) {
                details.append("- ").append(generateSampleBookTitle(student.getName())).append(" (Due: ").append(generateSampleDueDate(false, student.getName())).append(")\n");
            }
            
            // Add some sample overdue books if any
            if (student.getOverdueBooks() > 0) {
                details.append("\nOverdue Books:\n");
                details.append("- ").append(generateSampleBookTitle(student.getName())).append(" (Due: ").append(generateSampleDueDate(true, student.getName())).append(")\n");
            }
            
            JOptionPane.showMessageDialog(this, 
                details.toString(),
                "Student Details", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void sendNotifications() {
        int selectedRow = studentTable.getSelectedRow();
        
        if (selectedRow == -1) {
            // If no row is selected, notify all
            JOptionPane.showMessageDialog(this, 
                "Notifications sent to all students with outstanding fines or overdue books.",
                "Notifications Sent", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Notify specific student
            String studentName = (String) tableModel.getValueAt(selectedRow, 1);
            String email = (String) tableModel.getValueAt(selectedRow, 2);
            
            JOptionPane.showMessageDialog(this, 
                "Notification sent to " + studentName + " at " + email + " about outstanding items and fines.",
                "Notification Sent", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void addStudentRecord() {
        // In a real application, this would open a form to add a new student
        // For now, we'll just show a message
        JOptionPane.showMessageDialog(this, 
            "Add functionality would open a form to add a new student.",
            "Add Student", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void deleteStudentRecord() {
        int selectedRow = studentTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Please select a student to delete.",
                "No Selection", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String studentId = (String) tableModel.getValueAt(selectedRow, 0);
        String studentName = (String) tableModel.getValueAt(selectedRow, 1);
        
        int confirmation = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete the student record for " + studentName + "?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);
            
        if (confirmation == JOptionPane.YES_OPTION) {
            // In a real application, this would delete the student from the database
            // For now, we'll just remove from our list and update the table
            StudentRecord studentToRemove = null;
            for (StudentRecord student : studentRecords) {
                if (student.getStudentId().equals(studentId)) {
                    studentToRemove = student;
                    break;
                }
            }
            
            if (studentToRemove != null) {
                studentRecords.remove(studentToRemove);
                populateTable();
                
                JOptionPane.showMessageDialog(this, 
                    "Student record for " + studentName + " has been deleted.",
                    "Delete Successful", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private StudentRecord findStudentById(String studentId) {
        for (StudentRecord student : studentRecords) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    private String generateSampleBookTitle(String studentName) {
        // Find the book title associated with this student from the overdue books list
        if (studentName.equals("John Smith")) return "The Great Gatsby";
        if (studentName.equals("Sarah Johnson")) return "To Kill a Mockingbird";
        if (studentName.equals("Michael Brown")) return "1984";
        if (studentName.equals("Emily Davis")) return "Pride and Prejudice";
        if (studentName.equals("David Wilson")) return "The Catcher in the Rye";
        if (studentName.equals("Lisa Martinez")) return "Lord of the Flies";
        if (studentName.equals("James Taylor")) return "Animal Farm";
        if (studentName.equals("Robert Anderson")) return "Brave New World";
        
        // For other students, return a random title
        String[] titles = {
            "The Great Gatsby", 
            "To Kill a Mockingbird", 
            "1984", 
            "Pride and Prejudice", 
            "The Catcher in the Rye",
            "Lord of the Flies",
            "Animal Farm",
            "Brave New World"
        };
        
        return titles[(int)(Math.random() * titles.length)];
    }
    
    private String generateSampleDueDate(boolean overdue, String studentName) {
        // For students from the overdue books list, return their actual due date
        if (overdue) {
            if (studentName.equals("John Smith")) return "2025-04-15";
            if (studentName.equals("Sarah Johnson")) return "2025-04-20";
            if (studentName.equals("Michael Brown")) return "2025-04-25";
            if (studentName.equals("Emily Davis")) return "2025-04-10";
            if (studentName.equals("David Wilson")) return "2025-04-28";
            if (studentName.equals("Lisa Martinez")) return "2025-04-01";
            if (studentName.equals("James Taylor")) return "2025-04-18";
            if (studentName.equals("Robert Anderson")) return "2025-04-05";
        }
        
        // Generate a sample due date
        if (overdue) {
            // Generate a date in the past
            return "2025-04-" + (int)(Math.random() * 20 + 1);
        } else {
            // Generate a date in the future
            return "2025-05-" + (int)(Math.random() * 20 + 10);
        }
    }
    
    // Inner class to represent a student record
    private static class StudentRecord {
        private String studentId;
        private String name;
        private String email;
        private String contact;
        private int borrowedBooks;
        private int overdueBooks;
        private double fineBalance;
        
        public StudentRecord(String studentId, String name, String email, String contact, 
                            int borrowedBooks, int overdueBooks, double fineBalance) {
            this.studentId = studentId;
            this.name = name;
            this.email = email;
            this.contact = contact;
            this.borrowedBooks = borrowedBooks;
            this.overdueBooks = overdueBooks;
            this.fineBalance = fineBalance;
        }
        
        public String getStudentId() {
            return studentId;
        }
        
        public String getName() {
            return name;
        }
        
        public String getEmail() {
            return email;
        }
        
        public String getContact() {
            return contact;
        }
        
        public int getBorrowedBooks() {
            return borrowedBooks;
        }
        
        public int getOverdueBooks() {
            return overdueBooks;
        }
        
        public double getFineBalance() {
            return fineBalance;
        }
    }
}