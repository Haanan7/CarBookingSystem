package carbooking;

 
public class BMW extends LuxuryCar {
     
    // Car Booking System project
// STUDENT: Hanan Alnazy , Renad Ajina
//    ID  :   443007512     ,  443007483
// SECTION: 2C2
//PROJECT NUMBER  : 5
     
     public BMW(){
          this(0, "", "","" ,0.0, 0.0, 0,0);
    
}
    
    
 public BMW(int serialNum,String name ,String model, String color, double price, double kilometer, int doors,int seats) {
        super(serialNum,name,model,color,price,kilometer,doors,seats);
        
    }

    @Override
   //each subclass has different implementation:
    public double priceCalculation() {
        double cost = getPrice();

        //if kilometer > 180 then he will pay %20 extra cost
        if (getKilometer() >180 ) {
            cost = cost +(cost * 0.20);
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
