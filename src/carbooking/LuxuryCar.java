package carbooking;

public abstract class LuxuryCar extends Car {

    public LuxuryCar() {
         this(0, "", "","" ,0.0, 0.0, 0,0);
    }

    public LuxuryCar(int serialNum,String name ,String model, String color, double price, double kilometer, int doors,int seats) {
        super( serialNum,name ,model, color, price, kilometer, doors,seats);
    }

     @Override
    public abstract double priceCalculation();
     
    @Override
    public void displayCarInfo() {
        System.out.println("# Luxury Car: #");
        super.displayCarInfo();
  }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }
}
