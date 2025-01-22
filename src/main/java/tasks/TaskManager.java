package tasks;

import exceptions.MarkException;
import exceptions.TaskException;

import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> taskList = new ArrayList<>();

    /**
     * Empty constructor to initialise instance of tasks.TaskManager Class
     */
    public TaskManager() {}

    /**
     * Adds task to task list
     *
     * @param task The task to add to the list
     */
    public void addTask(Task task) throws TaskException {
        if (task.isEmpty()) {
            throw new TaskException("Hey! The description of your tasks cannot be empty!");
        } else {
            taskList.add(task);

            System.out.println(
                            "\t______________________________________________________________________\n"
                            + "\t I've added this to tasks:\n"
                            + "\t  "
                            + task
                            + "\n\t Cool. You have " + taskList.size() + " tasks now. Anything else?\n"
                            + "\t______________________________________________________________________\n"
            );
        }
    }

    /**
     * Deletes a task from the task list based on its index
     *
     * @param index The index of the task to be deleted
     * @throws TaskException If the task list is empty or the index is invalid
     */
    private void deleteTask(int index) throws TaskException {
        if (taskList.isEmpty()) {
            throw new TaskException("Can't delete work if you don't have work to do!");
        }

        if (index < 0 || index >= taskList.size()) {
            throw new TaskException("I don't know if you've noticed BUT we don't have that many tasks!");
        }

        Task removedTask = taskList.remove(index);
        System.out.println(
                "\t______________________________________________________________________\n"
                        + "\t I've removed this from tasks:\n"
                        + "\t  "
                        + removedTask
                        + "\n\t Cool. You have " + taskList.size() + " tasks now. Anything else?\n"
                        + "\t______________________________________________________________________\n"
        );
    }

    /**
     * Parses input and deletes a task
     *
     * @param input       The user input in the format "delete <task_number>"
     * @param taskManager The {@link TaskManager} instance managing the tasks
     * @throws NumberFormatException If the task number is missing, empty, or invalid
     * @throws TaskException         If the task list is empty or the task number is invalid
     */
    public static void deleteTask(String input, TaskManager taskManager) throws NumberFormatException, TaskException {
        if (input.length() <= 7) {
            throw new NumberFormatException("Boh... Use: delete <task_number>");
        }

        String numberString = input.substring(7).trim();
        if (numberString.isEmpty()) {
            throw new NumberFormatException("Boh... Use: delete <task_number>");
        }

        int indexToDelete;
        try {
            indexToDelete = Integer.parseInt(numberString) - 1; // Parsing the number
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Does that look like a number to you bruh? Enter a valid number!");
        }

        taskManager.deleteTask(indexToDelete);
    }

    /**
     * Marks the task at the given index as done
     *
     * @param index The index at which the task should be marked as done
     */
    private void markTask(int index) throws MarkException, TaskException {
        // Check if the task list is empty
        if (taskList.isEmpty()) {
            throw new MarkException("You have no tasks to mark. Look's like someone's lazing around!");
        }

        // Check if the index is within bounds
        if (index < 0 || index >= taskList.size()) {
            throw new MarkException("I don't know if you've noticed BUT we don't have that many tasks!");
        }

        // Mark the task as done
        taskList.get(index).markTask();
        System.out.println("\tNice! I've marked task " + (index + 1) + " as done!");
        displayList();
    }

    /**
     * Marks the specified task as done based on the user input
     * Parses the input string to extract the task number
     *
     * @param input       The user input in the format "mark <task_number>"
     * @param taskManager The {@link TaskManager} instance managing the tasks
     * @throws NumberFormatException If the task number is missing, empty or invalid
     * @throws MarkException         If the specified task does not exist
     * @throws TaskException         For other task-related errors
     */
    public static void markTask(String input, TaskManager taskManager) throws NumberFormatException, MarkException,
            TaskException {
        if (input.length() <= 5) { throw new NumberFormatException("Boh... Use: mark <task_number>"); }
        String numberString = input.substring(5).trim();
        if (numberString.isEmpty()) { throw new NumberFormatException("Boh... Use: mark <task_number>"); }
        int indexToMark;
        try {
            indexToMark = Integer.parseInt(input.substring(5)) - 1;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Does that look like a number to you bruh? Enter a valid number!");
        }

        taskManager.markTask(indexToMark);
    }

    /**
     * Unmarks the task at the given index
     *
     * @param index The index at which the task should be marked as undone
     */
    private void unmarkTask(int index) throws MarkException, TaskException {
        // Check if the task list is empty
        if (taskList.isEmpty()) {
            throw new MarkException("You have no tasks to unmark. Look's like someone's lazing around!");
        }

        // Check if the index is within bounds
        if (index < 0 || index >= taskList.size()) {
            throw new MarkException("I don't know if you've noticed BUT we don't have that many tasks!");
        }

        // Mark task as undone
        taskList.get(index).unmarkTask();
        System.out.println("\tAn uno reverse? Task " + (index + 1) + " has been unmarked!");
        displayList();
    }

    /**
     * Marks the specified task as undone based on the user input
     * Parses the input string to extract the task number
     *
     * @param input       The user input in the format "unmark <task_number>"
     * @param taskManager The {@link TaskManager} instance managing the tasks
     * @throws NumberFormatException If the task number is missing, empty or invalid
     * @throws MarkException         If the specified task does not exist
     * @throws TaskException         For other task-related errors
     */
    public static void unmarkTask(String input, TaskManager taskManager) throws NumberFormatException, MarkException,
            TaskException {
        if (input.length() <= 7) {throw new NumberFormatException("Boh... Use: unmark <task_number>"); }
        String numberString = input.substring(5).trim();
        if (numberString.isEmpty()) { throw new NumberFormatException("Boh... Use: unmark <task_number>"); }
        int indexToUnmark;
        try {
            indexToUnmark = Integer.parseInt(input.substring(7)) - 1;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Does that look like a number to you bruh? Enter a valid number!");
        }
        taskManager.unmarkTask(indexToUnmark);
    }

    /**
     * Display all current tasks in the list
     */
    public void displayList() throws TaskException {
        if (this.taskList.isEmpty()) {
            throw new TaskException("Yo! You have nothing in your task list (for now)");
        }

        System.out.println("\t______________________________________________________________________");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("\t " + (i + 1) + ": " + taskList.get(i).toString());
        }
        System.out.println("\t______________________________________________________________________\n");
    }

}
