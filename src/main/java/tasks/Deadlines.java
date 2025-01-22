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
    private Deadlines(String description, String deadline) {
        super(description);
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
        if (parts.length < 2 || parts[0].length() <= 9) {
            throw new TaskException("PLEASE BRUH! Use: deadline <description> /by <date> ._.");
        }
        String deadlineTask = parts[0].substring(8).trim();
        String deadline = parts[1].trim();

        return new Deadlines(deadlineTask, deadline);
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
