package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tasks.TaskManager;

/**
 * This class handles the main logic for interaction.
 *
 * @author Yashvan
 */
public class Tyrese extends Application {

    private TaskManager taskManager = new TaskManager();

    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file for the UI
            System.out.println("GUI is launching...");
            FXMLLoader fxmlLoader = new FXMLLoader(Tyrese.class.getResource("/view/MainWindow.fxml"));
            AnchorPane root = fxmlLoader.load();
            Scene scene = new Scene(root);

            // Set up the stage
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            stage.setTitle("Tyrese Task Manager");
            stage.setScene(scene);

            // Pass TaskManager instance to MainWindow controller
            MainWindow controller = fxmlLoader.getController();
            controller.setTaskManager(taskManager);

            stage.show();

            try {
                taskManager.loadTasks();
            } catch (IOException e) {
                System.out.println(
                        "\t______________________________________________________________________________________\n"
                        + "\t " + e.getMessage()
                        + "\n\t______________________________________________________________________________________\n"
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

