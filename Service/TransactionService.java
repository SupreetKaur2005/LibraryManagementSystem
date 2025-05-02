package Service;
public class TransactionService {

    public void borrowBook(String username, String bookTitle) {
        System.out.println(username + " borrowed " + bookTitle);
    }

    public void returnBook(String username, String bookTitle) {
        System.out.println(username + " returned " + bookTitle);
    }
}
