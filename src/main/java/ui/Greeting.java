package ui;

/**
 * This class represents an interaction between the user and system.
 * It greets the user when starting up and bids goodbye when done.
 *
 * @author Yashvan
 */
public class Greeting {

    /**
     * Introduces itself and greets the user
     */
    public static void greet() {
        System.out.println(
                        "__________________________________________________\n"
                        + "\t\t\t It's ya boi Tyrese!\n"
                        + "\t\t\t What's up? You rang?\n"
                        + "\t    Type 'help' to see what I can do! \n"
                        + "__________________________________________________\n"
        );
    }

    /**
     * Lists out the current functions that can be used by the user
     */
    @SuppressWarnings("checkstyle:LineLength")
    public static void help() {
        System.out.println("Here's what I can do for now!");
        System.out.println("|todo <description> /priority <LOW|MEDIUM|HIGH|URGENT>: "
                + "Adds a todo without a specific date/time");
        System.out.println("|deadline <description> /by <D/M/YYYY HHmm> <LOW|MEDIUM|HIGH|URGENT>:"
                + "Adds a task with a deadline");
        System.out.println("|event <description> /from <D/M/YYYY HHmm> /to <D/M/YYYY HHmm> <LOW|MEDIUM|HIGH|URGENT>: "
                + "Adds an event with a start and end time");
        System.out.println("|delete <task number>: Deletes task no.x");
        System.out.println("|find <description>: Finds task with matching description");
        System.out.println("|list: Displays all tasks added");
        System.out.println("|mark <task number>: Marks task no.x as done");
        System.out.println("|unmark <task number>: Unmarks task no.x");
        System.out.println("|exit: Exits the application");
    }

    /**
     * Exits the application and greets the user goodbye
     */
    public static void sayGoodbye() {
        System.out.println(
                "\t______________________________________________________________________________________\n"
                + "\t Aight, I'll head out. Do your tasks! Remember... I'm watching you.\n"
                + "\t______________________________________________________________________________________"
        );
    }
}
