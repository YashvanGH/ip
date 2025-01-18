import java.util.Scanner;
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
                        + "__________________________________________________\n"
        );
    }

    /**
     * Echoes user input and terminates when user is done
     */
    public void echo() {
        Scanner s = new Scanner(System.in);
        String echo_word = s.nextLine();

        while (!echo_word.contains("bye")) {

            System.out.println(
                    "__________________________________________________\n"
                    + "You told me this: "
                    + echo_word
                    + "\nCool. Anything else?\n"
                    + "__________________________________________________\n"


            );
            echo_word = s.nextLine();
        }

        System.out.println(
                        "__________________________________________________\n"
                        + "  Aight, I'll head out. Keep up with your tasks!\n"
                        + "__________________________________________________"
        );
    }
}
