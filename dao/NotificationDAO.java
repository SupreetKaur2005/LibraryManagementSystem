package dao;

import database.DatabaseConnection;
import exception.DatabaseException;
import model.Notification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {

    // Add a new notification
    public void addNotification(Notification notification) throws DatabaseException {
        String sql = "INSERT INTO notifications (id, user_id, message, type, date_sent, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, notification.getId());
            stmt.setInt(2, notification.getUserId());
            stmt.setString(3, notification.getMessage());
            stmt.setString(4, notification.getType());
            stmt.setTimestamp(5, Timestamp.valueOf(notification.getDateSent()));
            stmt.setString(6, notification.getStatus());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to add notification", e);
        }
    }

    // Get notification by ID
    public Notification getNotificationById(int id) throws DatabaseException {
        String sql = "SELECT * FROM notifications WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractNotificationFromResultSet(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve notification", e);
        }
    }

    // Update a notification (usually updating status like "read")
    public void updateNotification(Notification notification) throws DatabaseException {
        String sql = "UPDATE notifications SET user_id = ?, message = ?, type = ?, date_sent = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, notification.getUserId());
            stmt.setString(2, notification.getMessage());
            stmt.setString(3, notification.getType());
            stmt.setTimestamp(4, Timestamp.valueOf(notification.getDateSent()));
            stmt.setString(5, notification.getStatus());
            stmt.setInt(6, notification.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to update notification", e);
        }
    }

    // Delete notification
    public void deleteNotification(int id) throws DatabaseException {
        String sql = "DELETE FROM notifications WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete notification", e);
        }
    }

    // Get all notifications for a user
    public List<Notification> getNotificationsByUserId(int userId) throws DatabaseException {
        List<Notification> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notifications.add(extractNotificationFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Failed to retrieve notifications", e);
        }

        return notifications;
    }

    // Helper method to map ResultSet to Notification object
    private Notification extractNotificationFromResultSet(ResultSet rs) throws SQLException {
        Notification notification = new Notification();
        notification.setId(rs.getInt("id"));
        notification.setUserId(rs.getInt("user_id"));
        notification.setMessage(rs.getString("message"));
        notification.setType(rs.getString("type"));
        notification.setDateSent(rs.getTimestamp("date_sent").toLocalDateTime());
        notification.setStatus(rs.getString("status"));
        return notification;
    }
}
