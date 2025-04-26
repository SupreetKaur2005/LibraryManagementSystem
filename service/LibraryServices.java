package service;
import java.util.*;
public class LibraryServices{
    public static class AuthenticationService{
        public boolean login(String username, String password) {
            return "admin".equals(username) && "password".equals(password);
        }

        public void logout(String username) {
            System.out.println(username + " has been logged out.");
        }
    }

    public static class BookService {
        private List<String> books = new ArrayList<>();

        public void addBook(String book) {
            books.add(book);
            System.out.println("Book added: " + book);
        }

        public void removeBook(String book) {
            books.remove(book);
            System.out.println("Book removed: " + book);
        }

        public List<String> getAllBooks() {
            return books;
        }
    }

    public static class TransactionService {
        private Map<String, String> transactions = new HashMap<>();

        public void borrowBook(String book, String user) {
            transactions.put(book, user);
            System.out.println(user + " borrowed: " + book);
        }

        public void returnBook(String book) {
            String user = transactions.remove(book);
            System.out.println(user + " returned: " + book);
        }

        public Map<String, String> getAllTransactions() {
            return transactions;
        }
    }

    public static class FineService {
        public double calculateFine(int overdueDays) {
            double finePerDay = 2.0;
            return overdueDays * finePerDay;
        }

        public void payFine(String user, double amount) {
            System.out.println(user + " paid fine: ₹" + amount);
        }
    }

    public static class NotificationService {
        public void sendNotification(String user, String message) {
            System.out.println("Notification to " + user + ": " + message);
        }
    }

    public static class ReportService {
        public void generateDailyReport() {
            System.out.println("Daily report generated.");
        }

        public void generateUserReport(String user) {
            System.out.println("Report for user: " + user);
        }
    }

    public static class BackupService {
        public void createBackup() {
            System.out.println("Backup created successfully.");
        }

        public void restoreBackup() {
            System.out.println("Backup restored.");
        }
    }

    public static void main(String[] args) {
        AuthenticationService auth = new AuthenticationService();
        BookService bookService = new BookService();
        TransactionService transactionService = new TransactionService();
        FineService fineService = new FineService();
        NotificationService notificationService = new NotificationService();
        ReportService reportService = new ReportService();
        BackupService backupService = new BackupService();
        if (auth.login("admin", "password")) {
            bookService.addBook("Harry Potter");
            bookService.addBook("The Alchemist");

            transactionService.borrowBook("Harry Potter", "John");
            fineService.payFine("John", fineService.calculateFine(3));

            notificationService.sendNotification("John", "Please return 'Harry Potter' soon.");
            reportService.generateUserReport("John");
            backupService.createBackup();
        }
    }
}
