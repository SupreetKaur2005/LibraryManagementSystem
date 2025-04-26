package util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern emailPattern =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    private static final Pattern passwordPattern =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$");

    public static boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static boolean isValidName(String name) {
        return name != null && name.length() >= 2;
    }

    public static boolean isValidBookTitle(String title) {
        return title != null && title.trim().length() >= 1;
    }

    public static boolean isPositiveNumber(int number) {
        return number > 0;
    }
}
