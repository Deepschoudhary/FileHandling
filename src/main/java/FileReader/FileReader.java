package FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static void readFromFile(String fileName) {
        try {
            String filePath = fileName;
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
