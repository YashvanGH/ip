package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exceptions.TaskException;

public class Events extends Task {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy, h:mma");
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Private constructor for the Deadlines class.
     *
     * @param description This is a description of what the deadline task should be.
     * @param startTime This is when the task starts.
     * @param endTime This is when the task must be completed by.
     * @param taskPriority This is the priority of the task.
     */
    private Events(LocalDateTime startTime, LocalDateTime endTime, String description, TaskPriority taskPriority) {
        super(description, taskPriority);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Creates an instance of Events.
     * A factory method to parse input and create an Events object.
     *
     * @param input The input string for the event task.
     * @return A new Events object.
     * @throws TaskException If the input format is invalid.
     */
    public static Events create(String input) throws TaskException {
        String[] parts = input.split(" /from ");
        // Ensure "event" has a valid format
        // Parts needs to have 2 elements in array if no whitespace
        // Parts[1] needs to contain " /to " as we haven't used it as a 'spliter' to split from yet
        if (parts.length < 2 || !parts[1].contains(" /to ")) {
            throw new TaskException("PLEASE BRUH! Use: event <description> /from <start> /to "
                    + "<end> /priority <LOW|MEDIUM|HIGH|URGENT> ._.");
        }

        String[] timeParts = parts[1].split(" /to ");
        if (timeParts.length < 2) {
            throw new TaskException("One would think that a start and end time come as a pair wouldn't you?");
        }

        String eventTask = parts[0].substring(5).trim();
        String startTimeString = timeParts[0].trim();
        String endTimeAndPriority = timeParts[1];

        if (eventTask.isEmpty()) {
            throw new TaskException("Watchu trying to describe bro? An abstract concept? Write a description!");
        }
        if (startTimeString.isEmpty() || endTimeAndPriority.isEmpty()) {
            throw new TaskException("Sick event man! Just kidding, start and end times can't be empty.");
        }

        // Parse end time and priority
        String[] endTimePriority = endTimeAndPriority.split(" /priority ");
        String endTimeString = endTimePriority[0].trim();

        TaskPriority taskPriority;
        try {
            taskPriority = (endTimePriority.length > 1)
                    ? TaskPriority.valueOf(endTimePriority[1].toUpperCase())
                    : TaskPriority.LOW;
        } catch (IllegalArgumentException e) {
            throw new TaskException("Get your priorities in order! Use: LOW, MEDIUM, HIGH, or URGENT!");
        }

        // Parse date-time strings
        LocalDateTime startTime;
        LocalDateTime endTime;

        try {
            startTime = LocalDateTime.parse(startTimeString, INPUT_FORMATTER);
            endTime = LocalDateTime.parse(endTimeString, INPUT_FORMATTER);
            validateEventTimes(startTime, endTime);
        } catch (DateTimeParseException e) {
            throw new TaskException("Invalid date-time format bro! Use: d/M/yyyy HHmm.");
        }

        return new Events(startTime, endTime, eventTask, taskPriority);
    }

    /**
     * Checks if the end time is before the start time of an event.
     *
     * @param startTime The time the event starts.
     * @param endTime The time the event ends.
     * @throws TaskException If the time the event ends is before the time it starts.
     */
    private static void validateEventTimes(LocalDateTime startTime, LocalDateTime endTime) throws TaskException {
        if (endTime.isBefore(startTime)) {
            throw new TaskException("Are you a time traveler cos an end time cannot be before a start time!");
        }
    }

    /**
     * Returns string representation of the object.
     *
     * @return Shows whether the event task has or has not been completed.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (from: "
                + startTime.format(OUTPUT_FORMATTER)
                + " to: "
                + endTime.format(OUTPUT_FORMATTER)
                + ")";
    }
}

