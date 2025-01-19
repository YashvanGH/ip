import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    private String[] taskList = new String[100];
    private int index = 0;

    public TaskManager() {}

    public void addTask(String task) {
        taskList[index++] = task;
    }

    public void displayList() {
        int dispIndex = 1;
        for (String task : taskList) {
            if (task != null) {
                System.out.println(dispIndex + ": " + task);
                dispIndex++;
            }
        }
    }
}
