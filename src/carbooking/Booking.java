package carbooking;

// Car Booking System project
// STUDENT: Hanan Alnazy , Renad Ajina
//    ID  :   443007512     ,  443007483
// SECTION: 2C2
//PROJECT NUMBER  : 5

import java.time.LocalDate;

public class Booking implements Taxable, Billable {

    
    private final int BOOKING_ID;
    private String status;
    private Customer customer;
    private Car car;
    private Location pickupLocation;
    private Location dropOffLocation;
    private LocalDate pickupDate;
    private int numOfDays;
    

    public Booking() {
        this(null, null, null, null, null, 0);
    }

    public Booking(Customer customer, Car car, Location pickupLocation, Location dropOffLocation, String pickupDate, int numOfDays) {
        BOOKING_ID = randomId();
        this.customer=customer;
        this.car=car;
        this.pickupLocation=pickupLocation;
        this.dropOffLocation=dropOffLocation;
        this.numOfDays=numOfDays;
        setStatus("Not Confirmed");

    }

    public int getBOOKING_ID() {
        return BOOKING_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer =customer ;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(Location dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = LocalDate.parse(pickupDate);
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays =numOfDays ;
    }

    
    @Override
    public double totalPriceCalculation() {
        
        
        double cost ;
        cost = car.priceCalculation() * getNumOfDays();
        
        //add 15% Tax
        cost = cost + (cost *TAX);
        
        //if he rent more than 28 days he will get 30% discount
        if (numOfDays >28){
            cost = cost -(cost*0.30);
        }
        return cost;
    }
      public int randomId() {
        return (int) (Math.random() * (1000 - 1) + 1);

    }

    @Override
    public void printBill() {
        System.out.println("\n------------------Receipt------------------");
        System.out.println("Booking Id: " + getBOOKING_ID());
        System.out.println("Booking date: " + LocalDate.now() );
        System.out.println("Status: " + getStatus());
        System.out.println("---------------------------------------------");
        car.displayCarInfo();
        System.out.println(getCustomer());
        System.out.printf("Total: %.2f SAR.%n",totalPriceCalculation() );
        System.out.println("---------------------------------------------");
    }

     @Override
    public String toString() {
        return String.format("Booking Id: %d\nStatus: %s\nCar:%s  ",getBOOKING_ID(),getStatus(), car );
    }
     
}
