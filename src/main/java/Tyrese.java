import java.util.Scanner;
public class Tyrese {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        TaskManager taskManager = new TaskManager();

        // To skip unicode characters for testing
        boolean skipAscii = args.length > 0 && args[0].equals("--skip-ascii");
        if (!skipAscii) {
            greeting.greet();
        }

        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        int threat = 0;

        while (isRun) {
            String input = scanner.nextLine();
            if (input.contains("exit")) {
                isRun = false;

            } else if (input.equals("help")) {
                greeting.help();

            } else if (input.equals("list")) {
                taskManager.displayList();

            } else if (input.startsWith("mark ")) {
                // Gets numbers after the word "mark" and converts to int
                int indexToMark = Integer.parseInt(input.substring(5)) - 1;
                taskManager.markTask(indexToMark);

            } else if (input.startsWith("unmark ")) {
                // Gets numbers after the word "unmark" and converts to int
                int indexToUnmark = Integer.parseInt(input.substring(7)) - 1;
                taskManager.unmarkTask(indexToUnmark);

            } else if (input.startsWith("todo ")) {
                String todoTask = input.substring(5);
                taskManager.addTask(new Todo(todoTask));

            } else if (input.startsWith("deadline ")) {
                String[] parts = input.split(" /by ");
                String deadlineTask = parts[0].substring(9);
                String deadline = parts[1];
                taskManager.addTask(new Deadlines(deadlineTask, deadline));

            } else if (input.startsWith("event ")) {
                String[] parts = input.split(" /from ");
                String[] time = parts[1].split(" /to ");
                String eventTask = parts[0].substring(6);
                String startTime = time[0];
                String endTime = time[1];
                taskManager.addTask(new Events(startTime, endTime, eventTask));

            } else {
                if (threat > 3) {
                    System.out.println(
                            "\t__________________________________________________\n"
                            + "\t That's it! Leaking personal information~\n"
                            + "\t__________________________________________________\n"
                    );
                } else if (threat == 3) {
                    System.out.println(
                            "\t__________________________________________________\n"
                            + "\t Are you serious bruh?\n"
                            + "\t__________________________________________________\n"
                    );
                    threat++;
                } else {
                    System.out.println(
                            "\t__________________________________________________\n"
                            + "\t Hey! Use the commands! I'm warning you!\n"
                            + "\t__________________________________________________\n"
                    );
                    threat++;
                }

            }

        }

        greeting.sayGoodbye();
        scanner.close();
    }
}


