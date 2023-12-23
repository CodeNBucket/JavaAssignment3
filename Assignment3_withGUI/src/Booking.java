import java.util.Date;
/**
 * Booking class is used to maintain information about booking details and property.
 *
 * @author Turgut Canberk Diner
 * @version 2.0
 */
public class Booking {

    private Date startDate;
    private Date endDate;
    private boolean isPaid;

    private Property property;

    public Booking() {
        startDate=new Date();
        endDate=new Date();
        isPaid=false;
        property=null;
    }

    public Booking(Date startDate, Date endDate, boolean isPaid, Property property) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isPaid = isPaid;
        this.property = property;
    }

    public Booking(Date startDate, Date endDate, Property property) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.property = property;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * This method used to get the totalCost of the booking.
     *
     * It has no input parameters
     * @return float which is the calculated cost of the booking
     */
    public Float totalCost()
    {

        long start=startDate.getTime(),end=endDate.getTime(),days;
        days=(end-start)/86400000;

        return (float) (property.calculatePricePerDay()*days);

    }
}
