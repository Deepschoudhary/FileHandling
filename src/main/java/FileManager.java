import FileWriter.FileWrite;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    private static final String RESOURCES_PATH = "C:\\Users\\dilip.bhadiyasar\\Documents\\FileHandling\\src\\main\\resources/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File Operations Menu!");
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new file.");
            System.out.println("2. Write to a file.");
            System.out.println("3. Read a file.");
            System.out.println("4. Copy content from one file to another.");
            System.out.println("5. Show all files in resources folder.");
            System.out.println("6. Delete a file.");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createNewFile();
                    break;
                case 2:
                    writeToFile();
                    break;
                case 3:
                    readFromFile();
                    break;

                case 4:
                    copyContent();
                    break;
                case 5:
                    showAllFiles();
                    break;
                case 6:
                    deleteFile();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void createNewFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = RESOURCES_PATH + scanner.nextLine() + ".txt" ;
        FileCreator.FileCreator.createNewFile(fileName);
    }

    private static void writeToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to write to: ");
        String fileName = RESOURCES_PATH + scanner.nextLine() + ".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist. Please create the file first.");
            return;
        }
        else{
        System.out.print("Enter text to write to the file: ");
        String text = scanner.nextLine();
        FileWrite.writeToFile(fileName, text);
    }}

    private static void readFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to read: ");
        String fileName = RESOURCES_PATH + scanner.nextLine() + ".txt";
        FileReader.FileReader.readFromFile(fileName);
    }

    private static void deleteFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to delete: ");
        String fileName = RESOURCES_PATH + scanner.nextLine() + ".txt";
        FileDeleter.FileDeleter.deleteFile(fileName);
    }

    private static void copyContent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source file name: ");
        String sourceFile = RESOURCES_PATH + scanner.nextLine() + ".txt";
        System.out.print("Enter destination file name: ");
        String destinationFile = RESOURCES_PATH + scanner.nextLine() + ".txt";
        FileCopier.FileCopier.copyContent(sourceFile, destinationFile);
    }

    private static void showAllFiles() {
        File folder = new File(RESOURCES_PATH);
        File[] files = folder.listFiles();
        if (files != null && files.length > 0) {
            System.out.println("Files in the resources folder:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the resources folder.");
        }
    }
}
