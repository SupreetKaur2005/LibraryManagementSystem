package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateUtil {

    private static final Logger logger = Logger.getLogger(DateUtil.class.getName());
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String formatDate(LocalDate date) {
        if (date == null) {
            logger.warning("formatDate called with null date");
            return null;
        }
        return date.format(formatter);
    }

    public static LocalDate parseDate(String dateStr) {
        if (dateStr == null) {
            logger.warning("parseDate called with null dateStr");
            return null;
        }
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            logger.log(Level.WARNING, "Invalid date format: " + dateStr, e);
            return null;
        }
    }

    public static String currentDate() {
        return formatDate(LocalDate.now());
    }
}
