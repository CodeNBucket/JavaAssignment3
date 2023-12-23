import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * BASIC class is used to maintain information about users and the properties maintained by this application.
 * BASIC also has the main method and is providing the overall interaction with the application.
 *
 * @author Turgut Canberk Diner
 * @version 2.0
 */
public class BASIC {

    public ArrayList<User> users;
    public ArrayList<Property> properties;

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        BASIC basic = new BASIC();
        basic.users = new ArrayList<User>();
        basic.properties = new ArrayList<Property>();


        System.out.println("Welcome to the application!!!");
        while (true) {
            basic.menu(); //Menu of the application
        }

    }

    /**
     * This is the method used for menu operations it has no parameter
     * It doesn't return any value
     */

    public void menu() {
        int choice, x, y;
        System.out.print("1-)Add User\n2-)Delete User\n3-)Get User Details \n4-)Add Property \n5-)Delete Property \n6-)Get Property Details " +
                "\n7-)Add Booking \n8-)Get User's Booking \n9-)Get Booking Cost \n10-)List Users \n11-)List Properties " +
                "\n12-)Get Discount \n13-)Add Inspection \n14-)Compare Property Prices \n15-)Exit \n");
        System.out.print("Choose between 1-15:");

        try{choice = input.nextInt();
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    System.out.print("Write the user ID:");
                    x = input.nextInt();
                    deleteUser(x);
                    break;
                case 3:
                    System.out.print("Write the user ID:");
                    x = input.nextInt();
                    getUserDetails(x);
                    break;
                case 4:
                    addProperty();
                    break;
                case 5:
                    System.out.print("Write the Property ID:");
                    x = input.nextInt();
                    deleteProperty(x);
                    break;
                case 6:
                    System.out.print("Write the Property ID:");
                    x = input.nextInt();
                    getPropertyDetails(x);
                    break;
                case 7:
                    System.out.print("Write the user ID:");
                    x = input.nextInt();
                    System.out.print("Write the Property ID:");
                    y = input.nextInt();
                    addBooking(x, y);
                    break;
                case 8:
                    System.out.print("Write the user ID:");
                    x = input.nextInt();
                    getUserBooking(x);
                    break;
                case 9:
                    System.out.print("Write the user ID:");
                    x = input.nextInt();
                    System.out.print("Write the Property ID:");
                    y = input.nextInt();
                    getBookingCost(x, y);
                    break;
                case 10:
                    listUsers();
                    break;
                case 11:
                    listProperties();
                    break;
                case 12:
                    System.out.print("Write the user ID:");
                    x = input.nextInt();
                    Double d=getDiscountForUser(x);
                    System.out.println("Discount percentage is "+d);
                    break;
                case 13:
                    System.out.print("Write the property  ID:");
                    x = input.nextInt();
                    System.out.print("Write the sentence your want to add:");
                    input.nextLine();
                    String string = input.nextLine();
                    try{
                        addInspectionToProperty(x,string);}
                    catch(Exception e){System.out.println("Error");}
                    break;
                case 14:
                    System.out.print("Write the first property  ID:");
                    x = input.nextInt();
                    System.out.print("Write the second property  ID:");
                    y = input.nextInt();
                    comparePropertyPricesPerDay(x,y);
                    break;
                case 15:
                    System.out.println("Hasta la vista!");
                    exit();
                    break;
                default:
                    System.out.println("Please write a number between the proper values(1-15!)");}

        }
        catch (InputMismatchException e) //In case any input mismatch it catches the error, ni this applicatiın
        // this error occurs when a
        // non-integer character is written to input
        {
            System.out.println("Write the proper input!(integer value)");
            input.nextLine();// To avoid infinite loop

        }


    }

    /**
     * This method is used for adding users to the userlist, it has no parameters.
     * It doesn't return any value.
     */

    public void addUser() {
        Scanner input = new Scanner(System.in);//Otherwise it doesn't read the first input due to the empty-line
        String name, surname, method;
        Date date = null;
        User user = null;
        Date current_date = new Date();
        int id, type, level;
        System.out.print("Write the name of the user");
        name = input.nextLine();
        System.out.print("Write the surname of the user");
        surname = input.nextLine();
        date = dateFormatter(0);//Gets the birth date of the user
        if (users.size() == 0) {// If user list is empty
            id = 1;
        } else {
            id = (users.get(users.size() - 1).getUserId()) + 1;
        }//This way user id is always unique for users
        do {
            try{System.out.println("User is:\n1-)Host\n2-)Standart Customer\n3-)Gold Customer");
                type = input.nextInt();
                if (type > 3 || type < 0)
                    System.out.println("Write a number between 1-3");}
            catch (InputMismatchException e) //Catches error if there is a non-integer character given as input
            {System.out.println("Write the proper input!(integer value)");
                type=5;
                input.nextLine();}
        } while (type > 3 || type < 0);

        if (type == 1) {//Host
            System.out.println("Write the tax-number");
            Double taxNo = input.nextDouble();
            user = new Host(id, date, name, surname, taxNo);
        } else if (type == 2) {//Standart
            System.out.println("Write preffered payment method:");
            input.nextLine();//Otherwise it doesn't read the first input due to the empty-line
            method = input.nextLine();
            user = new Standart(id, date, name, surname, current_date, method);

        } else {//Gold
            System.out.println("Write preffered payment method:");
            input.nextLine();//Otherwise it doesn't read the first input due to the empty-line
            method = input.nextLine();
            do {
                System.out.println("Write gold level 1-3!");
                level = input.nextInt();
                if (level > 3 || level < 0)
                    System.out.println("Write a number between 1-3");
            } while (level > 3 || level < 0);
            user = new Gold(id, date, name, surname, current_date, method, level);
        }
        users.add(user);

    }

    /**
     * This method is used for adding users to the userlist
     * @param userId is the user id
     * It doesn't return any value.
     */
    public void deleteUser(Integer userId) {
        boolean check = false;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                users.remove(i);
                check = true;
                System.out.println("User with the id " + userId + " is deleted from the system");
            }
        }
        if (!check) {
            System.out.println("User id does not exist!");
        }

    }

    /**
     * This method used to get the details of a specific user from the list.
     *
     * @param userId is the userId.
     */
    public void getUserDetails(Integer userId) {
        boolean check = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                check = true;
                System.out.println(users.get(i));
            }
        }
        if (!check) {
            System.out.println("User id does not exist!");
        }

    }

    /**
     * This method used to add property to the property arrayList.
     * It doesn't take input parameters and does not return anything.
     */
    public void addProperty() {
        int id, noBedRooms, noRooms, type, userID;
        String city;
        boolean check = false;
        Double priceperday;
        Property property =null;
        User user = null;
        System.out.print("Write the number of bedrooms: ");
        noBedRooms = input.nextInt();
        System.out.print("Write the number of rooms: ");
        noRooms = input.nextInt();
        System.out.print("Write the city: ");
        input.nextLine();//Otherwise it doesn't read the next input due to the empty-line
        city = input.nextLine();
        System.out.print("Write the price of the room: ");
        priceperday = input.nextDouble();
        System.out.print("Write the hosts userId: ");
        userID = input.nextInt();
        do {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserId() == userID && users.get(i) instanceof Host) { //Checks if the user is host
                    check = true;
                    user = users.get(i);
                }

            }
            if (check == false) {
                System.out.print("Host doesn't exist, please write an host id:");
                userID = input.nextInt();
            }
        }while(check==false);

        if (properties.size() == 0) {
            id = 1;
        } else {
            id = (properties.get(properties.size() - 1).getPropertyId()) + 1;
        }//This way property id is always unique for properties
        do {
            System.out.println("Property is:\n1-)Shared Property\n2-)Full Property");
            type = input.nextInt();
            if (type > 2 || type < 0)
                System.out.println("Write a number between 1-2!");
        } while (type > 2 || type < 0);

        if (type == 1) {//SharedProperty
            property = new SharedProperty(id, noBedRooms, noRooms, city, priceperday, (Host) user);

        } else { //Full property
            System.out.println("Write the square-meter of the property");
            Double meter = input.nextDouble();
            property = new FullProperty(id, noBedRooms, noRooms, city, priceperday, (Host) user, meter);


        }

        properties.add(property);
    }


    /**
     * This method used to delete specific property from the list.
     *
     * @param propertyId is the propertyId.
     */
    public void deleteProperty(Integer propertyId) {
        boolean check = false;

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId) {
                properties.remove(i);
                check = true;
                System.out.println("Property with the id " + propertyId + " is deleted from the system");
            }
        }
        if (!check) {
            System.out.println("Property id does not exist!");
        }


    }

    /**
     * This method used to get the details of a specific user from the list.
     *
     * @param propertyId is the propertyId.
     */
    public void getPropertyDetails(Integer propertyId) {
        boolean check = false;
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId) {

                check = true;
                System.out.println(properties.get(i));
                System.out.println("\nHost details are:\n"+properties.get(i).getHost());

            }
        }
        if (!check) {
            System.out.println("Property id does not exist!");
        }
    }

    /**
     * This method used to add booking for a user to a property.
     *
     * @param userId     is the userId.
     * @param propertyId is the propertyId.
     */


    public void addBooking(Integer userId, Integer propertyId) {
        boolean check_userid = false, check_propertyid = false, check_host = false;
        Date start_date = null, end_date = null;
        User user = null;
        Property property = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                check_userid = true;
                user = users.get(i);
                if (user instanceof Host) { //Checks if the user is host
                    check_host = true;
                }
            }

        }

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId) {

                check_propertyid = true;
                property = properties.get(i);
            }

        }

        if (!check_userid) {
            System.out.println("User id does not exist!");
            return;
        }
        if (!check_propertyid) {
            System.out.println("Property id does not exist!");
            return;
        }
        if (check_host) {
            System.out.println("User id belong to host not customer!"); //So that it doesn't allow for booking
            return;
        }
        start_date = dateFormatter(1); //Asks and gets start date
        end_date = dateFormatter(2); //Asks and gets end date

        Booking booking = new Booking(start_date, end_date, property);
        user.setBookings(booking);

    }

    /**
     * This method used to get booking details of a user.
     *
     * @param userId is the userId.
     */
    public void getUserBooking(Integer userId) {

        boolean check = false;
        User user;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) {
                check = true;
                user=users.get(i);

                try {
                    if (users.get(i).getBookings().isEmpty()) {
                        System.out.println("User has no bookings ");
                    } else {
                        for (int j = 0; j < users.get(i).getBookings().size(); j++) {

                            System.out.println("Booking is for: " + users.get(i).getBookings().get(j).getProperty().getCity());

                            System.out.printf("%s %tB %<te, %<tY", "Start date is: ", users.get(i).getBookings().get(j).getStartDate());
                            System.out.printf("%s %tB %<te, %<tY", "\nEnd date is: ", users.get(i).getBookings().get(j).getEndDate());
                            System.out.println();
                        }
                    }
                }
                catch (NullPointerException n) // If returns null from getBookings
                {
                    if(user instanceof Host)
                        System.out.println("Booking couldn't found since the user is a host");
                    else
                        System.out.println("User doesn't have any booking");
                }
            }
        }
        if (!check) {
            System.out.println("Property id does not exist!");
        }

    }
    // }

    /**
     * This method used to get the booking cost of a users stay in a property.
     *
     * @param userId is the userId.
     * @param propertyId is the propertyId.
     *
     */

    public void getBookingCost (Integer userId, Integer propertyId)
    {
        boolean check1 = false, check2 = false;
        User user = null;
        Property property=null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId() == userId) { //Checks if user id exists
                check1 = true;
                user = users.get(i);
            }
        }

        for (int i = 0; i < properties.size(); i++) { //Checks if property id exists
            if (properties.get(i).getPropertyId() == propertyId) {

                check2 = true;
                property=properties.get(i);
            }

        }

        if (!check1) {
            System.out.println("User id does not exist!");
            return;
        }
        if (!check2) {
            System.out.println("Property id does not exist!");
            return;
        }
        try {
            for (int i = 0; i < user.getBookings().size(); i++) { //Loops all the bookings the user has
                if (user.getBookings().get(i).getProperty() == property) {
                    System.out.printf("Cost for the property is %.1f$\n", user.getBookings().get(i).totalCost()-(user.getBookings().get(i).totalCost()*(getDiscountForUser(user.getUserId())/100)));
                }
            }
        }
        catch (NullPointerException n) //If user has no booking or its a host
        {
            {
                if(user instanceof Host)
                    System.out.println("Booking couldn't found since the user is a host");
                else
                    System.out.println("User doesn't have any booking");
            }
        }

    }





    /**
     * This method used for listing all the users informations.
     *
     * This method has no input parameters and doesn't return anything.
     */


    public void listUsers ()
    {

        for (int i = 0; i < users.size(); i++) {


            System.out.println(users.get(i)+"\n");

        }


    }

    /**
     * This method used for listing all the properties informations.
     *
     * This method has no input parameters and doesn't return anything.
     */
    public void listProperties ()
    {

        for (int i = 0; i < properties.size(); i++) {


            System.out.println("\nProperty Details are:\n"+properties.get(i)+"\n");
            System.out.println("Host details are:\n"+properties.get(i).getHost());
        }

    }

    /**
     * This method is used for getting discount percentage of the user
     * @param userId is the user id
     * @return Double which is the discount value
     */
    public Double getDiscountForUser(Integer userId){
        User user=null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserId()==userId)
            {
                user=users.get(i);
                if (user instanceof Gold) //If user is gold
                {
                    if(((Gold) user).getGoldLevel()==1)
                        return 1.0;
                    if(((Gold) user).getGoldLevel()==2)
                        return 2.0;
                    if(((Gold) user).getGoldLevel()==3)
                        return 3.0;
                }
                else if(user instanceof Standart) // If user is standart
                {
                    Date registration=((Standart)user).getRegistrationDate();
                    Date current_date=new Date();
                    long years=current_date.getTime()-registration.getTime()/86400000/365; //Calculates the
                    // difference between registration time and current time and turns it into years
                    if(years>=10)
                    {
                        return 2.0;
                    }
                    else
                        return 0.0;
                }
                else //If user is host
                    System.out.println("Host doesn't have discount!");
                return 0.0;
            }

        }

        System.out.println("Couldn't found the user!");

        return 0.0;
    }

    /**
     * This method is used for adding inspections to the property
     * @param propertyId is the property id
     * @param string is the simple string which used as the value of hashmap
     * It doesn't have a return
     */
    public void addInspectionToProperty(int propertyId, String string) throws ParseException {

        Property property=null;
        HashMap<Date,String> hashMap=new HashMap<Date,String>();
        Date current=new Date();
        Calendar calender=Calendar.getInstance(); //Used calender for identifying the date correctly
        calender.setTime(current);
        int day=calender.DAY_OF_MONTH;
        int month=calender.MONTH;
        int year=calender.YEAR;
        SimpleDateFormat simple_date = new SimpleDateFormat("dd/MM/yyyy"); //Formatting the date according to pdf
        String formatted_date=day+"/"+month+"/"+year;
        current=simple_date.parse(formatted_date);
        boolean check=false;
        for (int i = 0; i < properties.size(); i++) { //Checks if property Id exists
            if(properties.get(i).getPropertyId()==propertyId)
            {   check=true;
                property=properties.get(i);
                if(property.getInspection().containsKey(current))
                {
                    System.out.println("You already added inspection for this property today");
                    return;
                }
                else
                {   hashMap.put(current,string); //Puts the key and value pair to hashmap
                    property.setInspection(hashMap);//Inserts it to properties inspection
                }
            }

        }
        if (check==false)
            System.out.println("Couldn't found the property!");

    }
    /**
     * This method is used for comparing prices of different properties
     * @param propertyId_one is the property id of the first property
     * @param propertyId_two is the property id of the second property
     * It doesn't have a return
     */
    public void comparePropertyPricesPerDay(int propertyId_one, int propertyId_two)
    {
        boolean check_one=false,check_two=false;
        Property property_one = null,property_two=null;
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId() == propertyId_one) { //Checks if property_1 id exists
                check_one = true;
                property_one = properties.get(i);
            }
            if (properties.get(i).getPropertyId() == propertyId_two) { //Checks if property_2 id exists
                check_two = true;
                property_two = properties.get(i);
            }
        }
        if(!check_one)
        {
            System.out.println("Property one doesn't exist");

        }
        else if(!check_two)
        {
            System.out.println("Property two doesn't exist");

        }
        else if(property_one.compareTo(property_two)>0)
        {
            System.out.println("Property ID "+property_two.getPropertyId()+" is cheaper");
        }
        else if(property_one.compareTo(property_two)<0)
        {
            System.out.println("Property ID "+property_one.getPropertyId()+" is cheaper");
        }
        else
        {
            System.out.println("They have the same price!");
        }


    }






    /**
     * This method used for terminating the program.
     *
     * This method has no input parameters and doesn't return anything.
     */
    public void exit ()
    {
        System.exit(0);
    }

    /**
     * This method used for formatting the Date class so that it can be taken as an input in a user-friendly way.
     *
     * @param choice is used as a indicator where it is called
     * @return is returning the date
     */
    public Date dateFormatter (int choice){

        String str = null;
        Date date = null;
        int check = 0;
        SimpleDateFormat simple_date = new SimpleDateFormat("dd/MM/yyyy"); //Formatting the date according to pdf
        while (check != 1) { //This is a loop for taking the date correctly
            if (choice == 0) {
                System.out.print("Write the date of birth (dd/mm/yyyy format):");
                input.nextLine();//Otherwise it doesn't read the first input due to the empty-line
                str = input.nextLine();
            }
            if (choice == 1) {
                System.out.print("Write start date (dd/mm/yyyy format):");
                input.nextLine();//Otherwise it doesn't read the first input due to the empty-line
                str = input.nextLine();
            }
            if (choice == 2) {
                System.out.print("Write the end date (dd/mm/yyyy format):");
                str = input.nextLine();
            }
            try {
                date = simple_date.parse(str);
                check = 1; //If the date input format is correct it will turn the check to 1 instead of giving error,until it happens it will be in a loop
            } catch (ParseException e) {
                System.out.println("Please use the correct date format!!");

            }
        }
        return date;

    }

}

