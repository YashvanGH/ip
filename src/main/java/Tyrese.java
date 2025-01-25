import exceptions.MarkException;
import exceptions.TaskException;
import tasks.TaskManager;
import tasks.Todo;
import tasks.Deadlines;
import tasks.Events;
import utils.Greeting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Tyrese {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        // To skip unicode characters for testing
        // Unicode characters show up as "?" which makes it hard for testing
        boolean skipAscii = args.length > 0 && args[0].equals("--skip-ascii");
        if (!skipAscii) {
            Greeting.greet();
        }

        // Try to load tasks to populate the task list
        try {
            taskManager.loadTasks();
        } catch (IOException e) {
            System.out.println(
                    "\t______________________________________________________________________\n"
                            + "\t " + e.getMessage()
                            + "\n\t______________________________________________________________________\n"
            );
        }

        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;

        while (isRun) {
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                isRun = false;

            } else if (input.equals("help")) {
                Greeting.help();

            } else if (input.equals("list")) {
                try {
                    taskManager.displayList();
                } catch (TaskException e) {
                    System.out.println(
                            "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );
                }

            } else if (input.startsWith("delete")){
                try {
                    TaskManager.deleteTask(input, taskManager);
                } catch (NumberFormatException | TaskException e) {
                    System.out.println(
                            "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );
                }

            } else if (input.startsWith("mark")) {
                // Gets numbers after the word "mark" and converts to int
                try {
                    TaskManager.markTask(input, taskManager);

                } catch (NumberFormatException | MarkException | TaskException | IOException e) {
                    System.out.println(
                            "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );

                }

            } else if (input.startsWith("unmark")) {
                // Gets numbers after the word "unmark" and converts to int
                try {
                    TaskManager.unmarkTask(input, taskManager);

                } catch (NumberFormatException | MarkException | TaskException e) {
                    System.out.println(
                            "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );
                }

            } else if (input.startsWith("todo")) {
                try {
                    Todo todoTask = Todo.create(input);
                    taskManager.addTask(todoTask);

                } catch (TaskException | IllegalArgumentException | IOException e) {
                    System.out.println(
                                    "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );
                }

            } else if (input.startsWith("deadline")) {
                try {
                    Deadlines deadlineTask = Deadlines.create(input);
                    taskManager.addTask(deadlineTask);

                } catch (TaskException | IOException e) {
                    System.out.println(
                                    "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );
                }

            } else if (input.startsWith("event")) {
                try {
                    Events eventTask = Events.create(input);
                    taskManager.addTask(eventTask);

                } catch (TaskException | IOException e) {
                    System.out.println(
                                    "\t______________________________________________________________________\n"
                                    + "\t " + e.getMessage()
                                    + "\n\t______________________________________________________________________\n"
                    );
                }

            } else {
                // Invalid input
                // Doesn't make sense to throw exception for now
                System.out.println(
                                    "\t______________________________________________________________________\n"
                                    + "\t Whatchu talking about bruh? Type 'help' if you need it!"
                                    + "\n\t______________________________________________________________________\n"
                    );

            }

        }

        // Try to save unmarked tasks from the task list
        try {
            taskManager.saveUnmarkedTasks();
        } catch (IOException e) {
            System.out.println(
                    "\t______________________________________________________________________\n"
                            + "\t " + e.getMessage()
                            + "\n\t______________________________________________________________________\n"
            );
        }

        Greeting.sayGoodbye();
        scanner.close();
    }
}

