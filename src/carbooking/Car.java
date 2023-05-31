package carbooking;

import java.io.Serializable;

public abstract class Car implements Rentable, Serializable {

    private final int serialNum; //each car has a serial num
    private String name;
    private String model;
    private String color;
    private double price; //per day
    private double kilometer; //distance drived
    private int doors;
    private boolean available;
    private int seats;
    
    public Car() {
        this(0, "", "","" ,0.0, 0.0, 0,0);
    }

    public Car(int serialNum,String name ,String model, String color, double price, double kilometer, int doors,int seats) {
        this.serialNum = serialNum;
        this.name=name;
        this.model=model;
        this.color=color;
        this.price=price;
        this.kilometer = kilometer;
        this.doors=doors;
        this.seats=seats;
        setAvailable(true);
        
    }

    
    
    @Override
    public void rent(){
        setAvailable(false);
    }

    @Override
    public abstract double priceCalculation();
    

    
   public void displayCarInfo() {

        System.out.println("Serial Number: " + getSerialNum());
        System.out.println("Car Name: "+name);
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + getColor());
        System.out.println("Price/Day: " + getPrice() + " SAR");
        System.out.println("Final Cost/Day: " + priceCalculation()+ " SAR");
            
  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    public int getSerialNum() {
        return serialNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
    
 
   
    @Override
    public String toString() {
        return String.format("\n %-5s%-15s%-15s%-15s%-15.2f%-15.2f%-15d%-5d%-15s",getSerialNum(),getName(), getModel(), getColor(),getPrice(), getKilometer(), getDoors(), getSeats(), isAvailable() ? "Yes" : "No");
    }
}
