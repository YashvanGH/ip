package tasks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.MarkException;
import exceptions.TaskException;
import storage.SaveFileIO;
import tasks.parser.TaskDateTimeParser;

/**
 * This class manages the list of tasks.
 * It provides functionalities to add, delete, mark/unmark tasks.
 * It will also load/save them to a file.
 *
 * @author Yashvan
 */
public class TaskManager {
    private ArrayList<Task> taskList = new ArrayList<>();

    /**
     * Empty constructor to initialise instance of TaskManager Class.
     */
    public TaskManager() {}

    /**
     * Adds task to task list.
     *
     * @param task The task to add to the list.
     */
    public void addTask(Task task) throws TaskException, IOException {
        if (task.isEmpty()) {
            throw new TaskException("Hey! The description of your tasks cannot be empty!");
        } else {
            taskList.add(task);

            System.out.println(
                    "\t______________________________________________________________________________________\n"
                    + "\t I've added this to tasks:\n\t "
                    + task
                    + "\n\t Cool. You have " + taskList.size() + " tasks now. Anything else?\n"
                    + "\t______________________________________________________________________________________\n"
            );
        }
    }

    /**
     * Deletes a task from the task list based on its index.
     *
     * @param index The index of the task to be deleted.
     * @throws TaskException If the task list is empty or the index is invalid.
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
                "\t______________________________________________________________________________________\n"
                + "\t I've removed this from tasks:\n"
                + "\t  "
                + removedTask
                + "\n\t Cool. You have " + taskList.size() + " tasks now. Anything else?\n"
                + "\t______________________________________________________________________________________\n"
        );
    }

    /**
     * Parses input and deletes a task.
     *
     * @param input       The user input in the format of "delete task_number".
     * @param taskManager The {@link TaskManager} instance managing the tasks.
     * @throws NumberFormatException If the task number is missing, empty, or invalid.
     * @throws TaskException         If the task list is empty or the task number is invalid.
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
     * Marks the task at the given index as done.
     *
     * @param index The index at which the task should be marked as done.
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
     * Marks the specified task as done based on the user input.
     * Parses the input string to extract the task number.
     *
     * @param input       The user input in the format of "mark task_number".
     * @param taskManager The {@link TaskManager} instance managing the tasks.
     * @throws NumberFormatException If the task number is missing, empty or invalid.
     * @throws MarkException         If the specified task does not exist.
     * @throws TaskException         For other task-related errors.
     */
    public static void markTask(String input, TaskManager taskManager) throws NumberFormatException, MarkException,
            TaskException, IOException {
        if (input.length() <= 5) {
            throw new NumberFormatException("Boh... Use: mark <task_number>");
        }
        String numberString = input.substring(5).trim();
        if (numberString.isEmpty()) {
            throw new NumberFormatException("Boh... Use: mark <task_number>");
        }
        int indexToMark;
        try {
            indexToMark = Integer.parseInt(input.substring(5)) - 1;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Does that look like a number to you bruh? Enter a valid number!");
        }

        taskManager.markTask(indexToMark);
    }

    /**
     * Unmarks the task at the given index.
     *
     * @param index The index at which the task should be marked as undone.
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
     * Marks the specified task as undone based on the user input.
     * Parses the input string to extract the task number.
     *
     * @param input       The user input in the format of "unmark task_number".
     * @param taskManager The {@link TaskManager} instance managing the tasks.
     * @throws NumberFormatException If the task number is missing, empty or invalid.
     * @throws MarkException         If the specified task does not exist.
     * @throws TaskException         For other task-related errors.
     */
    public static void unmarkTask(String input, TaskManager taskManager) throws NumberFormatException, MarkException,
            TaskException {
        if (input.length() <= 7) {
            throw new NumberFormatException("Boh... Use: unmark <task_number>");
        }
        String numberString = input.substring(5).trim();
        if (numberString.isEmpty()) {
            throw new NumberFormatException("Boh... Use: unmark <task_number>");
        }
        int indexToUnmark;
        try {
            indexToUnmark = Integer.parseInt(input.substring(7)) - 1;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Does that look like a number to you bruh? Enter a valid number!");
        }
        taskManager.unmarkTask(indexToUnmark);
    }

