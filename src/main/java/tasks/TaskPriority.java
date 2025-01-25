package tasks;

public enum TaskPriority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    URGENT("Urgent");

    private final String displayName;

    TaskPriority(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the priority of the task.
     *
     * @return The priority ("Low", "Medium", "High", "Urgent") of the task.
     */
    public String getDisplayName() {
        return displayName;
    }


}
