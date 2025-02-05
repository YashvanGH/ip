package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import tasks.TaskManager;
import tasks.parser.UserCommandParser;

/**
 * Controller for the main GUI.
 *
 * @author Yashvan
 */
public class MainWindow {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/samurai_doge.png"));
    private Image botImage = new Image(this.getClass().getResourceAsStream("/images/gigachad.png"));

    private TaskManager taskManager;

    /**
     * Initialises the scrollPane and userInput placeholder text.
     */
    @FXML
    public void initialize() {
        // Automatically scrolls to the latest message
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        userInput.setPromptText("Type 'hi' or 'help' to start!");
    }

    /**
     * Sets the TaskManager instance.
     *
     * @param taskManager The task manager instance.
     */
    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    /**
     * Handles user input and displays response based on input.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText().trim();
        if (!input.isEmpty() && taskManager != null) {
            boolean[] isRun = { true };
            String response = UserCommandParser.parseCommand(input, taskManager, isRun);

            // Add user input and bot response to the chat UI
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage), // User's message
                    DialogBox.getTyreseDialog(response, botImage) // Bot's response
            );

            // Clear input field
            userInput.clear();
        }

        // Try to save unmarked tasks
        try {
            taskManager.saveUnmarkedTasks();
        } catch (IOException e) {
            System.out.println(
                    "\t______________________________________________________________________________________\n"
                    + "\t " + e.getMessage()
                    + "\n\t______________________________________________________________________________________\n"
            );
        }
    }
}

