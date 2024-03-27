package FileDeleter;

import java.io.File;

public class FileDeleter {
    public static void deleteFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file. File may not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
