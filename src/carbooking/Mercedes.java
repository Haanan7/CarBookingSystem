package carbooking;

public class Mercedes extends LuxuryCar {

    public Mercedes() {
         this(0, "", "","" ,0.0, 0.0, 0,0);
    }

    
  
    public Mercedes(int serialNum,String name ,String model, String color, double price, double kilometer, int doors,int seats) {
        super(serialNum, name,model, color, price, kilometer,doors,seats);
       
        
    }

    
     @Override
    public double priceCalculation() {
        double cost = getPrice();

        //if kilometer > 170 then he will pay %15 extra cost
        if (getKilometer() >170 ) {
            cost = cost +(cost * 0.15);
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
