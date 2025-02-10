package gui;

import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    public static void main(String[] args) {
        System.out.println("JAVAFX is starting..");
        Application.launch(Tyrese.class, args);
    }
}
