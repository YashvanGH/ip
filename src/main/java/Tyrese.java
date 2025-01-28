import tasks.*;
import tasks.parser.UserCommandParser;
import ui.Greeting;

import java.io.IOException;
import java.util.Scanner;

public class Tyrese {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        boolean isTestMode = args.length > 0 && args[0].equals("--test");

        if (!isTestMode) {
            // To skip unicode characters for testing
            // Unicode characters show up as "?" which makes it hard for testing
            Greeting.greet();
        }

        // Try to load tasks to populate the task list
        try {
            taskManager.loadTasks();
        } catch (IOException e) {
            System.out.println(
                    "\t______________________________________________________________________________________\n"
                    + "\t " + e.getMessage()
                    + "\n\t______________________________________________________________________________________\n"
            );
        }


        Scanner scanner = new Scanner(System.in);
        boolean[] isRun = {true};

        while (isRun[0]) {
            String input = scanner.nextLine().trim();
            UserCommandParser.parseCommand(input, taskManager, isRun);
        }

        // Try to save unmarked tasks from the task list
        try {
            taskManager.saveUnmarkedTasks();
        } catch (IOException e) {
            System.out.println(
                    "\t______________________________________________________________________________________\n"
                    + "\t " + e.getMessage()
                    + "\n\t______________________________________________________________________________________\n"
            );
        }

        Greeting.sayGoodbye();
        scanner.close();
    }
}

