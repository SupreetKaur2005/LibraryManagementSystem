package service;
import java.util.ArrayList;
import java.util.List;

public class BookService {
   private List<String> books = new ArrayList<>();

   public void addBook(String title) {
        books.add(title);
        System.out.println("Book added: " + title);
    }

    public void removeBook(String title) {
        books.remove(title);
        System.out.println("Book removed: " + title);
    }

    public void listBooks() {
        System.out.println("Books available:");
        for (String book : books) {
            System.out.println("- " + book);
        }
    }
}
