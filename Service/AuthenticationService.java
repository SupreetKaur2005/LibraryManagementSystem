// package Service;

// import exception.AuthenticationException;


// public class AuthenticationService {
//     // Mock authentication logic
//     public String authenticate(String email, String password, String role) throws AuthenticationException {
//         if (email.equals("admin@example.com") && password.equals("admin") && role.equals("Admin")) {
//             return "Admin";
//         } else if (email.equals("librarian@example.com") && password.equals("librarian") && role.equals("Librarian")) {
//             return "Librarian";
//         } else if (email.equals("student@example.com") && password.equals("student") && role.equals("Student")) {
//             return "Student";
//         }
//         throw new AuthenticationException("Invalid credentials or role!");
//     }
// }
// package Service;

// import exception.AuthenticationException;

// public class AuthenticationService {

//     public String authenticate(String email, String password, String role) throws AuthenticationException {
//         // Mock credentials for demonstration purposes
//         if ("admin@example.com".equals(email) && "password123".equals(password) && "Admin".equals(role)) {
//             return "Admin";
//         } else if ("librarian@example.com".equals(email) && "password123".equals(password) && "Librarian".equals(role)) {
//             return "Librarian";
//         } else if ("student@example.com".equals(email) && "password123".equals(password) && "Student".equals(role)) {
//             return "Student";
//         } else {
//             throw new AuthenticationException("Invalid credentials or role!");
//         }
//     }
// }

// package Service;

// import exception.AuthenticationException;
// import java.util.HashMap;
// import java.util.Map;

// public class AuthenticationService {

//     private Map<String, String> adminCredentials = new HashMap<>();
//     private Map<String, String> librarianCredentials = new HashMap<>();
//     private Map<String, String> studentCredentials = new HashMap<>();

//     public AuthenticationService() {
//         // Initialize credentials (you can load these from a database or file)
//         adminCredentials.put("admin@example.com", "password123");
//         adminCredentials.put("manager@example.com", "securepassword");

//         librarianCredentials.put("librarian@example.com", "password123");

//         studentCredentials.put("student@example.com", "password123");
//         studentCredentials.put("newuser@example.com", "newpassword");
//     }

//     public String authenticate(String email, String password, String role) throws AuthenticationException {
//         Map<String, String> credentials;

//         // Choose the correct credential map based on the role
//         switch (role) {
//             case "Admin":
//                 credentials = adminCredentials;
//                 break;
//             case "Librarian":
//                 credentials = librarianCredentials;
//                 break;
//             case "Student":
//                 credentials = studentCredentials;
//                 break;
//             default:
//                 throw new AuthenticationException("Invalid role: " + role);
//         }

//         // Validate email and password
//         if (credentials.containsKey(email) && credentials.get(email).equals(password)) {
//             return role;
//         } else {
//             throw new AuthenticationException("Invalid credentials or role!");
//         }
//     }
// }

package Service;

import exception.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, Map<String, String>> credentials = new HashMap<>();

    public AuthenticationService() {
        // Initialize credentials
        credentials.put("Admin", new HashMap<>());
        credentials.put("Librarian", new HashMap<>());
        credentials.put("Student", new HashMap<>());

        // Add a default user for each role
        credentials.get("Admin").put("admin@example.com", "password123");
        credentials.get("Librarian").put("librarian@example.com", "password123");
        credentials.get("Student").put("student@example.com", "password123");
    }

    public String authenticate(String email, String password, String role) throws AuthenticationException {
        Map<String, String> roleCredentials = credentials.get(role);
        if (roleCredentials != null && password.equals(roleCredentials.get(email))) {
            return role;
        } else {
            throw new AuthenticationException("Invalid credentials or role!");
        }
    }

    public void addUser(String email, String password, String role) throws AuthenticationException {
        Map<String, String> roleCredentials = credentials.get(role);
        if (roleCredentials == null) {
            throw new AuthenticationException("Invalid role: " + role);
        }
        if (roleCredentials.containsKey(email)) {
            throw new AuthenticationException("User with this email already exists!");
        }
        roleCredentials.put(email, password);
    }
}