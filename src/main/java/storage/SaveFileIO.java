package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import tasks.Task;

/**
 * This class handles input and output to the savedata folder.
 *
 * @author Yashvan
 */
public class SaveFileIO {
    private static final String DIRECTORY = System.getProperty("user.dir") + File.separator + "savedata";
    private static final String FILE_NAME = "tyrese.txt";

    /**
     * Writes to the tyrese.txt file.
     *
     * @param taskList The tasklist containing unmarked tasks.
     * @throws IOException If tyrese.txt cannot be written to.
     */
    public static void writeToSaveFile(ArrayList<Task> taskList) throws IOException {

        File file = getFile();

        FileWriter fw;
        // Try to write to the file
        try {
            fw = new FileWriter(file);
            for (Task task : taskList) {
                fw.write(task.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Sorry mans, I can't write to the savedata file");
        }

        fw.close();
    }

    /**
     * Creates the savedata directory and tyrese.txt file to save the data to.
     *
     * @return The file to write and save the data to.
     * @throws IOException If savedata directory or tyrese.txt file cannot be created.
     */
    private static File getFile() throws IOException {
        File directory = new File(DIRECTORY);
        // Parent, Child as arguments
        File file = new File(directory, FILE_NAME);

        // Ensure directory exists
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Sorry mans, I can't create the savedata directory...");
        }

        // Ensure file exists
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("Sorry mans, I can't create the savedata file...");
        }
        return file;
    }
}
