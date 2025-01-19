import java.util.Scanner;
import java.util.Timer;
public class Tyrese {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        TaskManager taskManager = new TaskManager();

        greeting.greet();

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
                    System.out.println("That's it! Leaking personal information~");
                } else if (threat == 3) {
                    System.out.println("Are you serious bruh?");
                    threat++;
                } else {
                    System.out.println("Hey! Use the commands! I'm warning you!");
                    threat++;
                }

            }

        }

        greeting.sayGoodbye();
        scanner.close();
    }
}


