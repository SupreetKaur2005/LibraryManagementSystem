package dao;

import database.DatabaseConnection;
import exception.DatabaseException;
import model.Fine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FineDAO {

    // Add a new fine
    public void addFine(Fine fine) throws DatabaseException {
        String sql = "INSERT INTO fines (id, transaction_id, amount, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fine.getId());
            stmt.setInt(2, fine.getTransactionId());
            stmt.setDouble(3, fine.getAmount());
            stmt.setString(4, fine.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add fine", e);
        }
    }

    // Get fine by ID
    public Fine getFineById(int id) throws DatabaseException {
        String sql = "SELECT * FROM fines WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractFineFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve fine", e);
        }
    }

    // Update a fine (usually updating status like "Paid")
    public void updateFine(Fine fine) throws DatabaseException {
        String sql = "UPDATE fines SET transaction_id = ?, amount = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fine.getTransactionId());
            stmt.setDouble(2, fine.getAmount());
            stmt.setString(3, fine.getStatus());
            stmt.setInt(4, fine.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update fine", e);
        }
    }

    // Delete a fine
    public void deleteFine(int id) throws DatabaseException {
        String sql = "DELETE FROM fines WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete fine", e);
        }
    }

    // Get all fines
    public List<Fine> getAllFines() throws DatabaseException {
        List<Fine> fines = new ArrayList<>();
        String sql = "SELECT * FROM fines";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                fines.add(extractFineFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve fines", e);
        }

        return fines;
    }

    // Helper method to map ResultSet to Fine object
    private Fine extractFineFromResultSet(ResultSet rs) throws SQLException {
        Fine fine = new Fine();
        fine.setId(rs.getInt("id"));
        fine.setTransactionId(rs.getInt("transaction_id"));
        fine.setAmount(rs.getDouble("amount"));
        fine.setStatus(rs.getString("status"));
        return fine;
    }
}