package util;

import java.util.logging.Logger;

public class ValidationUtil {

    private static final Logger logger = Logger.getLogger(ValidationUtil.class.getName());

    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";

    public static boolean isValidEmail(String email) {
        if (email == null) {
            logger.warning("isValidEmail called with null email");
            return false;
        }
        return email.matches(emailRegex);
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            logger.warning("isValidPassword called with null password");
            return false;
        }
        return password.matches(passwordRegex);
    }

    public static boolean isValidName(String name) {
        if (name == null) {
            logger.warning("isValidName called with null name");
            return false;
        }
        return name.length() >= 2;
    }

    public static boolean isValidBookTitle(String title) {
        if (title == null) {
            logger.warning("isValidBookTitle called with null title");
            return false;
        }
        return title.trim().length() >= 1;
    }

    public static boolean isPositiveNumber(int number) {
        return number > 0;
    }
}
