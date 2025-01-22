package tasks;

import exceptions.TaskException;

public class Todo extends Task{

    /**
     * Private constructor for the Todo class
     *
     * @param description This is a description of what the todo task should be
     */
    private Todo(String description) {
        super(description);
    }

    /**
     * Factory method to parse input and create a Todo object
     *
     * @param input The input string for the todo task
     * @return A new Todo object
     * @throws TaskException If the input format is invalid
     */
    public static Todo create(String input) throws TaskException {
        // Trim to remove any whitespace for easier exception handling
        String todoTask = input.substring(4).trim();
        if (todoTask.isEmpty()) {
            throw new TaskException("PLEASE BRUH! Use: todo <description> ._.");
        }

       return new Todo(todoTask);
    }

    /**
     * Overriden toString() method
     *
     * @return Shows whether the todo task has or has not been completed
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
