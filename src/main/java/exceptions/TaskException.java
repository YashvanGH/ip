package exceptions;

public class TaskException extends Exception {

    // The 3 constructors below follow the Exception class
    public TaskException() {
        super();
    }

    public TaskException(String message) {
        super(message);
    }

    public TaskException(String message, Throwable cause) {
        super(message, cause);
    }

}
