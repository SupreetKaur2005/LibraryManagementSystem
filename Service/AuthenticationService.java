package service;

import model.User;

public class AuthenticationService {
    public static User authenticate(String email, String password, String role) throws Exception {
      
        if ("admin@example.com".equals(email) && "password".equals(password) && "Admin".equals(role)) {
            return new User(1, "Admin User", email, password, role, true);
        } else if ("librarian@example.com".equals(email) && "password".equals(password) && "Librarian".equals(role)) {
            return new User(2, "Librarian User", email, password, role, true);
        } else if ("student@example.com".equals(email) && "password".equals(password) && "Student".equals(role)) {
            return new User(3, "Student User", email, password, role, true);
        } else {
            throw new Exception("Invalid credentials");
        }
    }
}
