package exceptions;

/**
 * This class handles the exceptions thrown when creating instances of the
 * in the {@link tasks.Todo Todo}, {@link tasks.Deadlines Deadlines}
 * and {@link tasks.Events Events} classes.
 *
 * @author Yashvan
 */
public class MarkException extends Exception {
    // The 3 constructors below follow the Exception class
    public MarkException() {
        super();
    }

    public MarkException(String message) {
        super(message);
    }

    public MarkException(String message, Throwable cause) {
        super(message, cause);
    }
}
