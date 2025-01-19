import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> taskList = new ArrayList<>();

    /**
     * Empty constructor to initialise instance of TaskManager Class
     */
    public TaskManager() {}

    /**
     * Adds task to task list
     *
     * @param task The task to add to the list
     */
    public void addTask(Task task) {
        taskList.add(task);

        System.out.println(
                "\t__________________________________________________\n"
                        + "\t I've added this to tasks: \n"
                        + "\t  "
                        + task
                        + "\n\t Cool. You have " + taskList.size() + " tasks now. Anything else?\n"
                        + "\t__________________________________________________\n"
        );
    }

    /**
     * Marks the task at the given index as done
     *
     * @param index The index at which the task should be marked as done
     */
    public void markTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).markTask();
            System.out.println("\tNice! I've marked task "  + (index + 1) + " as done!");
            displayList();
        }
    }

    /**
     * Unmarks the task at the given index
     *
     * @param index The index at which the task should be marked as undone
     */
    public void unmarkTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).unmarkTask();
            System.out.println("\tAn uno reverse? Task " + (index + 1) + " has been unmarked!");
            displayList();
        }
    }

    /**
     * Display all current tasks in the list
     */
    public void displayList() {
        System.out.println("\t__________________________________________________");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("\t " + (i + 1) + ": " + taskList.get(i).toString());
        }
        System.out.println("\t__________________________________________________\n");
    }

}
