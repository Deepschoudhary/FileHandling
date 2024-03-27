package FileWriter;

import java.io.File;
import java.io.IOException;

public class FileWrite {
    public static void writeToFile(String fileName, String text) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist. Please create the file first.");
            return;
        }

        try (java.io.FileWriter writer = new java.io.FileWriter(fileName, true)) {
            writer.write(text + "\n");
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
