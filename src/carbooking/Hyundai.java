
package carbooking;


public class Hyundai  extends EconomyCar {
    
    //private boolean bulootth; true:
    
    public Hyundai (int serialNum,String name ,String model, String color, double price, double kilometer, int doors,int seats) {
        super(serialNum,name ,model, color, price, kilometer,doors,seats);
    
    }

    @Override
    public double priceCalculation() {

        double cost = getPrice();

        //if kilometer > 220 then he will pay %12 extra cost
        if (getKilometer() >220 ) {
            cost = cost +(cost * 0.12);
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
