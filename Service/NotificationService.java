package service;
public class NotificationService {

    public void sendNotification(String message, String username) {
        System.out.println("Notification to " + username + ": " + message);
    }
}
