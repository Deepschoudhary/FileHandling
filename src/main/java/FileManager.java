import FileWriter.FileWrite;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    private static final String RESOURCES_PATH = "C:\\Users\\dilip.bhadiyasar\\Documents\\FileHandling\\src\\main\\resources/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File Operations Menu!");
        String choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("create. Create a new file.");
            System.out.println("write. Write to a file.");
            System.out.println("read. Read a file.");
            System.out.println("copy. Copy content from one file to another.");
            System.out.println("show. Show all files in resources folder.");
            System.out.println("delete. Delete a file.");
            System.out.println("exit. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "create":
                    createNewFile();
                    break;
                case "write":
                    writeToFile();
                    break;
                case "read":
                    readFromFile();
                    break;
                case "copy":
                    copyContent();
                    break;
                case "show":
                    showAllFiles();
                    break;
                case "delete":
                    deleteFile();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("exit"));

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
