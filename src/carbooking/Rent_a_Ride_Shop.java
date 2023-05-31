package carbooking;

// Car Booking System project
// STUDENT: Hanan Alnazy , Renad Ajina
//    ID  :   443007512     ,  443007483
// SECTION: 2C2
//PROJECT NUMBER  : 5

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.time.LocalDate;

import java.util.Scanner;
import java.util.ArrayList;

import java.util.InputMismatchException;

public class Rent_a_Ride_Shop {

    //instance varible:
    static Scanner input = new Scanner(System.in);
    static Customer customer;
    static BookingSystem bookings = new BookingSystem();

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<Car>();
    
        shopInterface();
        //--------------------------------------------------------
        customer = takeCustomerInfo();
        //when age less than 21 he can't continue the prosses of renting
        //and also while the liscece is invalid 
        if (customer == null) {
            return;
        }
        //----------------------------------------------------------
        menu();

    }

    public static void shopInterface() {

        System.out.println("                                                                     --------------------------- \n"
                + "                                                                     |" + " \u001B[0m" + "\u001B[33m" + "    RENT_a_RIDE SHOP" + "    |");

        System.out.println("                                                                     ---------------------------  \n");
        System.out.println("------------------------------------------------------------------- Welcome to our Rent_a_ride shop------------------------------------------------------------------------- ");

    }

    public static Customer takeCustomerInfo() {

        //Take Customer information:
        System.out.println("\nCUSTOMER INFORMATIONS");
try{
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter Your Age: ");
        int age = input.nextInt();
        // less than 21 years old are not Allowed to rent
        if (age < 21) {
            System.out.println("Sorry you're not allowed to rent a car, you should be more than 21 to rent");
            return null;
        }
        System.out.print("Enter your ID: ");
        String id = input.next();
        //ID should be 10 digits
        while (id.length() != 10) {
            System.out.print("Invalid national ID, try again: ");
            id = input.next(); }
        //Licence Number should be 10 digits 
        System.out.print("Enter Your Licence (10 Numbers): ");
        String licenceNum = input.next();
        while (licenceNum.length() != 10) {
            System.out.print("Invalid Licence, try again: ");
            licenceNum = input.next();
        }
        //he can't rent if his license is expired
        System.out.print("Enter Your Licence Expiration date (yyyy-mm-dd): ");
        input.nextLine();
        String licenceExpiry = input.nextLine();
        while (!checkDate(licenceExpiry)) {
            System.out.print("You can't rent while your liscece is expired! ");
            return null; //because no need to continue the prosses of renting if the liscece is invalid 
          
        }
        
        System.out.print("Enter your contact number: ");
       String contactNum = input.next();
       
        return new Customer(name, age, id, licenceNum, licenceExpiry, contactNum);
        
             } catch (InputMismatchException e) {
                            System.err.println("invalid input");
                        }
       return null;
    }

    public static boolean checkDate(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            if (date.isBefore(LocalDate.now())) {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Invalid Date.");
            return false;
        }
        return true;

    }

    private static void menu() {

        ArrayList<Car> cars = new ArrayList<Car>();
        saveCars(cars);
        readCars(cars);
        Booking booking;

        int choice;
        try {
            do {
                System.out.print("\n1. Browse All Cars\n"
                        + "2. Browse Economy Cars\n"
                        + "3. Browse Family Cars\n"
                        + "4. Browse Luxury Cars\n"
                        + "5. Make Booking\n"
                        + "6. Show Booking\n"
                        + "7. Cancel Booking\n"
                        + "8. Exit\n");
                System.out.print("Enter Choice: ");
                choice = input.nextInt();

                switch (choice) {

                    //------------------------------All Cars----------------------------------- 
                    case 1:

                        printFormat();
                        for (Car car : cars) {
                            System.out.println(car.toString());
                            System.out.println("--------------------------------------------------------------------------------------------------------------");

                        }
                        break;

//------------------------------Economy Cars---------------------------------- 
                    case 2:
                        printFormat();
                        for (Car car : cars) {
                            if (car instanceof EconomyCar) {
                                System.out.println(car.toString());
                                System.out.println("--------------------------------------------------------------------------------------------------------------");
                            }
                        }
                        break;
//------------------------------Family Cars---------------------------------- 
                    case 3:
                        printFormat();
                        for (Car car : cars) {
                            if (car instanceof FamilyCar) {
                                System.out.println(car.toString());
                                System.out.println("--------------------------------------------------------------------------------------------------------------");
                            }
                        }
                        break;
//-------------------------------Luxury Cars-------------------------------
                    case 4:
                        printFormat();
                        for (Car car : cars) {
                            if (car instanceof LuxuryCar) {
                                System.out.println(car.toString());
                                System.out.println("--------------------------------------------------------------------------------------------------------------");

                            }
                        }
                        break;
//----------------------------new Booking----------------------------------
                    case 5:
                        printFormat();

                        for (Car car : cars) {
                            
                            //Polymorphic call of toString method
                            System.out.println(car.toString());
                            System.out.println("--------------------------------------------------------------------------------------------------------------");

                        }//end loop

                        try {
                            System.out.print("Enter car Serial Number: ");
                            int sn = input.nextInt();

                            for (Car car : cars) {
                                if (car != null) {
                                    if (car.getSerialNum() == sn) {
                                        
                                        //pick up date
                                        System.out.print("Enter pick-up date: (yyyy-mm-dd): ");
                                        input.nextLine();
                                        String pickupDate = input.nextLine();
                                        while (!checkDate(pickupDate)) {
                                            System.out.print("Invlaid pick-up date, try again:");
                                            pickupDate = input.nextLine();
                                        }
                                        
                                        //duration
                                        System.out.print("Enter duration in days(1-30): ");
                                        int duration = input.nextInt();
                                        while (duration < 1 || duration > 30) {
                                            System.out.print("Invalid Duration, it should be between 1 and 30:");
                                            duration = input.nextInt();
                                        }

                                        System.out.print("Enter Pick-up Location City: ");
                                        String pickCity = input.nextLine();
                                        input.nextLine();
                                        System.out.print("Enter Pick-up Location Office Number: ");
                                        int pickOffice = input.nextInt();
                                        Location pickupLocation = new Location(pickCity, pickOffice);

                                        System.out.print("Enter Drop-off Location City: ");
                                        String dropCity = input.nextLine();
                                        input.nextLine();
                                        System.out.print("Enter Drop-off Location Office Number: ");
                                        int dropOffice = input.nextInt();
                                        Location dropoffLocation = new Location(dropCity, dropOffice);
                                        //1.Create Booking object
                                        booking = new Booking(customer, car, pickupLocation, dropoffLocation, pickupDate, duration);
                                        //2. the method will set the avilbility
                                        car.rent();
                                        //3.it'll add it to booking List :)
                                        bookings.addBooking(booking);
                                        //4.he will agree to the rule 
                                        System.out.println("In Rent_a_Ride_Shop System we have some of Car Rental fines you must accept it before make your rent order");
                        System.out.println("1- smoking is prohibited inside the car");
                        System.out.println("2- prevents it is not allow to return car without petrol"
                                + "\n3-If you ride more than Kilometers limites in per-day you'll pay Extra cost");
                        System.out.println("Please choose (\"accept\" or \"decline\")");

                        String agreePolicy = input.next().toLowerCase();
                        if(agreePolicy.equals("accept")) {

                        } else if (agreePolicy.equals("decline")) {
                            return;
                        } else {
                            System.out.print("\nInvalid choose!");
                            return;
                        }         //after he accept his booking'll be confirm:
                                        booking.setStatus("Confirmed");
                                        booking.printBill();
                                       
                                    }
                                } else {
                                    System.out.println("Car has not found.");
                                    break;
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input");
                        }
                        

                        break; //end of case 5 
                    //display 
                    case 6:
                        System.out.print("Enter your booking id: ");
                        int bookingId = input.nextInt();
                        bookings.showBooking(bookingId);
                        break;

                    case 7://Cancel Booking
                        System.out.print("Enter your booking id: ");
                        bookingId = input.nextInt();
                        bookings.cancelBooking(bookingId);
                        break;

                    case 8://exit
                        saveBookings();

                        System.out.println("Thank you.");
                        break;

                    default:
                        System.out.println("Invalid option");

                }

            } while (choice != 8);
        } catch (InputMismatchException ex) {
            {
                System.err.println("Invalid input");
            }
        }
    }

    public static void printFormat() {
        System.out.printf("\n%-5s%-16s%-15s%-14s%-12s%-11s%-15s%-12s%-10s", "ISSN:", " NAME:", "MODEL:", "COLOR:", "PRICE_SR:", "KILOMETRES LIMIT", "  DOORS:", "SEATS:", "AVAILABILITY:");
    }

    public static void saveCars(ArrayList<Car> cars) {

        //Luxury Cars:
        cars.add(new BMW(1, "BWM", "2020", "Black", 300, 180, 2, 5));
        cars.add(new Mercedes(2, "Mercedes", "2022", "red", 350, 180, 2, 5));

        //Family Cars:
        cars.add(new Kia(3, "Kia", "2019", "blue", 120, 250, 4, 7));
        cars.add(new GMC(4, "GMC", "2017", "brouwn", 150, 250, 4, 9));

        //Economy Cars:
        cars.add(new Hyundai(5, "Hyundai", "2020", "White", 90, 200, 4, 8));
        cars.add(new Ford(6, "Ford", "2018", "silver", 110, 200, 4, 8));

        ObjectOutputStream output = null;

        //open
        try {
            output = new ObjectOutputStream(new FileOutputStream(new File("Car.ser")));

            //write
            for (Car c : cars) {
                output.writeObject(c);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error File Not Found.");
        } catch (IOException ex) {
            System.err.println("Error Can't save data.");

        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ex) {
                    System.err.println("Error during closing stream" + ex.getMessage());
                }

            }
        }

    }

    //read FROM file
    private static void readCars(ArrayList cars) {
        ReadFiles reader = new ReadFiles();
        reader.openFile("cars.ser");
        cars = reader.readRecords();
        reader.closeFile();

    }

    //write save TO file:
    public static void saveBookings() {
        WriteFiles writer = new WriteFiles();
        writer.openTextFile("bookings.txt");

        try {
            for (Booking b : bookings.getBookings()) { // Calling array compstion in BookingSystem
               writer.writeToFile(b);
         }
        } catch (NullPointerException ex) {
            System.err.println("no booking found");
        }
        writer.closeFile();
        System.out.println("All bookings has been saved to bookings.txt");
    }

}
