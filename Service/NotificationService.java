// package Service;
// public class NotificationService {

//     public void sendNotification(String message, String username) {
//         System.out.println("Notification to " + username + ": " + message);
//     }
// }

package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {

    // A map to store pending notifications for users
    private Map<String, List<String>> pendingNotifications;

    // Constructor to initialize the notification service
    public NotificationService() {
        pendingNotifications = new HashMap<>();
    }

    // Method to send a notification to a specific user
    public void sendNotification(String message, String username) {
        System.out.println("Notification to " + username + ": " + message);
    }

    // Method to add a notification to the pending queue for a user
    public void addPendingNotification(String username, String message) {
        pendingNotifications.putIfAbsent(username, new ArrayList<>());
        pendingNotifications.get(username).add(message);
        System.out.println("Added pending notification for " + username + ": " + message);
    }

    // Method to send all pending notifications
    public void sendPendingNotifications() {
        System.out.println("Sending all pending notifications...");
        for (Map.Entry<String, List<String>> entry : pendingNotifications.entrySet()) {
            String username = entry.getKey();
            List<String> userNotifications = entry.getValue();

            for (String notification : userNotifications) {
                sendNotification(notification, username);
            }
        }
        // Clear all pending notifications after they are sent
        pendingNotifications.clear();
        System.out.println("All pending notifications have been sent.");
    }

    // Method to check if a user has pending notifications
    public boolean hasPendingNotifications(String username) {
        return pendingNotifications.containsKey(username) && !pendingNotifications.get(username).isEmpty();
    }

    // Method to get pending notifications for a specific user
    public List<String> getPendingNotifications(String username) {
        return pendingNotifications.getOrDefault(username, new ArrayList<>());
    }
}