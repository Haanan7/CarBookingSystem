package carbooking;

// Car Booking System project
// STUDENT: Hanan Alnazy , Renad Ajina
//    ID  :   443007512     ,  443007483
// SECTION: 2C2
//PROJECT NUMBER  : 5
import java.time.LocalDate;
public class Customer {

    private String name;
    private int age;
    private String id;
    private String contactNum;
    private String licenceNum;
    private LocalDate licenceExpiry;
    

    public Customer() {
        this("", 0, "", "",null, "");
    }

    public Customer(String name, int age, String id, String licenceNum, String licenceExpiry,String contactNum) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.licenceNum = licenceNum;
        this.contactNum = contactNum;

    }

    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
         }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContactNum() {
        return contactNum;
    }
    public void setContactNum(String contactNum) {

        this.contactNum = contactNum;
    }
    public String getLicenceNum() {
        return licenceNum;
    }
    public void setLicenceNum(String licenceNum) {
        this.licenceNum = licenceNum;
    }

    public LocalDate getLicenceExpiry() {
        return licenceExpiry;
    }

    public void setLicenceExpiration(String licenceExpiry) {
        this.licenceExpiry = LocalDate.parse(licenceExpiry);
        
    }
    
    
    
    @Override
    public String toString() {
        return String.format("Customer: %S's, ID: %s, %d years old, phone number: %S, Licence number: %s \n", getName(), getId(), getAge(), getContactNum(), getLicenceNum() );
    }
}
