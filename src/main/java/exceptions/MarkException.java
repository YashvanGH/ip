package exceptions;

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
