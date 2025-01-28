package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exceptions.TaskException;

/**
 * This class represents a task with a deadline.
 * It extends the {@link Task} class and includes a specific date and time.
 *
 * @author Yashvan
 */
public class Deadlines extends Task {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy, h:mma");
    private LocalDateTime deadline;

    /**
     * Private constructor for the Deadlines class.
     *
     * @param description This is a description of what the deadline task should be.
     * @param deadline This is when the task needs to be completed by.
     * @param taskPriority This is the priority of the task.
     */
    private Deadlines(String description, LocalDateTime deadline, TaskPriority taskPriority) {
        super(description, taskPriority);
        this.deadline = deadline;
    }

    /**
     * Creates an instance of Deadlines.
     * A factory method to parse input and create a Deadlines object.
     *
     * @param input The input string for the deadline task.
     * @return A new Deadlines object.
     * @throws TaskException If the input format is invalid.
     */
    public static Deadlines create(String input) throws TaskException {
        String[] parts = input.split(" /by ");
        // Ensure "deadline" has valid format
        // Parts needs to have 2 elements in array if no whitespace
        // Considered whitespace if task
        if (parts.length < 2) {
            throw new TaskException("PLEASE BRUH! Use: deadline <description> /by <d/M/yyyy HHmm> "
                    + "/priority <LOW|MEDIUM|HIGH|URGENT> ._.");
        }

        String deadlineTask = parts[0].substring(8).trim();
        if (deadlineTask.isEmpty()) {
            throw new TaskException("Watchu trying to describe bro? An abstract concept? Write a description!");
        }

        String[] deadlineParts = parts[1].split(" /priority ");
        LocalDateTime deadline;

        try {
            deadline = LocalDateTime.parse(deadlineParts[0].trim(), INPUT_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new TaskException("Invalid date-time format bro! Use: d/M/yyyy HHmm.");
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
     * Returns string representation of the object.
     *
     * @return Shows whether the deadline task has or has not been completed.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadline.format(OUTPUT_FORMATTER) + ")";
    }
}
