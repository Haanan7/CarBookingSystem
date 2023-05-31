package carbooking;

// Car Booking System project
// STUDENT: Hanan Alnazy , Renad Ajina
//    ID  :   443007512     ,  443007483
// SECTION: 2C2
//PROJECT NUMBER  : 5

public abstract class EconomyCar extends Car {
    
    
    

    public EconomyCar() {
        this(0, "", "","" ,0.0, 0.0, 0,0);
    }

    public EconomyCar(int serialNum, String name,String model, String color, double price, double kilometer, int doors,int seats) {
        super(serialNum, name ,model, color, price, kilometer, doors,seats);
    }

    @Override
    public abstract double priceCalculation() ;

    @Override
    public void displayCarInfo(){
        System.out.println("# Economy Car #");
        super.displayCarInfo() ;

    }

    @Override
    public String toString() {
      
        return String.format("%s", super.toString());
    }
}
