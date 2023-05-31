package carbooking;

public class Location {

    private String city;
    private int officeNum; //office number 

    public Location() {
        this("", 0);
    }

    public Location(String city, int officeNum) {
       this.city= city;
         this.officeNum = officeNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int officeNum) {
        this.officeNum = officeNum;
    }

    @Override
    public String toString() {
        return String.format("City: %s Office: %s", getCity(), getOfficeNum());
    }

}
