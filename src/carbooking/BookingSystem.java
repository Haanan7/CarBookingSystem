/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carbooking;


public class BookingSystem  {
    
   private Booking[] bookings;
   private static int numOfBookings;
   private final int  MAX_BOOKING=100; //because in ksa each rental shop should have 100 cars at least
   
   public BookingSystem() {
        bookings = new Booking[MAX_BOOKING];
        numOfBookings++;
     
    }

    public BookingSystem(Booking[] bookings) {
        this.bookings = bookings;
    }

   

    public Booking[] getBookings() {
        return bookings;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }

    public static int getNumOfBookings() {
        return numOfBookings;
    }

    public static void setNumOfBookings(int numOfBookings) {
        BookingSystem.numOfBookings = numOfBookings;
    }
    public int getMAX_BOOKING() {
        return MAX_BOOKING;
    }
   
   
     public void addBooking(Booking b) {
        try {
              if (numOfBookings >= MAX_BOOKING) {
                System.out.println("Sorry you can't book Car any more");
            } else {
                bookings[numOfBookings] = b;
                numOfBookings++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Incorrect index");
        }
         
                bookings[numOfBookings++] = b;
      
    }

    public void showBooking(int id) {
        boolean isFound = false;
  
            for (Booking booking : bookings) {
                if (booking != null) {
                    if (booking.getBOOKING_ID() == id) {
                        booking.printBill();
                        isFound = true;    
                        break;
                    }
                }
            }
        if (!isFound) {
            System.out.println("Booking wasn't found");
        }
    }

    public void cancelBooking(int id) {
        boolean isFound = false;
        try {
            for (Booking booking : bookings) {
                if (booking.getBOOKING_ID()== id) {
                        isFound = true;
                        booking.setStatus("\u001B[41m" + "Cancelled" + "\u001B[47m");
                        System.out.println("Booking has been cancelled successfully.");
                        break;
                    }
             
            }
        } catch (NullPointerException ex) {
            System.out.println("No booking object");
        }
        if (!isFound) {
            System.out.println("Booking wasn't found");
        }
    }

    
    
    
    
}
