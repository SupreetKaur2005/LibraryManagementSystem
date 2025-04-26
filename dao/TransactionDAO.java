package dao;

import database.DatabaseConnection;
import exception.DatabaseException;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    // Add a new transaction
    public void addTransaction(Transaction transaction) throws DatabaseException {
        String sql = "INSERT INTO transactions (id, user_id, book_id, borrow_date, due_date, return_date, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transaction.getId());
            stmt.setInt(2, transaction.getUserId());
            stmt.setInt(3, transaction.getBookId());
            stmt.setDate(4, Date.valueOf(transaction.getBorrowDate()));
            stmt.setDate(5, Date.valueOf(transaction.getDueDate()));
            if (transaction.getReturnDate() != null) {
                stmt.setDate(6, Date.valueOf(transaction.getReturnDate()));
            } else {
                stmt.setNull(6, Types.DATE);
            }
            stmt.setString(7, transaction.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add transaction", e);
        }
    }

    // Get transaction by ID
    public Transaction getTransactionById(int id) throws DatabaseException {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractTransactionFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve transaction", e);
        }
    }

    // Update a transaction (usually status and return_date)
    public void updateTransaction(Transaction transaction) throws DatabaseException {
        String sql = "UPDATE transactions SET user_id = ?, book_id = ?, borrow_date = ?, due_date = ?, return_date = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transaction.getUserId());
            stmt.setInt(2, transaction.getBookId());
            stmt.setDate(3, Date.valueOf(transaction.getBorrowDate()));
            stmt.setDate(4, Date.valueOf(transaction.getDueDate()));
            if (transaction.getReturnDate() != null) {
                stmt.setDate(5, Date.valueOf(transaction.getReturnDate()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            stmt.setString(6, transaction.getStatus());
            stmt.setInt(7, transaction.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update transaction", e);
        }
    }

    // Delete transaction
    public void deleteTransaction(int id) throws DatabaseException {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete transaction", e);
        }
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() throws DatabaseException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                transactions.add(extractTransactionFromResultSet(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve transactions", e);
        }
        return transactions;
    }

    // Helper method to map ResultSet to Transaction object
    private Transaction extractTransactionFromResultSet(ResultSet rs) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setUserId(rs.getInt("user_id"));
        transaction.setBookId(rs.getInt("book_id"));
        transaction.setBorrowDate(rs.getDate("borrow_date").toLocalDate());
        transaction.setDueDate(rs.getDate("due_date").toLocalDate());
        Date returnDate = rs.getDate("return_date");
        if (returnDate != null) {
            transaction.setReturnDate(returnDate.toLocalDate());
        }
        transaction.setStatus(rs.getString("status"));
        return transaction;
    }
}

