import java.util.ArrayList;
import java.util.Date;
/**
 * Host Class has the necessary fields for storing host information.
 *
 * @author Turgut Canberk Diner
 * @version 2.0
 */
public class Host extends User {
    private Double taxNumber;


    public Host() {
        super(0, new Date(), "John", "Doe", new Date());
        this.taxNumber = 0.0;
    }

    public Host(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, Double taxNumber) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate);
        this.taxNumber = taxNumber;
    }

    public Host(Integer userId, Date dateOfBirth, String firstName, String lastName,Double taxNumber) {
        super(userId, dateOfBirth, firstName, lastName);
        this.setRegistrationDate(new Date());
        this.taxNumber=taxNumber;
    }

    public String toString(){
        return "UserId: "+getUserId()+"\nUser type:Host"+"\nDate of birth: "+ getDateOfBirth()+"\nName: "+getFirstName()+
                "\nSurname: "+getLastName()+"\nRegistration Date: "+getRegistrationDate()+"\nTax number"+taxNumber;

    }
    public void setTaxNumber(Double taxNumber) {
        this.taxNumber = taxNumber;
    }

    public Double getTaxNumber() {
        return taxNumber;
    }

    public void setBookings(Booking booking){ //Needed getters and setter for booking since User has to be an
        // abstract class and  we want to be able to make bookings with just User in BASIC, thats why host class need
        // these even if it's not gonna use them

    }

    public ArrayList<Booking> getBookings(){
        ArrayList<Booking> bookings=new ArrayList<Booking>();
        return bookings;
    }



}
