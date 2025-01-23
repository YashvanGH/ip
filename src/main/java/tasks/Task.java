package tasks;

public class Task {
    private String description;
    private TaskPriority taskPriority;
    private boolean isDone;

    /**
     * Constructor for the tasks.Task class
     *
     * @param description This is a description of what the task should be
     */
    public Task(String description, TaskPriority taskPriority) {
        this.description = description;
        this.taskPriority = taskPriority;
        isDone = false;
    }

    /**
     * Marks the task as done
     * This is used mainly in the tasks.TaskManager class
     */
    public void markTask() {
        isDone = true;
    }

    /**
     * Marks the task as undone
     * This is used mainly in the tasks.TaskManager class
     */
    public void unmarkTask() {
        isDone = false;
    }

    /**
     * IsEmpty check
     *
     * @return boolean whether task is empty or not
     */
    public boolean isEmpty() {
        return this.description == null || this.description.trim().isEmpty();
    }

    /**
     * To get the description of any one of the tasks
     *
     * @return The description of the task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Overriden toString() method
     *
     * @return Shows whether the task has or has not been completed
     */
    @Override
    public String toString() {
        return "[" + (isDone ? "X" : " ") + "] " + this.description + " (Priority: "
                + this.taskPriority.getDisplayName() + ")";
    }
}
