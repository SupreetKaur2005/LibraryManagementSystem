package dao;

import database.DatabaseConnection;
import exception.DatabaseException;
import model.BookRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    // Add a new book request
    public void addRequest(BookRequest request) throws DatabaseException {
        String sql = "INSERT INTO book_requests (id, user_id, book_id, request_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, request.getId());
            stmt.setInt(2, request.getUserId());
            stmt.setInt(3, request.getBookId());
            stmt.setDate(4, Date.valueOf(request.getRequestDate()));
            stmt.setString(5, request.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add book request", e);
        }
    }

    // Get a book request by ID
    public BookRequest getRequestById(int id) throws DatabaseException {
        String sql = "SELECT * FROM book_requests WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractRequestFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve book request", e);
        }
    }

    // Update a book request (usually updating status like "approved", "rejected")
    public void updateRequest(BookRequest request) throws DatabaseException {
        String sql = "UPDATE book_requests SET user_id = ?, book_id = ?, request_date = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, request.getUserId());
            stmt.setInt(2, request.getBookId());
            stmt.setDate(3, Date.valueOf(request.getRequestDate()));
            stmt.setString(4, request.getStatus());
            stmt.setInt(5, request.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update book request", e);
        }
    }

    // Delete a book request
    public void deleteRequest(int id) throws DatabaseException {
        String sql = "DELETE FROM book_requests WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete book request", e);
        }
    }

    // Get all book requests for a user
    public List<BookRequest> getRequestsByUserId(int userId) throws DatabaseException {
        List<BookRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM book_requests WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                requests.add(extractRequestFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve book requests", e);
        }

        return requests;
    }

    // Get all book requests for a book
    public List<BookRequest> getRequestsByBookId(int bookId) throws DatabaseException {
        List<BookRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM book_requests WHERE book_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                requests.add(extractRequestFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve book requests for book", e);
        }

        return requests;
    }

    // Helper method to map ResultSet to BookRequest object
    private BookRequest extractRequestFromResultSet(ResultSet rs) throws SQLException {
        BookRequest request = new BookRequest();
        request.setId(rs.getInt("id"));
        request.setUserId(rs.getInt("user_id"));
        request.setBookId(rs.getInt("book_id"));
        request.setRequestDate(rs.getDate("request_date").toLocalDate());
        request.setStatus(rs.getString("status"));
        return request;
    }
}
