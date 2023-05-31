 
package carbooking;

 

import java.io.*;
import java.util.*;

public class WriteFiles {

    private Formatter output;

    public void openTextFile(String fileName) {
        try {
            output = new Formatter(fileName);
        } catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");
           
        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");

        }
    }
    public void writeToFile(Booking b) {

        try {
            output.format(b.toString());
            output.format("\n");

        } catch (FormatterClosedException ex) {
            System.err.println("Error writing to file");
            
        }
    }
    public void closeFile() {
        if (output != null) {
            output.close();
        }
    }
}
