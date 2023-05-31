package carbooking;


public class Kia extends FamilyCar{

    public Kia() {
         this(0, "", "","" ,0.0, 0.0, 0,0);
    }
    
    
    public Kia (int serialNum,String name ,String model, String color, double price, double  kilometer, int doors,int seats) {
        super(serialNum,name ,model, color, price, kilometer,doors, seats);
         
    }
 @Override
   public double priceCalculation() {

        double cost = getPrice();

        //if kilometer > 260 then he will pay %7 extra cost
        if (getKilometer() >260 ) {
            cost = cost +(cost * 0.07);
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