    /**
     * Display all current tasks in the list.
     */
    public void displayList() throws TaskException {
        if (this.taskList.isEmpty()) {
            throw new TaskException("Yo! You have nothing in your task list (for now)");
        }

        System.out.println("\t______________________________________________________________________________________");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("\t " + (i + 1) + ": " + taskList.get(i).toString());
        }
        System.out.println("\t_____________________________________________"
                + "_________________________________________\n");
    }

    /**
     * Loads all tasks from the tyrese.txt.txt file into current user session.
     *
     * @throws IOException If the file cannot be found or does not exist.
     */
    public void loadTasks() throws IOException {
        File file = new File("src/main/java/savedata/tyrese.txt");

        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("You have no saved tasks! Imma initialise a new list!");
        }

        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String line = s.nextLine().trim();

            // Skip empty lines
            if (line.isEmpty()) {
                continue;
            }

            Task task = parseTask(line);
            if (task != null) {
                // Only get unmarked tasks
                taskList.add(task);
            }
        }
    }

    /**
     * Returns one of the tasks in its original input form to be loaded into the tyrese.txt.txt file.
     *
     * @param line The line that is used to convert to its original input.
     * @return One of the 3 tasks (Todo, Deadlines, Events).
     */
    private Task parseTask(String line) {
        try {
            // [T][ ] read (Priority: Low)
            String taskType = line.substring(1, 2);
            boolean isDone = line.charAt(4) == 'X';

            if (isDone) {
                // Do not load this task
                return null;
            }

            // Parsing input to allow creation of subtypes of Task objects
            String description = line.substring(line.indexOf("[ ]") + 4, line.indexOf("(Priority:")).trim();
            String priority = line.substring(line.indexOf("Priority:") + 10,
                    line.indexOf(")",
                    line.indexOf("Priority:"))).trim();
            switch (taskType) {
            case "T": // Todo
                String todoPriority = line.substring(line.indexOf("Priority:") + 10, line.indexOf(")")).trim();
                String todoInput = "todo " + description + " /priority " + todoPriority.toUpperCase();
                return Todo.create(todoInput);
            case "D": // Deadlines
                //[D][ ] play (Priority: Low) (by: 2 March 2014, 6:00pm)
                String deadlineInput = TaskDateTimeParser.deadlineParser(line);
                return Deadlines.create(deadlineInput);
            case "E": // Events
                String eventInput = TaskDateTimeParser.eventParser(line);
                return Events.create(eventInput);
            default:
                return null;

            }
        } catch (TaskException e) {
            System.out.println(
                    "\t______________________________________________________________________________________\n"
                    + "\t " + e.getMessage()
                    + "\n\t______________________________________________________________________________________\n"
            );
        }
        // This line should never be reached
        return null;
    }

    /**
     * Saves only the unmarked tasks to the tyrese.txt.txt file.
     *
     * @throws IOException If tasks cannot be found or saved.
     */
    public void saveUnmarkedTasks() throws IOException {
        ArrayList<Task> unmarkedTasks = new ArrayList<>();

        for (Task task : taskList) {
            if (!task.isDone()) {
                unmarkedTasks.add(task);
            }
        }

        SaveFileIO.writeToSaveFile(unmarkedTasks);
    }

    /**
     * Finds any matching tasks.
     *
     * @param input The task to find in the list.
     */
    public void findTasks(String input) throws TaskException {

        if (input.length() <= 5) {
            throw new TaskException("Watchu trying to find? The lost ark? Enter a description!");
        }

        String description = input.substring(5).trim();

        if (description.isEmpty()) {
            throw new TaskException("Watchu trying to find? The lost ark? Enter a description!");
        }

        int index = 1;
        boolean isMatch = false;

        for (Task task : taskList) {
            if (task.getDescription().contains(description)) {
                isMatch = true;
                break;
            }
        }

        if (!isMatch) {
            throw new TaskException("Weird... It's almost as if the task doesn't exist...");
        }

        System.out.println("\t______________________________________________________________________________________");
        System.out.println("\tHere are the matching tasks in your list:");
        for (Task task : taskList) {
            if (task.getDescription().contains(description)) {
                System.out.println("\t " + index + ": " + task);
                index++;
            }
        }

        System.out.println("\t______________________________________________________________________________________");
    }
}
