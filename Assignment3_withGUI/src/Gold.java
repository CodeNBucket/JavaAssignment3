import java.util.Date;
/**
 * Gold class is used to maintain information about Customers and has unique goldLevel field
 * Its a concrete sublass of the Customer class
 *
 * @author Turgut Canberk Diner
 * @version 1.0
 */
public class Gold extends Customer{

    private Integer goldLevel;


    public Gold()
    {
        super(0, new Date(), "John", "Doe", new Date(), "Cash");
        goldLevel=1;

    }
    public Gold(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String prefferedPaymentMethod, Integer goldLevel,Booking booking) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate, prefferedPaymentMethod,booking);
        this.goldLevel = goldLevel;
    }

    public Gold(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String prefferedPaymentMethod, Integer goldLevel) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate, prefferedPaymentMethod);
        this.goldLevel = goldLevel;
    }

    public Integer getGoldLevel() {
        return goldLevel;
    }

    public void setGoldLevel(Integer goldLevel) {
        this.goldLevel = goldLevel;
    }
    /**
     * This method looks at the gold level and returns relevant discount percentage, has no parameters
     *
     * @return Double value which is the discount percentage
     */
    public Double discountPercentage(){

        if(goldLevel==1)
            return 1.0;
        else if(goldLevel==2)
            return 2.0;
        else
            return 3.0;

    }
    /**
     * This method used to return details of the gold customer in a String format and has no parameters
     *
     * @return String containing the details
     */
    public String toString(){
        return "UserId: "+getUserId()+"\nUser type:Gold"+"\nDate of birth: "+ getDateOfBirth()+"\nName: "+getFirstName()+
                "\nSurname: "+getLastName()+"\nRegistration Date: "+getRegistrationDate()+"\nPreferred Payment Method: "
                +getPrefferedPaymentMethod()+"\nGold Level: "+goldLevel;

    }

}
