package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import tasks.Task;

public class SaveFileIO {
    private static final String DIRECTORY = "src/main/java/savedata";
    private static final String FILE_NAME = "tyrese.txt";

    /**
     * Writes to the tyrese.txt.txt file.
     *
     * @param taskList The tasklist containing unmarked tasks.
     * @throws IOException If tyrese.txt.txt cannot be written to.
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
     * Creates the "data" directory and "tyrese.txt.txt" file to save the data to.
     *
     * @return The file to write and save the data to.
     * @throws IOException If "data" directory or "tyrese.txt.txt" file cannot be created.
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
