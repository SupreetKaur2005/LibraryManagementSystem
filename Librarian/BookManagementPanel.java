// package Librarian;

// import javax.swing.*;

// public class BookManagementPanel extends JFrame {
//     public BookManagementPanel() {
//         setTitle("Book Management");
//         setSize(400, 300);
//         setDefaultCloseOperation(DISPOSE_ON_CLOSE);

//         JLabel label = new JLabel("Book Management Operations (Add/Edit/Delete)");
//         add(label);

//         setVisible(true);
//     }
// }

// package Librarian;

// import javax.swing.*;
// import java.awt.*;

// public class BookManagementPanel extends JPanel {
//     public BookManagementPanel() {
//         setLayout(new BorderLayout());

//         // Title Label
//         JLabel label = new JLabel("Book Management", JLabel.CENTER);
//         label.setFont(new Font("Arial", Font.BOLD, 24));
//         add(label, BorderLayout.NORTH);

//         // Subtitle Label or Operations Description
//         JLabel operationsLabel = new JLabel("Book Management Operations (Add/Edit/Delete)", JLabel.CENTER);
//         operationsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
//         add(operationsLabel, BorderLayout.CENTER);
//     }
// }

package Librarian;

import ui.BackButton;
import ui.MainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class BookManagementPanel extends JPanel {
    private MainFrame parentFrame;
    
    // Book form components
    private JTextField bookIdField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField publisherField;
    private JTextField yearField;
    private JTextField genreField;
    private JTextField isbnField;
    private JSpinner quantitySpinner;
    private JTextArea descriptionArea;
    
    // Action buttons
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton searchButton;
    private JTextField searchField;
    
    // Table to display books
    private JTable booksTable;
    private DefaultTableModel tableModel;
    
    // Sample data (replace with database operations in production)
    private ArrayList<Book> books = new ArrayList<>(Arrays.asList(
        new Book("B001", "Introduction to Java Programming", "John Doe", "Tech Publications", "2022", "Programming", "978-1234567890", 5, "A comprehensive guide to Java programming for beginners."),
        new Book("B002", "Data Structures and Algorithms", "Jane Smith", "Academic Press", "2021", "Computer Science", "978-0987654321", 3, "Essential algorithms and data structures explained in detail."),
        new Book("B003", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "1925", "Fiction", "978-3456789012", 10, "A classic novel set in the Jazz Age."),
        new Book("B004", "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", "1960", "Fiction", "978-4567890123", 7, "A novel about racial inequality in the American South.")
    ));
    
    public BookManagementPanel(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Title Label
        JLabel titleLabel = new JLabel("Book Management", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        // Main content panel with table and form
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(300);
        splitPane.setResizeWeight(0.5);
        
        // Books table panel (upper part)
        JPanel tablePanel = createTablePanel();
        splitPane.setTopComponent(tablePanel);
        
        // Book form panel (lower part)
        JPanel formPanel = createFormPanel();
        splitPane.setBottomComponent(formPanel);
        
        add(splitPane, BorderLayout.CENTER);
        
        // Back Button Panel
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new BackButton(parentFrame, new LibrarianDashboard(parentFrame));
        backButtonPanel.add(backButton);
        add(backButtonPanel, BorderLayout.SOUTH);
        
        // Initialize the table with data
        refreshTable();
    }
    
    // Create the table panel for displaying books
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Books Inventory"));
        
        // Search panel at the top
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchBooks());
        searchPanel.add(searchButton);
        JButton refreshButton = new JButton("Refresh All");
        refreshButton.addActionListener(e -> refreshTable());
        searchPanel.add(refreshButton);
        panel.add(searchPanel, BorderLayout.NORTH);
        
        // Table with scroll pane
        String[] columns = {"Book ID", "Title", "Author", "Publisher", "Year", "Genre", "ISBN", "Quantity"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };
        booksTable = new JTable(tableModel);
        booksTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        booksTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        // Set column widths
        booksTable.getColumnModel().getColumn(0).setPreferredWidth(80);  // Book ID
        booksTable.getColumnModel().getColumn(1).setPreferredWidth(200); // Title
        booksTable.getColumnModel().getColumn(2).setPreferredWidth(150); // Author
        booksTable.getColumnModel().getColumn(3).setPreferredWidth(150); // Publisher
        booksTable.getColumnModel().getColumn(4).setPreferredWidth(60);  // Year
        booksTable.getColumnModel().getColumn(5).setPreferredWidth(100); // Genre
        booksTable.getColumnModel().getColumn(6).setPreferredWidth(120); // ISBN
        booksTable.getColumnModel().getColumn(7).setPreferredWidth(80);  // Quantity
        
        // Add click listener to populate form when a row is selected
        booksTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = booksTable.getSelectedRow();
                if (selectedRow >= 0) {
                    populateFormFromSelectedRow(selectedRow);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(booksTable);
        scrollPane.setPreferredSize(new Dimension(800, 250));
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Create the form panel for adding/editing books
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Book Details"));
        
        // Form fields panel
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // First row: Book ID and Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        fieldsPanel.add(new JLabel("Book ID:"), gbc);
        
        gbc.gridx = 1;
        bookIdField = new JTextField(10);
        fieldsPanel.add(bookIdField, gbc);
        
        gbc.gridx = 2;
        fieldsPanel.add(new JLabel("Title:"), gbc);
        
        gbc.gridx = 3;
        gbc.gridwidth = 3;
        titleField = new JTextField(25);
        fieldsPanel.add(titleField, gbc);
        
        // Second row: Author and Publisher
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        fieldsPanel.add(new JLabel("Author:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        authorField = new JTextField(20);
        fieldsPanel.add(authorField, gbc);
        
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        fieldsPanel.add(new JLabel("Publisher:"), gbc);
        
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        publisherField = new JTextField(20);
        fieldsPanel.add(publisherField, gbc);
        
        // Third row: Year, Genre, ISBN
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        fieldsPanel.add(new JLabel("Year:"), gbc);
        
        gbc.gridx = 1;
        yearField = new JTextField(6);
        fieldsPanel.add(yearField, gbc);
        
        gbc.gridx = 2;
        fieldsPanel.add(new JLabel("Genre:"), gbc);
        
        gbc.gridx = 3;
        genreField = new JTextField(15);
        fieldsPanel.add(genreField, gbc);
        
        gbc.gridx = 4;
        fieldsPanel.add(new JLabel("ISBN:"), gbc);
        
        gbc.gridx = 5;
        isbnField = new JTextField(15);
        fieldsPanel.add(isbnField, gbc);
        
        // Fourth row: Quantity and Description
        gbc.gridx = 0;
        gbc.gridy = 3;
        fieldsPanel.add(new JLabel("Quantity:"), gbc);
        
        gbc.gridx = 1;
        SpinnerNumberModel quantityModel = new SpinnerNumberModel(1, 0, 999, 1);
        quantitySpinner = new JSpinner(quantityModel);
        fieldsPanel.add(quantitySpinner, gbc);
        
        gbc.gridx = 2;
        fieldsPanel.add(new JLabel("Description:"), gbc);
        
        gbc.gridx = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        descriptionArea = new JTextArea(3, 25);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descScrollPane = new JScrollPane(descriptionArea);
        fieldsPanel.add(descScrollPane, gbc);
        
        panel.add(fieldsPanel, BorderLayout.CENTER);
        
        // Buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        addButton = new JButton("Add Book");
        addButton.setBackground(new Color(46, 125, 50));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(e -> addBook());
        buttonsPanel.add(addButton);
        
        updateButton = new JButton("Update Book");
        updateButton.setBackground(new Color(33, 150, 243));
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(e -> updateBook());
        buttonsPanel.add(updateButton);
        
        deleteButton = new JButton("Delete Book");
        deleteButton.setBackground(new Color(211, 47, 47));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(e -> deleteBook());
        buttonsPanel.add(deleteButton);
        
        clearButton = new JButton("Clear Form");
        clearButton.addActionListener(e -> clearForm());
        buttonsPanel.add(clearButton);
        
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    // Refresh the table with all books
    private void refreshTable() {
        tableModel.setRowCount(0); // Clear the table
        
        for (Book book : books) {
            Object[] row = {
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getYear(),
                book.getGenre(),
                book.getIsbn(),
                book.getQuantity()
            };
            tableModel.addRow(row);
        }
    }
    
    // Search for books by title, author, or ID
    private void searchBooks() {
        String searchTerm = searchField.getText().trim().toLowerCase();
        if (searchTerm.isEmpty()) {
            refreshTable();
            return;
        }
        
        tableModel.setRowCount(0); // Clear the table
        
        for (Book book : books) {
            if (book.getId().toLowerCase().contains(searchTerm) ||
                book.getTitle().toLowerCase().contains(searchTerm) ||
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                
                Object[] row = {
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getYear(),
                    book.getGenre(),
                    book.getIsbn(),
                    book.getQuantity()
                };
                tableModel.addRow(row);
            }
        }
    }
    
    // Populate the form with data from the selected row
    private void populateFormFromSelectedRow(int selectedRow) {
        String id = (String) tableModel.getValueAt(selectedRow, 0);
        Book book = findBookById(id);
        
        if (book != null) {
            bookIdField.setText(book.getId());
            titleField.setText(book.getTitle());
            authorField.setText(book.getAuthor());
            publisherField.setText(book.getPublisher());
            yearField.setText(book.getYear());
            genreField.setText(book.getGenre());
            isbnField.setText(book.getIsbn());
            quantitySpinner.setValue(book.getQuantity());
            descriptionArea.setText(book.getDescription());
            
            // Make ID field non-editable for updates
            bookIdField.setEditable(false);
        }
    }
    
    // Find a book by ID
    private Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
    
    // Add a new book
    private void addBook() {
        // Validate inputs
        if (!validateInputs()) {
            return;
        }
        
        String id = bookIdField.getText().trim();
        
        // Check if book ID already exists
        if (findBookById(id) != null) {
            JOptionPane.showMessageDialog(this, 
                "A book with this ID already exists. Use Update instead.", 
                "Duplicate ID", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Create a new book
        Book newBook = new Book(
            id,
            titleField.getText().trim(),
            authorField.getText().trim(),
            publisherField.getText().trim(),
            yearField.getText().trim(),
            genreField.getText().trim(),
            isbnField.getText().trim(),
            (Integer) quantitySpinner.getValue(),
            descriptionArea.getText().trim()
        );
        
        // Add book to the list
        books.add(newBook);
        
        // Refresh table and clear form
        refreshTable();
        JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearForm();
    }
    
    // Update an existing book
    private void updateBook() {
        // Validate inputs
        if (!validateInputs()) {
            return;
        }
        
        String id = bookIdField.getText().trim();
        Book book = findBookById(id);
        
        if (book == null) {
            JOptionPane.showMessageDialog(this, 
                "Book with ID " + id + " not found.", 
                "Book Not Found", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Update book properties
        book.setTitle(titleField.getText().trim());
        book.setAuthor(authorField.getText().trim());
        book.setPublisher(publisherField.getText().trim());
        book.setYear(yearField.getText().trim());
        book.setGenre(genreField.getText().trim());
        book.setIsbn(isbnField.getText().trim());
        book.setQuantity((Integer) quantitySpinner.getValue());
        book.setDescription(descriptionArea.getText().trim());
        
        // Refresh table
        refreshTable();
        JOptionPane.showMessageDialog(this, "Book updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearForm();
    }
    
    // Delete a book
    private void deleteBook() {
        String id = bookIdField.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please select a book to delete.", 
                "No Book Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Book book = findBookById(id);
        if (book == null) {
            JOptionPane.showMessageDialog(this, 
                "Book with ID " + id + " not found.", 
                "Book Not Found", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete the book '" + book.getTitle() + "'?",
            "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            books.remove(book);
            refreshTable();
            JOptionPane.showMessageDialog(this, "Book deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        }
    }
    
    // Clear the form fields
    private void clearForm() {
        bookIdField.setText("");
        titleField.setText("");
        authorField.setText("");
        publisherField.setText("");
        yearField.setText("");
        genreField.setText("");
        isbnField.setText("");
        quantitySpinner.setValue(1);
        descriptionArea.setText("");
        
        // Make ID field editable again for new entries
        bookIdField.setEditable(true);
    }
    
    // Validate user inputs
    private boolean validateInputs() {
        StringBuilder errors = new StringBuilder();
        
        if (bookIdField.getText().trim().isEmpty()) {
            errors.append("- Book ID is required\n");
        }
        if (titleField.getText().trim().isEmpty()) {
            errors.append("- Title is required\n");
        }
        if (authorField.getText().trim().isEmpty()) {
            errors.append("- Author is required\n");
        }
        if (isbnField.getText().trim().isEmpty()) {
            errors.append("- ISBN is required\n");
        }
        
        // Year validation (numeric and reasonable range)
        String yearText = yearField.getText().trim();
        if (!yearText.isEmpty()) {
            try {
                int year = Integer.parseInt(yearText);
                if (year < 1000 || year > 2100) {
                    errors.append("- Year should be between 1000 and 2100\n");
                }
            } catch (NumberFormatException e) {
                errors.append("- Year should be a valid number\n");
            }
        }
        
        if (errors.length() > 0) {
            JOptionPane.showMessageDialog(this, 
                "Please correct the following errors:\n" + errors.toString(), 
                "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    // Book class to store book data
    private static class Book {
        private String id;
        private String title;
        private String author;
        private String publisher;
        private String year;
        private String genre;
        private String isbn;
        private int quantity;
        private String description;
        
        public Book(String id, String title, String author, String publisher, 
                   String year, String genre, String isbn, int quantity, String description) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.year = year;
            this.genre = genre;
            this.isbn = isbn;
            this.quantity = quantity;
            this.description = description;
        }
        
        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
        
        public String getPublisher() { return publisher; }
        public void setPublisher(String publisher) { this.publisher = publisher; }
        
        public String getYear() { return year; }
        public void setYear(String year) { this.year = year; }
        
        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }
        
        public String getIsbn() { return isbn; }
        public void setIsbn(String isbn) { this.isbn = isbn; }
        
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}