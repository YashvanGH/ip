package ui;

import javafx.application.Platform;

/**
 * This class represents an interaction between the user and system.
 * It greets the user when starting up and bids goodbye when done.
 *
 * @author Yashvan
 */
public class Greeting {
    /**
     * Lists out the current functions that can be used by the user.
     *
     * @return The various functions with a specified format that the user can use.
     */
    public static String help() {
        return "Here's what I can do for now!\n"
                + "| todo <description> /priority <LOW|MEDIUM|HIGH|URGENT>: Adds a todo without a specific date/time\n"
                + "| deadline <description> /by <D/M/YYYY HHmm> <LOW|MEDIUM|HIGH|URGENT>: Adds a task with a deadline\n"
                + "| event <description> /from <D/M/YYYY HHmm> /to <D/M/YYYY HHmm> <LOW|MEDIUM|HIGH|URGENT>: "
                + "Adds an event with a start and end time\n"
                + "| delete <task number>: Deletes task no.x\n"
                + "| find <description>: Finds task with matching description\n"
                + "| list: Displays all tasks added\n"
                + "| mark <task number>: Marks task no.x as done\n"
                + "| unmark <task number>: Unmarks task no.x\n"
                + "| exit: Exits the application";
    }

    /**
     * Shows a help command if the user enters the wrong or unknown command.
     *
     * @return The command to type for 'help'.
     */
    public static String callForHelp() {
        return "______________________________________________________________________________________\n"
                + "Whatchu talking about bruh? Type 'help' if you need it!"
                + "\n______________________________________________________________________________________\n";
    }
}
