package exceptions;

import tasks.Deadline;
import tasks.Event;

/**
 * This class handles the exceptions thrown when creating instances of the
 * in the {@link tasks.Todo Todo}, {@link Deadline Deadline}
 * and {@link Event Event} classes.
 *
 * @author Yashvan
 */
public class MarkException extends Exception {
    public MarkException(String message) {
        super(message);
    }
}
