import java.util.ArrayList;
import java.util.Date;

/**
 * User Class has the necessary fields for storing users informations
 *
 * @author Turgut Canberk Diner
 * @version 2.0
 */
public abstract class User {

    private Integer userId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Date registrationDate;


    public User() { //Default Constructor
        userId=0;
        dateOfBirth=new Date();
        firstName="";
        lastName="";
        registrationDate=new Date();
    }

    public User(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate) { //Parameterized constructor_1
        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate=registrationDate;
    }

    public User(Integer userId, Date dateOfBirth, String firstName, String lastName) {
        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate=new Date();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public abstract ArrayList<Booking> getBookings(); //get and set bookings are abstract since customer uses them for booking

    public abstract void setBookings(Booking booking);
}
