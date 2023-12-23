/**
 * SharedProperty class is used to maintain information about property.
 * It is a concrete subclass of the Property
 *
 * @author Turgut Canberk Diner
 * @version 1.0
 */
public class SharedProperty extends Property {

    public SharedProperty() {
        super(0, 1, 1, "Arkansas", 10.0);
    }

    public SharedProperty(Integer propertyId, Integer noBedRooms, Integer noRooms, String city, Double pricePerDay) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay);

    }

    public SharedProperty(Integer propertyId, Integer noBedRooms, Integer noRooms, String city, Double pricePerDay, Host host) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay, host);

    }
    /**
     * This method used to return details of the shared property in a String format and has no parameters
     *
     * @return String containing the details
     */
    public String toString(){
        return "PropertyId: "+getPropertyId()+"\nNumber of Bedrooms: "+getNoBedRooms()+"\nNumber of rooms: "+getNoRooms()+
                "\nCity: "+getCity()+"\nPrice per day: "+getPricePerDay()+"\nProperty type:Shared Property";
    }

    /**
     * This method used for returning price of the shared property per day
     *
     * @return Double which contains the price of the property
     */
    public Double calculatePricePerDay(){

        return(getPricePerDay()/getNoBedRooms());
    }
}
