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
        System.out.println("""
                            Here's what I can do for now!
                            add: Happens automatically (For now!)
                            list: Displays all tasks added
                            exit: Exits the application
                            """);
    }

    /**
     * Exits the application and greets the user goodbye
     */
    public void sayGoodbye() {
        System.out.println("__________________________________________________");
        System.out.println("  Aight, I'll head out. Keep up with your tasks!");
        System.out.println("__________________________________________________");
    }
}
