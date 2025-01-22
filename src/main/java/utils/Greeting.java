public class Greeting {

    /**
     * Empty constructor to initialise instance of Greeting Class
     */
    public Greeting() {}

    /**
     * Introduces itself and greets the user
     */
    public void greet() {
        String logo =
                  "████████╗██╗   ██╗██████╗ ███████╗███████╗███████╗\n"
                + "╚══██╔══╝╚██╗ ██╔╝██╔══██╗██╔════╝██╔════╝██╔════╝\n"
                + "   ██║    ╚████╔╝ ██████╔╝█████╗  ███████╗█████╗  \n"
                + "   ██║     ╚██╔╝  ██╔══██╗██╔══╝  ╚════██║██╔══╝  \n"
                + "   ██║      ██║   ██║  ██║███████╗███████║███████╗\n"
                + "   ╚═╝      ╚═╝   ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝\n";
        System.out.println(
                        "__________________________________________________\n"
                        + logo
                        + "\t\t\t   What's up? You rang?\n"
                        + "\t    Type 'help' to see what I can do! \n"
                        + "__________________________________________________\n"
        );
    }

    /**
     * Lists out the current functions that can be used by the user
     */
    public void help() {
        System.out.println(
                """
                Here's what I can do for now!
                |todo <description>: Adds a todo without a specific date/time
                |deadline <description> /by <due date>: Adds a task with a deadline
                |event <description> /from <start date/time> /to <end date/time>: Adds an event with a start and end time
                |list: Displays all tasks added
                |mark <task number>: Marks task no.x as done
                |unmark <task number>: Unmarks task no.x
                |exit: Exits the application
                """
        );
    }

    /**
     * Exits the application and greets the user goodbye
     */
    public void sayGoodbye() {
        System.out.println(
                "\t__________________________________________________\n"
                + "\t Aight, I'll head out. Keep up with your tasks!\n"
                + "\t__________________________________________________"
        );
    }
}
