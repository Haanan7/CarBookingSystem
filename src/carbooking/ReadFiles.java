package carbooking;

import java.io.*;
import java.util.*;

public class ReadFiles {
  private ObjectInputStream input;
   //open:
    public void openFile(String fileName) {
        try {
            input = new ObjectInputStream(new FileInputStream(new File(fileName)));

        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
        } catch (IOException ex) {
            System.out.println("Can't open file");
        }
    }
    //read:
    public ArrayList<Car> readRecords() {
        ArrayList<Car> cars = new ArrayList<Car>();

        while (true) {
            try {
                Car car = (Car) input.readObject();
                cars.add(car);
// end while
            } catch (EOFException ex) {
                break;
            } catch (IOException ex) {
                System.err.println("Can't read object");
            } catch (ClassNotFoundException ex) {
                System.err.println("Unable to create object");
            }
        }
        return cars;
    }
//close:
    public void closeFile() {
        if (input!= null) {
            try {
                input.close();
                
            } catch (IOException ex) {
                System.out.println("Can't close file.");
            }
        }
        
    }
}
