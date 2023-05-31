
package carbooking;



    public class GMC extends FamilyCar{

    public GMC() {
         this(0, "", "","" ,0.0, 0.0, 0,0);
    }
    
        
    public GMC (int serialNum, String name,String model, String color, double price, double kilometer, int doors,int seats) {
        super( serialNum,name ,model, color,price,kilometer,doors,seats);
         
    }
    

    
   @Override
    public double priceCalculation() {

        double cost = getPrice();

        //if kilometer > 250 then he will pay %5 extra cost
        if (getKilometer() >250 ) {
            cost = cost +(cost * 0.05);
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
