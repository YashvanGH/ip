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

            } else {
                taskManager.addTask(input);
                System.out.println(
                        "__________________________________________________\n"
                                + "I've added this to tasks: "
                                + input
                                + "\nCool. Anything else?\n"
                                + "__________________________________________________\n"
                );
            }
        }

        greeting.sayGoodbye();
        scanner.close();
    }
}


