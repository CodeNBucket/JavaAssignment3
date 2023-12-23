/**
 * FullProperty class is used to maintain information about property and adds property size as it is unique for itself
 * Its an concrete class and is a subclass of Property
 *
 * @author Turgut Canberk Diner
 * @version 1.0
 */
public class FullProperty extends Property{
    Double propertySize;


    public FullProperty() {
        super(0, 1, 1, "Arkansas", 10.0);
        propertySize=10.0;
    }

    public FullProperty(Integer propertyId, Integer noBedRooms, Integer noRooms, String city, Double pricePerDay, Host host, Double propertySize) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay, host);
        this.propertySize = propertySize;
    }

    public FullProperty(Integer propertyId, Integer noBedRooms, Integer noRooms, String city, Double pricePerDay, Double propertySize) {
        super(propertyId, noBedRooms, noRooms, city, pricePerDay);
        this.propertySize = propertySize;
    }

    public Double getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(Double propertySize) {
        this.propertySize = propertySize;
    }
    /**
     * This method used to return details of the full property in a String format and has no parameters
     *
     * @return String containing the details
     */

    public String toString(){
        return "PropertyId: "+getPropertyId()+"\nNumber of Bedrooms: "+getNoBedRooms()+"\nNumber of rooms: "+getNoRooms()+
                "\nCity: "+getCity()+"\nPrice per day: "+getPricePerDay()+"\nProperty Size: "+propertySize+"\nProperty type:Full Property";
    }

    /**
     * This method used to return calculated price and has no parameters
     *
     * @return Double value of the price
     */
    public Double calculatePricePerDay(){


        if(propertySize<200)
        {

            return getPricePerDay()*101/100;

        }
        else if(200<=propertySize && propertySize<=300)
        {
            return getPricePerDay()*103/100;
        }
        else
        {
            return getPricePerDay()*104/100;
        }
    }

}