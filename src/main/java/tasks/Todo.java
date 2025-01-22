public class Todo extends Task{

    /**
     * Constructor for the Todo class
     *
     * @param description This is a description of what the todo task should be
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Overriden toString() method
     *
     * @return Shows whether the todo task has or has not been completed
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
