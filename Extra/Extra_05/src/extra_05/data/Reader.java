/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package extra_05.data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Reader extends Data {

    private Scanner scanner;

    public Reader(String absolutePath) {
        super(absolutePath);

        try {
            scanner = new Scanner(super.getFile());
        } catch (FileNotFoundException e) {
            System.out.println("Couldnt find file: " + super.getFile());
        }
    }

    /**
     * Reads the all Strings in the file. Each segments is separated with a ','.
     * It will then proceed to fill the list with the segments and then return
     * the list.
     *
     * @return List of String segments.
     */
    public ArrayList<String> readFromFile() {
        ArrayList<String> content = new ArrayList<>();
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            content.add(scanner.next());
        }
        scanner.reset();
        return content;
    }

    /**
     * Prints out the data from the file associated with this reader. This will
     * be printed in numerical order. (0 - ..*)
     */
    public void printTextFromFile() {
        ArrayList<String> content = readFromFile();
        int index = 0;

        if (content != null) {
            for (String text : content) {
                System.out.println(index + " : " + text);
                index++;
            }
        }
    }

    /**
     * Checks if this file is readable.
     *
     * @return Returns whether the file is readable or not.
     */
    public boolean canRead() {
        return super.getFile().canRead();
    }
}
