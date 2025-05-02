package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigLoader {
    private static final Logger logger = Logger.getLogger(ConfigLoader.class.getName());
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load config.properties", e);
            throw new ExceptionInInitializerError("Failed to load config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        if (key == null) {
            logger.warning("getProperty called with null key");
            return null;
        }
        return properties.getProperty(key);
    }
}
