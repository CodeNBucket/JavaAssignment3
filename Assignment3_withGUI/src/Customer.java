import java.util.ArrayList;
import java.util.Date;
/**
 * Customer class is an abstract class used to maintain information about customers,it has two subclasses which
 * are gold and standart and its a subclass of User class
 *
 * @author Turgut Canberk Diner
 * @version 1.0
 */
public abstract class Customer extends User {
    private String prefferedPaymentMethod;
    private ArrayList<Booking> bookings;

    public Customer() {
        super(0, new Date(), "John", "Doe", new Date());
        bookings=new ArrayList<Booking>();
        prefferedPaymentMethod="Cash";
    }

    public Customer(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String prefferedPaymentMethod,Booking booking) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate);
        bookings=new ArrayList<Booking>();
        this.bookings.add(booking);
        this.prefferedPaymentMethod = prefferedPaymentMethod;
    }

    public Customer(Integer userId, Date dateOfBirth, String firstName, String lastName, Date registrationDate, String prefferedPaymentMethod) {
        super(userId, dateOfBirth, firstName, lastName, registrationDate);
        bookings=new ArrayList<Booking>();
        this.prefferedPaymentMethod = prefferedPaymentMethod;
    }



    public String getPrefferedPaymentMethod() {
        return prefferedPaymentMethod;
    }

    public void setPrefferedPaymentMethod(String prefferedPaymentMethod) {
        this.prefferedPaymentMethod = prefferedPaymentMethod;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Booking booking) {
        bookings.add(booking);
    }

    public abstract Double discountPercentage(); //Abstract since discount percentage is different for gold and
    // standart customers
}
