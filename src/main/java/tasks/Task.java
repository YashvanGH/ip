public class Task {
    private String description;
    private boolean isDone;

    /**
     * Constructor for the Task class
     *
     * @param description This is a description of what the task should be
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * Marks the task as done
     * This is used mainly in the TaskManager class
     */
    public void markTask() {
        isDone = true;
    }

    /**
     * Marks the task as undone
     * This is used mainly in the TaskManager class
     */
    public void unmarkTask() {
        isDone = false;
    }

    /**
     * Overriden toString() method
     *
     * @return Shows whether the task has or has not been completed
     */
    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + description;
    }
}
