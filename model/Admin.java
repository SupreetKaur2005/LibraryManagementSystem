package model;


import java.util.ArrayList;
import java.util.List;

public class Admin extends User {

    private List<Librarian> librarians;

    public Admin(int userId, String name, String email, String password, boolean isActive) {
        super(userId, name, email, password, "Admin", isActive);
        this.librarians = new ArrayList<>();
    }

    public Admin() {
        super();
        this.librarians = new ArrayList<>();
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public void setLibrarians(List<Librarian> librarians) {
        this.librarians = librarians;
    }

    // Add a Librarian
    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    // View all Librarians
    public List<Librarian> viewLibrarians() {
        return librarians;
    }

    // Delete a Librarian by ID
    public boolean deleteLibrarian(int librarianId) {
        return librarians.removeIf(lib -> lib.getUserId() == librarianId);
    }

    // View Fine Report (dummy for now)
    public void viewFineReport() {
        System.out.println("Viewing individual and total fine reports...");
    }

    // Generate system report
    public void generateSystemReport() {
        System.out.println("Generating overall system report...");
    }

    // Activate a User
    public void activateUser(User user) {
        user.setActive(true);
        System.out.println("User " + user.getName() + " activated.");
    }

    // Deactivate a User
    public void deactivateUser(User user) {
        user.setActive(false);
        System.out.println("User " + user.getName() + " deactivated.");
    }

    // Logout
    public void logout() {
        System.out.println("Admin logged out.");
    }
}
