package service;
public class AuthenticationService {

    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
    public void logout() {
        System.out.println("User logged out successfully.");
    }
}
