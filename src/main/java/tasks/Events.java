public class Events extends Task{
    private String description;
    private String startTime;
    private String endTime;

    /**
     * Constructor for the Deadlines class
     *
     * @param description This is a description of what the deadline task should be
     * @param startTime This is when the task starts
     * @param endTime This is when the task must be completed by
     */
    public Events(String startTime, String endTime, String description) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
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

