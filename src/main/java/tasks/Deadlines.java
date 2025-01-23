package tasks;

import exceptions.TaskException;

public class Deadlines extends Task {
    private String deadline;

    /**
     * Private constructor for the Deadlines class
     *
     * @param description This is a description of what the deadline task should be
     * @param deadline This is when the task needs to be completed by
     */
    private Deadlines(String description, String deadline, TaskPriority taskPriority) {
        super(description, taskPriority);
        this.deadline = deadline;
    }

    /**
     * Factory method to parse input and create a Deadlines object
     *
     * @param input The input string for the deadline task
     * @return A new Deadlines object
     * @throws TaskException If the input format is invalid
     */
    public static Deadlines create(String input) throws TaskException {
        String[] parts = input.split(" /by ");
        // Ensure "deadline" has valid format
        // Parts needs to have 2 elements in array if no whitespace
        // Considered whitespace if task
        //        if (parts.length < 2 || parts[0].length() <= 9) {
        //            throw new TaskException("PLEASE BRUH! Use: deadline <description> /by <date> /priority <LOW|MEDIUM|HIGH|URGENT> ._.");
        //        }

        String deadlineTask = parts[0].substring(8).trim();
        if (deadlineTask.isEmpty()) {
            throw new TaskException("Watchu trying to describe bro? An abstract concept? Write a description!");
        }

        String[] deadlineParts = parts[1].split(" /priority ");
        String deadline = deadlineParts[0].trim();
        if (deadline.isEmpty()) {
            throw new TaskException("So you're just gonna have a deadlined task with no deadline?");
        }

        TaskPriority taskPriority;
        try {
            taskPriority = (deadlineParts.length > 1)
                    ? TaskPriority.valueOf(deadlineParts[1].toUpperCase())
                    : TaskPriority.LOW;
        } catch (IllegalArgumentException e) {
            throw new TaskException("Get your priorities in order! Use: LOW, MEDIUM, HIGH, or URGENT!");
        }

        return new Deadlines(deadlineTask, deadline, taskPriority);
    }

    /**
     * Overriden toString() method
     *
     * @return Shows whether the deadline task has or has not been completed
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadline + ")";
    }
}
