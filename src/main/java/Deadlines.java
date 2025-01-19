public class Deadlines extends Task {
    private String deadline;

    /**
     * Constructor for the Deadlines class
     *
     * @param description This is a description of what the deadline task should be
     * @param deadline This is when the task needs to be completed by
     */
    public Deadlines(String description, String deadline) {
        super(description);
        this.deadline = deadline;
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
