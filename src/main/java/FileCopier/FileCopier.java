package FileCopier;

import java.io.*;

public class FileCopier {
    public static void copyContent(String sourceFile, String destinationFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            PrintWriter writer = new PrintWriter(new FileWriter(destinationFile, true));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            reader.close();
            writer.close();
            System.out.println("Content copied successfully from " + sourceFile + " to " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

