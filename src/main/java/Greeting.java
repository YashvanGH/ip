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
                            \tHere's what I can do for now!
                            \tadd: Happens automatically (For now!)
                            \tlist: Displays all tasks added
                            \tmark x: Marks task no.x 
                            \tunmark x: Unmarks task no. x 
                            \texit: Exits the application
                            """);
    }

    /**
     * Exits the application and greets the user goodbye
     */
    public void sayGoodbye() {
        System.out.println(
                "\t__________________________________________________\n"
                + "\t  Aight, I'll head out. Keep up with your tasks!\n"
                + "\t__________________________________________________"
        );
    }
}
