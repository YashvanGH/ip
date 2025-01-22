package tasks;

import exceptions.TaskException;

public class Events extends Task{
    private String description;
    private String startTime;
    private String endTime;

    /**
     * Private constructor for the Deadlines class
     *
     * @param description This is a description of what the deadline task should be
     * @param startTime This is when the task starts
     * @param endTime This is when the task must be completed by
     */
    private Events(String startTime, String endTime, String description) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Factory method to parse input and create an Events object
     *
     * @param input The input string for the event task
     * @return A new Events object
     * @throws TaskException If the input format is invalid
     */
    public static Events create(String input) throws TaskException {
        String[] parts = input.split(" /from ");
        // Ensure "event" has a valid format
        // Parts needs to have 2 elements in array if no whitespace
        // Parts[1] needs to contain " /to " as we haven't used it as a dilemeter to split from yet
        if (parts.length < 2 || !parts[1].contains(" /to ")) {
            throw new TaskException("PLEASE BRUH! Use: event <description> /from <start> /to <end> ._.");
        }
        String[] time = parts[1].split(" /to ");
        String eventTask = parts[0].substring(5).trim();
        String startTime = time[0];
        String endTime = time[1];

        return new Events(startTime, endTime, eventTask);
    }

    /**
     * Overriden toString() method
     *
     * @return Shows whether the event task has or has not been completed
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }
}

