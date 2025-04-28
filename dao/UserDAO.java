package dao;

import database.DatabaseConnection;
import exception.DatabaseException;
import java.sql.*;
import model.User;

public class UserDAO {

    // Add a new user
    public void addUser(User user) throws DatabaseException {
        String sql = "INSERT INTO users (userId, name, email, password, role, isActive) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, user.getUserId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());
            stmt.setBoolean(6, user.isActive());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add user", e);
        }
    }

    // Get user by ID
    public User getUserById(int userId) throws DatabaseException {
        String sql = "SELECT * FROM users WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve user", e);
        }
    }

    // Update user details
    public void updateUser(User user) throws DatabaseException {
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, role = ?, isActive = ? WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.setBoolean(5, user.isActive());
            stmt.setInt(6, user.getUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update user", e);
        }
    }

    // Delete a user
    public void deleteUser(int userId) throws DatabaseException {
        String sql = "DELETE FROM users WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete user", e);
        }
    }

    // Activate or Deactivate a user account
    public void setUserActiveStatus(int userId, boolean isActive) throws DatabaseException {
        String sql = "UPDATE users SET isActive = ? WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, isActive);
            stmt.setInt(2, userId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update user status", e);
        }
    }

    // Authenticate user login
    public User authenticateUser(String email, String password) throws DatabaseException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to authenticate user", e);
        }
    }

    // Helper method to map ResultSet to User object
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setActive(rs.getBoolean("isActive"));
        return user;
    }
}
