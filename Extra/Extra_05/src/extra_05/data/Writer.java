/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package extra_05.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Writer extends Data {

    private Scanner scanner;
    private Reader reader;

    public Writer(String absolutePath) {
        super(absolutePath);

        try {
            scanner = new Scanner(super.getFile());
            reader = new Reader(super.getPath());
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file: " + super.getFile());
        }
    }

    public void promptDeletion() {
        reader.printTextFromFile();
        
        System.out.println("Enter index to delete segment (int): ");
        
        if (scanner.hasNextInt()) {
            int segment = scanner.nextInt();
        } else {
            System.out.println("Please enter the correct type (int).");
            promptDeletion();
        }
    }
    
    public boolean copyTo(String dest) {
        File file = super.getFile();
        File newFile = new File(dest);

        try {
            Files.copy(file.toPath(), newFile.toPath());
            System.out.println("Copy was successful.");
        } catch (IOException ex) {
            System.out.println("Copy did not succeed. " + ex);
            return false;
        }

        return true;
    }

    public void writeToFile(ArrayList<String> text) {

    }
}
