package src.exception;

/**
 * Exception class for database-related errors
 */
public class DatabaseException extends RuntimeException {
    
    /**
     * Constructs a new database exception with the specified detail message
     * 
     * @param message The detail message
     */
    public DatabaseException(String message) {
        super(message);
    }
    
    /**
     * Constructs a new database exception with the specified detail message and cause
     * 
     * @param message The detail message
     * @param cause The cause
     */
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}