package Service;

import exception.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Authentication service that handles user login and registration
 */
public class AuthenticationService {
    private Map<String, Map<String, String>> credentials = new HashMap<>();
    private Map<String, String> userRoles = new HashMap<>(); // Maps email to role

    public AuthenticationService() {
        // Initialize credentials
        credentials.put("Admin", new HashMap<>());
        credentials.put("Librarian", new HashMap<>());
        credentials.put("Student", new HashMap<>());

        // Add a default user for each role
        credentials.get("Admin").put("admin@example.com", "password123");
        credentials.get("Librarian").put("librarian@example.com", "password123");
        credentials.get("Student").put("student@example.com", "password123");
        
        // Store user roles for easier lookup
        userRoles.put("admin@example.com", "Admin");
        userRoles.put("librarian@example.com", "Librarian");
        userRoles.put("student@example.com", "Student");
    }

    /**
     * Authenticates a user by email, password and role
     * 
     * @param email User's email
     * @param password User's password
     * @param role User's role
     * @return The role if authentication is successful
     * @throws AuthenticationException If authentication fails
     */
    public String authenticate(String email, String password, String role) throws AuthenticationException {
        Map<String, String> roleCredentials = credentials.get(role);
        if (roleCredentials != null && password.equals(roleCredentials.get(email))) {
            return role;
        } else {
            throw new AuthenticationException("Invalid credentials or role!");
        }
    }
    
    /**
     * Simplified authentication that checks all roles
     * 
     * @param email User's email
     * @param password User's password
     * @return The user's role if authentication is successful
     * @throws AuthenticationException If authentication fails
     */
    public String authenticate(String email, String password) throws AuthenticationException {
        // If role is known, try that first
        String knownRole = userRoles.get(email);
        if (knownRole != null) {
            try {
                return authenticate(email, password, knownRole);
            } catch (AuthenticationException e) {
                // Continue to try other roles
            }
        }
        
        // Try all roles
        for (String role : credentials.keySet()) {
            Map<String, String> roleCredentials = credentials.get(role);
            if (roleCredentials.containsKey(email) && password.equals(roleCredentials.get(email))) {
                return role;
            }
        }
        
        throw new AuthenticationException("Invalid email or password!");
    }

    /**
     * Adds a new user
     * 
     * @param email User's email
     * @param password User's password
     * @param role User's role
     * @throws AuthenticationException If the role is invalid or the user already exists
     */
    public void addUser(String email, String password, String role) throws AuthenticationException {
        Map<String, String> roleCredentials = credentials.get(role);
        if (roleCredentials == null) {
            throw new AuthenticationException("Invalid role: " + role);
        }
        
        // Check if user exists in any role
        for (String r : credentials.keySet()) {
            if (credentials.get(r).containsKey(email)) {
                throw new AuthenticationException("User with this email already exists!");
            }
        }
        
        roleCredentials.put(email, password);
        userRoles.put(email, role);
    }
    
    /**
     * Check if a user exists
     * 
     * @param email User's email
     * @return true if the user exists, false otherwise
     */
    public boolean userExists(String email) {
        return userRoles.containsKey(email);
    }
    
    /**
     * Get a user's role
     * 
     * @param email User's email
     * @return The user's role or null if the user doesn't exist
     */
    public String getUserRole(String email) {
        return userRoles.get(email);
    }
}