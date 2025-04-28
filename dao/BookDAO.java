package dao;

import database.DatabaseConnection;
import exception.DatabaseException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Book;

public class BookDAO {

    // Add a new book
    public void addBook(Book book) throws DatabaseException {
        String sql = "INSERT INTO books (bookId, title, author, publisher, year, isbn, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, book.getBookId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPublisher());
            stmt.setInt(5, book.getYear());
            stmt.setString(6, book.getIsbn());
            stmt.setInt(7, book.getQuantity());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add book", e);
        }
    }

    // Get book by ID
    public Book getBookById(int id) throws DatabaseException {
        String sql = "SELECT * FROM books WHERE bookId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractBookFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve book", e);
        }
    }

    // Update a book
    public void updateBook(Book book) throws DatabaseException {
        String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, year = ?, isbn = ?, quantity = ? WHERE bookId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, book.getYear());
            stmt.setString(5, book.getIsbn());
            stmt.setInt(6, book.getQuantity());
            stmt.setInt(7, book.getBookId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update book", e);
        }
    }

    // Delete a book
    public void deleteBook(int id) throws DatabaseException {
        String sql = "DELETE FROM books WHERE bookId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete book", e);
        }
    }

    // Get all books
    public List<Book> getAllBooks() throws DatabaseException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(extractBookFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve books", e);
        }

        return books;
    }

    // Helper method to map ResultSet to Book object
    private Book extractBookFromResultSet(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("bookId"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setYear(rs.getInt("year"));
        book.setIsbn(rs.getString("isbn"));
        book.setQuantity(rs.getInt("quantity"));
        return book;
    }
}