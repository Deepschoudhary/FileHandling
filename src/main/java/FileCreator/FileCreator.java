package FileCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileCreator {


    public static void createNewFile(String fileName) {
        try {
            String filePath = Paths.get(fileName).toString();
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + filePath);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
