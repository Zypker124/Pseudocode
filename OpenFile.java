import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Angus Jyu
 * Period 6
 * 8-25-16
 * OpenFile.java
 * Open files for reading & writing.
 *
 * @author Angus Jyu
 * @version August 25, 2016
 */
public class OpenFile {
    
    /**
     * Open a file to read using the Scanner class.
     * @param fileName   name of the file to open
     * @return           the Scanner object to the file
     */
    public static Scanner openToRead(String fileName) {
        Scanner input = null;
        try{
            input = new Scanner(new File(fileName));
        }catch(FileNotFoundException e){
            System.err.println("ERROR: Cannot open " + fileName + " for reading.");
            System.exit(-1);
        }
        return input;
    }
    
    /**
     * Opens a file to write using the PrintWriter class
     * @param fileName  name of the file to open
     * @return          the PrintWriter object of this file
     */
     public static PrintWriter openToWrite(String fileName){
         PrintWriter output = null;
         try{
             output = new PrintWriter(new File(fileName));
        }catch(IOException e){
            System.err.println("ERROR: Cannot open " + fileName + " for writing.");    
            System.exit(-2);
        }
        return output;
        
        }
    
    
}