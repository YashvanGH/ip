package exceptions;

/**
 * This class handles the exceptions thrown by operations such as find, delete, etc.
 * in the {@link tasks.TaskManager TaskManager} Class.
 *
 * @author Yashvan
 */
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
