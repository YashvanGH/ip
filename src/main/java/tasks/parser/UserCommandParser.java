package tasks.parser;

import java.io.IOException;

import exceptions.MarkException;
import exceptions.TaskException;
import tasks.Deadlines;
import tasks.Events;
import tasks.TaskManager;
import tasks.Todo;
import ui.Greeting;

/**
 * This class provides methods to parse user-related input. It is primarily used to
 * execute commands based on the given user input to add, create, mark, unmark and view
 * instances of the {@link tasks.Todo Todo}, {@link tasks.Deadlines Deadlines}
 * and {@link tasks.Events Events} classes.
 *
 * @author Yashvan
 */
public class UserCommandParser {

    /**
     * Parses command from user and executes appropriate command.
     *
     * @param input The user input.
     * @param taskManager The TaskManager class used to execute the input.
     * @param isRun The condition to continue running the program.
     */
    public static void parseCommand(String input, TaskManager taskManager, boolean[] isRun) {
        try {
            if (input.equals("exit")) {
                isRun[0] = false;

            } else if (input.equals("help")) {
                Greeting.help();

            } else if (input.equals("list")) {
                taskManager.displayList();

            } else if (input.startsWith("delete")) {
                TaskManager.deleteTask(input, taskManager);

            } else if (input.startsWith("mark")) {
                TaskManager.markTask(input, taskManager);

            } else if (input.startsWith("unmark")) {
                TaskManager.unmarkTask(input, taskManager);

            } else if (input.startsWith("todo")) {
                Todo todoTask = Todo.create(input);
                taskManager.addTask(todoTask);

            } else if (input.startsWith("deadline")) {
                Deadlines deadlineTask = Deadlines.create(input);
                taskManager.addTask(deadlineTask);

            } else if (input.startsWith("event")) {
                Events eventTask = Events.create(input);
                taskManager.addTask(eventTask);

            } else {
                System.out.println(
                        "\t______________________________________________________________________________________\n"
                        + "\t Whatchu talking about bruh? Type 'help' if you need it!"
                        + "\n\t______________________________________________________________________________________\n"
                );
            }
        } catch (NumberFormatException | MarkException | TaskException | IOException e) {
            System.out.println(
                    "\t______________________________________________________________________________________\n"
                    + "\t " + e.getMessage()
                    + "\n\t______________________________________________________________________________________\n"
            );
        }
    }
}
