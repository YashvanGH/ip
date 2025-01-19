import java.util.Scanner;
public class Tyrese {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        TaskManager taskManager = new TaskManager();

        greeting.greet();

        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;

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

            } else {
                taskManager.addTask(input);
            }
        }

        greeting.sayGoodbye();
        scanner.close();
    }
}


