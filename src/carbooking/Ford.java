package carbooking;

// Car Booking System project
// STUDENT: Hanan Alnazy , Renad Ajina
//    ID  :   443007512     ,  443007483
// SECTION: 2C2
//PROJECT NUMBER  : 5


public class Ford extends EconomyCar {
    
 public Ford (int serialNum,String name ,String model, String color, double price, double kilometer, int doors,int seats) {
        super(serialNum,name  ,model,  color,  price,  kilometer,  doors,seats);
         
    }

    @Override
    public double priceCalculation() {

        double cost = getPrice();

        //if kilometer > 200 then he will pay %10 extra cost
        if (getKilometer() >200 ) {
            cost = cost +(cost * 0.10);
        }
        return cost;
    }
    
    @Override
    public void displayCarInfo() {
    super.displayCarInfo();

    }

    
    @Override
    public String toString() {
     return String.format("%s", super.toString());
    }
        
 
}
