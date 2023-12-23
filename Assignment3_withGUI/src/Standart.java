import java.util.Date;

/**
 * Standart class is used to maintain information about users.
 * It is a concrete subclass of the User
 *
 * @author Turgut Canberk Diner
 * @version 1.0
 */
public class Standart extends Customer{


    public Standart(){
        super(0, new Date(), "John", "Doe", new Date(), "Cash");
    }

    public Standart(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String prefferedPaymentMethod,Booking booking) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate, prefferedPaymentMethod,booking);
    }
    public Standart(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String prefferedPaymentMethod) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate, prefferedPaymentMethod);
    }

    /**
     * This method used to return percentage of the discount and has no parameters
     *
     * @return Double contains the discount percentage
     */

    public Double discountPercentage(){
        long start=getRegistrationDate().getTime(),end=new Date().getTime(),years;
        years=(end-start)/86400000/365; //Returns year
        if(years>=10)
            return 2.0;
        else
            return 0.0;
    }

    /**
     * This method used to return details of the Standart user in a String format and has no parameters
     *
     * @return String containing the details
     */
    public String toString(){
        return "UserId: "+getUserId()+"\nUser type:Standart"+"\nDate of birth: "+ getDateOfBirth()+"\nName: "+getFirstName()+
                "\nSurname: "+getLastName()+"\nRegistration Date: "+getRegistrationDate()+"\nPreferred Payment Method: "
                +getPrefferedPaymentMethod();

    }
}
