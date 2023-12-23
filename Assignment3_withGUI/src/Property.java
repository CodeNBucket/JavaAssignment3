import java.util.Date;
import java.util.HashMap;
import java.lang.Comparable;
/**
 * Property Class is an abstract class and has the necessary fields for storing properties and host information.
 * It has two child classes which are full property and shared property
 *
 * @author Turgut Canberk Diner
 * @version 2.0
 */
public abstract class Property implements PropertyPrice,Comparable<Property>{

    private Integer propertyId;
    private Integer noBedRooms;
    private Integer noRooms;
    private String city;
    private Double pricePerDay;
    private HashMap<Date,String> inspection;
    private Host host;

    public Property()
    {
        propertyId=0;
        noRooms=0;
        noBedRooms=0;
        city="";
        pricePerDay=0.0;
        inspection=new HashMap<>();

    }

    public Property(Integer propertyId, Integer noBedRooms, Integer noRooms, String city, Double pricePerDay) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.inspection=new HashMap<>();
        this.host= new Host();
    }

    public Property(Integer propertyId, Integer noBedRooms, Integer noRooms, String city, Double pricePerDay, Host host) {
        this.propertyId = propertyId;
        this.noBedRooms = noBedRooms;
        this.noRooms = noRooms;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.host = host;
        this.inspection=new HashMap<>();
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public Integer getNoBedRooms() {
        return noBedRooms;
    }

    public Integer getNoRooms() {
        return noRooms;
    }

    public String getCity() {
        return city;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public HashMap<Date, String> getInspection() {
        return inspection;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public void setNoBedRooms(Integer noBedRooms) {
        this.noBedRooms = noBedRooms;
    }

    public void setNoRooms(Integer noRooms) {
        this.noRooms = noRooms;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setInspection(HashMap<Date, String> inspection) {
        this.inspection.putAll(inspection);
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public abstract Double calculatePricePerDay(); //Abstract method since each property calculates price in a
    // different way

    /**
     * This method compares prices of two different property objects and returns integer value which shows the result
     *
     * @param o which is the Property object that its comparing to
     * @return int value shows which property is cheaper
     */
    @Override
    public int compareTo(Property o) {
        return this.pricePerDay.compareTo(o.pricePerDay);
    }
}
