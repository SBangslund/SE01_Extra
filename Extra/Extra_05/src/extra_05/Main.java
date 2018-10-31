/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package extra_05;

import extra_05.data.*;

/**
 *
 * @author sbang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path_1 = "C:\\Users\\sbang\\OneDrive\\SDU\\Software Engineering\\Projects\\Extra_05\\src\\extra_05\\twocolors.csv";
        String path_2 = "C:\\Users\\sbang\\OneDrive\\SDU\\Software Engineering\\Projects\\Extra_05\\src\\extra_05\\twocolors (copy).csv";
        
        Reader reader = new Reader(path_1);
        Writer writer = new Writer(path_1);
        
        System.out.print("\nPrinting the file summary: ");
        System.out.println(reader.fileSummary());
        
        System.out.print("\nCan the file be read from?: ");
        System.out.println(reader.canRead());
        
        System.out.println("\nPrinting the text from the file: ");
        reader.printTextFromFile();
    }
}
