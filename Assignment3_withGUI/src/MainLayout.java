import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class MainLayout extends JFrame{
    private JPanel main_panel;
    private JPanel mainPage;
    private JPanel addUser;
    private JPanel deleteUser;
    private JPanel getUserDetails;
    private JPanel addProperty;
    private JPanel deleteProperty;
    private JPanel getPropertyDetails;
    private JPanel addBooking;
    private JPanel getUserBooking;
    private JPanel getBookingCost;
    private JPanel listUsers;
    private JPanel listProperties;
    private JPanel getDiscountAmount;
    private JPanel addInspection;
    private JPanel comparePrices;
    private JTextField name_text;
    private JTextField surname_text;
    private JTextField birth_text;
    private JPanel First_user;
    private JPanel Second_user;
    private JComboBox comboBox1;
    private JPanel Host;
    private JPanel Standart;
    private JPanel Gold;
    private JTextField tax_no;
    private JTextField standartPayment;
    private JTextField goldPayment;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JPanel Empty;
    private JButton hostButton;
    private JButton standartButton;
    private JButton goldButton;
    private JPanel Container;
    private JTextField deleteUserId;
    private JButton deleteUserSubmit;
    private JPanel First_property;
    private JPanel Second_property;
    private JTextField no_of_bedrooms;
    private JTextField no_of_rooms;
    private JTextField city;
    private JTextField room_price;
    private JTextField host_id;
    private JComboBox comboBox2;
    private JPanel Empty_property;
    private JPanel Shared;
    private JPanel Full;
    private JButton sharedButton;
    private JTextField meter;
    private JButton fullButton;
    private JPanel Container_delete;
    private JTextField deletePropertyId;
    private JButton deleteButtonProperty;
    private JPanel Container_userDetails;
    private JTextField userDetails_Id;
    private JButton userDetailsSubmit;
    private JPanel Table_userDetails;
    private JPanel Container_propertyDetails;
    private JTextField propertyIdpropertydetails;
    private JButton propertydetailbutton;
    private JPanel Container_discount;
    private JTextField getDiscountUserId;
    private JButton getDiscountButton;
    private JPanel ContainerInspection;
    private JPanel Container_compare1;
    private JTextField compareFirstPricesPropertyId;
    private JTextField compareSecondPricesPropertyId;
    private JButton compareFirstPricesButton;
    private JTextField addInspectionPropertyId;
    private JTextArea addInspectionsNote;
    private JButton addInspectionButton;
    private JButton showuserdetails_button;
    private JPanel listUsersPanel;
    private JPanel EmptyPanel_userDetails;
    private JPanel Table_userdetails;
    private JPanel panel;
    private JButton listallusersbutton;
    private JTable listalluserstable;
    private JPanel mainPanelListProperties;
    private JPanel TablePanelProperty;
    private JButton listallpropertiesbutton;
    private JPanel EmptyPanel_PropertyDetails;
    private JPanel Table_propertydetails;
    private JTable listallpropertytable;
    private JPanel addbookingpanel;
    private JTextField addBookinguserId;
    private JTextField addBookingPropertyId;
    private JTextField addBookingStartDate;
    private JTextField addBookingEndDate;
    private JButton addBookingButton;
    private JPanel getUserBookingPanel;
    private JTextField getUserBookinguserId;
    private JPanel getUserBookingTablePanel;
    private JPanel EmptyPanel;
    private JPanel getUserBookingTableSubPanel;
    private JTable getUserBookingTable;
    private JButton getUserBookingButton;
    private JPanel getBookingCostMainPanel;
    private JTextField getBookingCostUserId;
    private JTextField getBookingCostPropertyId;
    private JButton getBookingCostButton;

    private JPanel homePanel;

    private Host host;
    private Standart standart;
    private Gold gold;

    public ArrayList<User> users;
    public ArrayList<Property> properties;
    public ArrayList<Booking> bookings;


    MainLayout() {


        setContentPane(main_panel);
        users = new ArrayList<User>();
        properties = new ArrayList<Property>();
        bookings=new ArrayList<Booking>();
        loadUsers(); //Loads the user information at the beginning
        loadProperties();
        JMenuBar bar;
        bar = createMenuBar();
        combobox_for_addUser(comboBox1);
        combobox_for_addProperty(comboBox2);
        setJMenuBar(bar);

        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) { //To save the gold-standart-host users and full-shared properties to specified files while exiting the program
                saveUsers();
                saveProperties();
            }
        });


        comboBox1.addItemListener(new ItemListener() { //Shows the relevant user panel to the user when the option is selected from combobox
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (comboBox1.getSelectedItem() == "Standart")
                        show_user_Panel(Standart);
                    if (comboBox1.getSelectedItem() == "Gold")
                        show_user_Panel(Gold);
                    if (comboBox1.getSelectedItem() == "Host")
                        show_user_Panel(Host);
                }
            }
        });

        comboBox2.addItemListener(new ItemListener() { //Shows the relevant property panel to the user when the option is selected from combobox
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (comboBox2.getSelectedItem() == "Shared")
                        show_property_Panel(Shared);
                    if (comboBox2.getSelectedItem() == "Full")
                        show_property_Panel(Full);

                }
            }
        });
        hostButton.addActionListener(new ActionListener() { //When host is pressed this action listener is called
            @Override
            public void actionPerformed(ActionEvent e) {
                adduser_information(1);
            }
        });


        standartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adduser_information(2);
            }
        });


        goldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adduser_information(3);
            }
        });
        deleteUserSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userId = Integer.parseInt(deleteUserId.getText());
                    deleteuser_information(userId);
                } catch (NumberFormatException ex) {
                    // The text is not a valid integer.
                    JOptionPane.showMessageDialog(null, "Please write a number!!!");
                }

            }
        });
        userDetailsSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int userId = Integer.parseInt(userDetails_Id.getText());
                    boolean check = false;
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getUserId() == userId) {
                            check = true;
                           showUserDetail(users.get(i));

                        }
                    }
                    if (!check) {
                        JOptionPane.showMessageDialog(null, "UserId doesn't exist");

                    }
                } catch (NumberFormatException ex) {
                    // The text is not a valid integer.
                    JOptionPane.showMessageDialog(null, "Please write a number!!!");
                }

            }
        });
        listallusersbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonTableModel model = new PersonTableModel(users);
                listalluserstable.setModel(model);
                showUserDetailsPanel(Table_userdetails);



            }
        });

        fullButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addproperty_information(1);
            }
        });

        sharedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addproperty_information(2);
            }
        });

        deleteButtonProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int propertyId = Integer.parseInt(deletePropertyId.getText());
                    deleteproperty_information(propertyId);
                } catch (NumberFormatException ex) {
                    // The text is not a valid integer.
                    JOptionPane.showMessageDialog(null, "Please write a number!!!");
                }
            }
        });


        propertydetailbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int propertyId = Integer.parseInt(propertyIdpropertydetails.getText());
                    boolean check = false;
                    for (int i = 0; i < properties.size(); i++) {
                        if (properties.get(i).getPropertyId() == propertyId) {

                            check = true;
                            showPropertyDetail(properties.get(i));

                        }
                    }
                    if (!check) {
                        JOptionPane.showMessageDialog(null, "PropertyId doesn't exist");
                    }
                } catch (NumberFormatException ex) {
                    // The text is not a valid integer.
                    JOptionPane.showMessageDialog(null, "Please write a number!!!");
                }
            }
        });
        listallpropertiesbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PropertyTableModel model = new PropertyTableModel(properties);
                listallpropertytable.setModel(model);
                showPropertyDetailsPanel(Table_propertydetails);
            }
        });
        addBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBooking();
            }
        });
        getUserBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user=null;

                boolean check=false;
               try {
                   for (int i = 0; i < users.size(); i++) {
                       if (users.get(i).getUserId() == Integer.parseInt(getUserBookinguserId.getText())) {
                           check = true;
                           user = users.get(i);

                       }


                   }
                   if (!check) {
                       JOptionPane.showMessageDialog(null, "UserId doesn't exist!");
                   }
                   if (check) {
                       if(user.getBookings()==null)
                           JOptionPane.showMessageDialog(null, "User doesn't have any booking!");
                       else{
                       BookingTableModel model = new BookingTableModel(user);
                       getUserBookingTable.setModel(model);
                       showBookingDetailsPanel(getUserBookingTableSubPanel);
                   }
                   }
               }
               catch (NumberFormatException ex)
               {
                   JOptionPane.showMessageDialog(null, "Please write a number!!!");
               }
            }
        });
        getBookingCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                get_booking_cost();
            }
        });
        getDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   int userId=Integer.parseInt(getDiscountUserId.getText());
                    JOptionPane.showMessageDialog(null, "Discount amount for the user is "+getDiscountForUser(userId));

                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please write a number!!!");
                }


            }
        });
        addInspectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    add_inspection();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        compareFirstPricesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparePropertyPricesPerDay();
            }
        });
    }

    public static void main(String[] args) {



        MainLayout frame=new MainLayout();
        frame.setVisible(true);


    }

    private JMenuBar createMenuBar() {

        JMenu user_menu=new JMenu("User Operations");
        JMenu property_menu=new JMenu("Property Operations");
        JMenu booking_menu=new JMenu("Booking Operations");
        JMenu other_menu=new JMenu("Other Operations");

        JMenuItem user_item1=new JMenuItem("Add User");
        JMenuItem user_item2=new JMenuItem("Delete User");
        JMenuItem user_item3=new JMenuItem("Get User Details");
        JMenuItem user_item4=new JMenuItem("List Users");
        JMenuItem property_item1=new JMenuItem("Add Property");
        JMenuItem property_item2=new JMenuItem("Delete Property");
        JMenuItem property_item3=new JMenuItem("Get Property Details");
        JMenuItem property_item4=new JMenuItem("List Properties");
        JMenuItem booking_item1=new JMenuItem("Add Booking");
        JMenuItem booking_item2=new JMenuItem("Get Users Booking");
        JMenuItem booking_item3=new JMenuItem("Get Booking Cost");
        JMenuItem other_item1=new JMenuItem("Get Discount Amount");
        JMenuItem other_item2=new JMenuItem("Add Inspection");
        JMenuItem other_item3=new JMenuItem("Compare Property Prices");

        user_menu.add(user_item1);
        user_menu.add(user_item2);
        user_menu.add(user_item3);
        user_menu.add(user_item4);
        property_menu.add(property_item1);
        property_menu.add(property_item2);
        property_menu.add(property_item3);
        property_menu.add(property_item4);
        booking_menu.add(booking_item1);
        booking_menu.add(booking_item2);
        booking_menu.add(booking_item3);
        other_menu.add(other_item1);
        other_menu.add(other_item2);
        other_menu.add(other_item3);


        JMenuBar bar=new JMenuBar();
        bar.add(user_menu);
        bar.add(property_menu);
        bar.add(booking_menu);
        bar.add(other_menu);

       user_item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(addUser);
            }
        });

        user_item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(deleteUser);
            }
        });

        user_item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(getUserDetails);
            }
        });

        user_item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(listUsers);
            }
        });

        property_item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(addProperty);
            }
        });

        property_item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(deleteProperty);
            }
        });

        property_item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(getPropertyDetails);
            }
        });

        property_item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(listProperties);
            }
        });

        other_item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(getDiscountAmount);
            }
        });

        other_item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(addInspection);
            }
        });

        other_item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(comparePrices);
            }
        });

        booking_item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(addBooking);
            }
        });

        booking_item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(getUserBooking);
            }
        });

        booking_item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the corresponding panel when menu item is clicked
                show_main_Panel(getBookingCost);
            }
        });

        return bar;
    }




    private void show_main_Panel(JPanel panel) //For changing the main panels
    {
        main_panel.removeAll();
        main_panel.add(panel);
        main_panel.repaint();
        main_panel.revalidate();


    }

    private void show_user_Panel(JPanel panel)//For changing the sub-panel which shows host-gold-stanart options
    {
        Second_user.removeAll();
        Second_user.add(panel);
        Second_user.repaint();
        Second_user.revalidate();


    }

    private void show_property_Panel(JPanel panel)//For changing the sub-panel which shows full-half property options
    {
        Second_property.removeAll();
        Second_property.add(panel);
        Second_property.repaint();
        Second_property.revalidate();


    }

    public void showUserDetailsPanel(JPanel panel)
    {
        listUsersPanel.removeAll();
        listUsersPanel.add(panel);
        listUsersPanel.repaint();
        listUsersPanel.revalidate();

    }

    public void showPropertyDetailsPanel(JPanel panel)
    {
        TablePanelProperty.removeAll();
        TablePanelProperty.add(panel);
        TablePanelProperty.repaint();
        TablePanelProperty.revalidate();

    }
    public void showBookingDetailsPanel(JPanel panel)
    {
        getUserBookingTablePanel.removeAll();
        getUserBookingTablePanel.add(panel);
        getUserBookingTablePanel.repaint();
        getUserBookingTablePanel.revalidate();

    }

    private void combobox_for_addUser(JComboBox comboBox)
    {

        comboBox.addItem("");
        comboBox.addItem("Host");
        comboBox.addItem("Standart");
        comboBox.addItem("Gold");


    }

    private void combobox_for_addProperty(JComboBox comboBox)
    {

        comboBox.addItem("");
        comboBox.addItem("Shared");
        comboBox.addItem("Full");


    }

    private void saveUsers() { //For saving the users
        String filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\host.dat";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (User user : users) {
                if(user instanceof Host)
                {user_basic_information_save(outputStream,user);
                outputStream.writeDouble(((Host) user).getTaxNumber());}
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\standart.dat";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (User user : users) {
                if(user instanceof Standart) {
                    user_basic_information_save(outputStream, user);
                    outputStream.writeLong(user.getRegistrationDate().getTime());
                    outputStream.writeUTF(((Standart) user).getPrefferedPaymentMethod());
                }}}
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\gold.dat";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (User user : users) {
                if(user instanceof Gold) {
                    user_basic_information_save(outputStream, user);
                    outputStream.writeLong(user.getRegistrationDate().getTime());
                    outputStream.writeUTF(((Gold) user).getPrefferedPaymentMethod());
                    outputStream.writeInt(((Gold) user).getGoldLevel());
                }}}
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public void user_basic_information_save(DataOutputStream outputStream,User user) throws IOException { //For modularity, I used it inside saveUsers
        outputStream.writeInt(user.getUserId());
        outputStream.writeLong(user.getDateOfBirth().getTime());
        outputStream.writeUTF(user.getFirstName());
        outputStream.writeUTF(user.getLastName());

    }

    private void loadUsers() { //For loading the user information form the files
        String filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\host.dat";
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    loading_files_user(inputStream,1);
                } catch (EOFException eofException) {
                    break;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            //Just catches the error, it doesn't have to do anything
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\standart.dat";
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    loading_files_user(inputStream,2);
                } catch (EOFException eofException) {
                    break;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            //Just catches the error, it doesn't have to do anything
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\gold.dat";
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    loading_files_user(inputStream,3);
                } catch (EOFException eofException) {
                    break;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            //Just catches the error, it doesn't have to do anything
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loading_files_user(DataInputStream inputStream,int choice) throws IOException { //For modularity, I used it inside saveUsers

        int userId = inputStream.readInt();
        Date birthDate = new Date(inputStream.readLong());
        String name = inputStream.readUTF();
        String surname = inputStream.readUTF();

        if(choice==1)
        {double taxNo = inputStream.readDouble();
        User user = new Host(userId, birthDate, name, surname, taxNo);
        users.add(user);}

        else if(choice==2)
        {
            Date registrationDate=new Date(inputStream.readLong());
            String preffered_method=inputStream.readUTF();
            User user = new Standart(userId, birthDate, name, surname, registrationDate,preffered_method);
            users.add(user);
        }

        else if(choice==3)
        {
            Date registrationDate=new Date(inputStream.readLong());
            String preffered_method=inputStream.readUTF();
            int gold_level = inputStream.readInt();
            User user = new Gold(userId, birthDate, name, surname, registrationDate,preffered_method,gold_level);
            users.add(user);
        }



    }


    public void adduser_information(int choice)
    {
        Integer id;
        boolean check=false;
        Date date=null;
        Date currentdate=new Date();
        if (users.size() == 0) {// If user list is empty
            id = 1;
        } else {
            int max_id=0;
            for (int i = 0; i <users.size() ; i++) {
                if(users.get(i).getUserId()>max_id)
                    max_id=users.get(i).getUserId();
            }

            id = max_id+1;}
        System.out.println("Host is pressed");

        SimpleDateFormat simple_date = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date =simple_date.parse(birth_text.getText());
            check=true;
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,"Please use the correct date format!!(dd/mm/yyyy)");

        }

        if(check && choice==1)
        {host=new Host(id, date,name_text.getText(),surname_text.getText(),Double.parseDouble(tax_no.getText()));
            users.add(host);
            JOptionPane.showMessageDialog(null,"Host added to the system");
        }
        else if(check && choice==2)
        {standart=new Standart(id, date,name_text.getText(),surname_text.getText(),currentdate,standartPayment.getText());
            users.add(standart);
            JOptionPane.showMessageDialog(null,"Standart added to the system");
        }
        else if(check && choice==3)
        {   if(a1RadioButton.isSelected())
            gold=new Gold(id, date,name_text.getText(),surname_text.getText(),currentdate,goldPayment.getText(),1);
            else if(a2RadioButton.isSelected())
                gold=new Gold(id, date,name_text.getText(),surname_text.getText(),currentdate,goldPayment.getText(),2);
            else
                gold=new Gold(id, date,name_text.getText(),surname_text.getText(),currentdate,goldPayment.getText(),3);
            users.add(gold);
            JOptionPane.showMessageDialog(null,"Gold added to the system");
        }




    }
    public void deleteuser_information(int userId){

        {

            boolean check = false;

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserId() == userId) {
                    users.remove(i);
                    check = true;
                    JOptionPane.showMessageDialog(null,"User with the id " + userId + " is deleted from the system");
                }
            }
            if (!check) {
                JOptionPane.showMessageDialog(null,"User id does not exist!");
            }

        }

    }

    public void showUserDetail(User user)
    {

        JOptionPane.showMessageDialog(null, user);


    }


    class PersonTableModel extends AbstractTableModel {
        private List<User> users;
        private String[] columnNames = {"User ID", "First Name", "Last Name", "Date of Birth","Registration Date","Tax Number","Preferred Payment Method","Gold Level","User Type"};

        public PersonTableModel(List<User> users) {
            this.users = users;
        }

        @Override
        public int getRowCount() {
            return users.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            User user = users.get(row);
            if (user instanceof Host) {
                switch (col) {
                    case 0:
                        return user.getUserId();
                    case 1:
                        return user.getFirstName();
                    case 2:
                        return user.getLastName();
                    case 3:
                        return user.getDateOfBirth();
                    case 4:
                        return user.getRegistrationDate();
                    case 5:
                        return ((Host) user).getTaxNumber();
                    case 8: return "Host";
                    default:
                        return null;
                }
            }
            else if (user instanceof Standart) {
                switch (col) {
                    case 0:
                        return user.getUserId();
                    case 1:
                        return user.getFirstName();
                    case 2:
                        return user.getLastName();
                    case 3:
                        return user.getDateOfBirth();
                    case 4:
                        return user.getRegistrationDate();
                    case 6:
                        return ((Standart) user).getPrefferedPaymentMethod();
                    case 8: return "Standart";
                    default:
                        return null;
                }
            }
            if (user instanceof Gold) {
                switch (col) {
                    case 0:
                        return user.getUserId();
                    case 1:
                        return user.getFirstName();
                    case 2:
                        return user.getLastName();
                    case 3:
                        return user.getDateOfBirth();
                    case 4:
                        return user.getRegistrationDate();
                    case 6:
                        return ((Gold) user).getPrefferedPaymentMethod();
                    case 7:
                        return ((Gold) user).getGoldLevel();
                    case 8: return "Gold";
                    default:
                        return null;
                }
            }
            return null;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
    }
    private void saveProperties() { //For saving the users
        String filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\fullProperty.dat";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Property property : properties) {
                if(property instanceof FullProperty)
                {property_basic_information_save(outputStream,property);
                    outputStream.writeDouble(((FullProperty) property).getPropertySize());}
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\sharedProperty.dat";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Property property : properties) {
                if(property instanceof SharedProperty)
                {property_basic_information_save(outputStream,property);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void property_basic_information_save(DataOutputStream outputStream,Property property) throws IOException { //For modularity, I used it inside saveProperties
        outputStream.writeInt(property.getPropertyId());
        outputStream.writeInt(property.getNoBedRooms());
        outputStream.writeInt(property.getNoRooms());
        outputStream.writeUTF(property.getCity());
        outputStream.writeDouble(property.getPricePerDay());

    }

    private void loadProperties() { //For loading the user information form the files
        String filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\fullProperty.dat";
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    loading_files_properties(inputStream,1);
                } catch (EOFException eofException) {
                    break;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            //Just catches the error, it doesn't have to do anything
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = "C:\\Users\\Turgut\\Desktop\\New folder\\sharedProperty.dat";
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    loading_files_properties(inputStream,2);
                } catch (EOFException eofException) {
                    break;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            //Just catches the error, it doesn't have to do anything
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void loading_files_properties(DataInputStream inputStream,int choice) throws IOException { //For modularity, I used it inside saveUsers

        int propertyId = inputStream.readInt();
        int no_of_bedrooms=inputStream.readInt();
        int no_of_rooms=inputStream.readInt();
        String city = inputStream.readUTF();
        double priceperday=inputStream.readDouble();


        if(choice==1)
        {   double propertySize=inputStream.readDouble();
            Property property = new FullProperty(propertyId, no_of_bedrooms, no_of_rooms, city, priceperday,propertySize);
            properties.add(property);}

        else if(choice==2)
        {

            Property property = new SharedProperty(propertyId, no_of_bedrooms, no_of_rooms, city, priceperday);
            properties.add(property);
        }


    }
    public void addproperty_information(int choice)
    {
        int id;
        boolean check = true;;
        Property property =null;
        User user = null;
        if (properties.size() == 0) {
            id = 1;
        } else {
            int max_id=0;
            for (int i = 0; i <properties.size() ; i++) {
                if(properties.get(i).getPropertyId()>max_id)
                    max_id=properties.get(i).getPropertyId();
            }

            id = max_id+1;
        }//This way property id is always unique for properties


        if(check && choice==1)
        {property = new FullProperty(id,Integer.parseInt(no_of_bedrooms.getText()), Integer.parseInt(no_of_rooms.getText()), city.getText(), Double.parseDouble(room_price.getText()),Double.parseDouble(meter.getText()));
            properties.add(property);
            JOptionPane.showMessageDialog(null,"FullProperty added to the system");
        }
        else if(check && choice==2)
        {property = new SharedProperty(id,Integer.parseInt(no_of_bedrooms.getText()), Integer.parseInt(no_of_rooms.getText()), city.getText(), Double.parseDouble(room_price.getText()));

            properties.add(property);
            JOptionPane.showMessageDialog(null,"SharedProperty added to the system");
        }


    }

    public void deleteproperty_information(int propertyId) {

        {

            boolean check = false;

            for (int i = 0; i < properties.size(); i++) {
                if (properties.get(i).getPropertyId() == propertyId) {
                    properties.remove(i);
                    check = true;
                    JOptionPane.showMessageDialog(null, "Property with the id " + propertyId + " is deleted from the system");
                }
            }
            if (!check) {

                JOptionPane.showMessageDialog(null, "Property id does not exist!");

            }

        }
    }

    public void showPropertyDetail(Property property)
    {

        JOptionPane.showMessageDialog(null, property);


    }

    class PropertyTableModel extends AbstractTableModel {
        private List<Property> properties;
        private String[] columnNames = {"Property Id", "Number of Bedrooms", "Number of Rooms", "City","Price Per Day","Property Size","Property Type"};

        public PropertyTableModel(List<Property> properties) {
            this.properties = properties;
        }

        @Override
        public int getRowCount() {
            return properties.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Property property = properties.get(row);
            if (property instanceof FullProperty) {
                switch (col) {
                    case 0:
                        return property.getPropertyId();
                    case 1:
                        return property.getNoBedRooms();
                    case 2:
                        return property.getNoRooms();
                    case 3:
                        return property.getCity();
                    case 4:
                        return property.getPricePerDay();
                    case 5:
                        return ((FullProperty) property).getPropertySize();
                    case 6:
                        return "Full Property";
                    default:
                        return null;
                }
            }
            else if (property instanceof SharedProperty) {
                switch (col) {
                    case 0:
                        return property.getPropertyId();
                    case 1:
                        return property.getNoBedRooms();
                    case 2:
                        return property.getNoRooms();
                    case 3:
                        return property.getCity();
                    case 4:
                        return property.getPricePerDay();
                    case 6:
                        return "Shared Property";
                    default:
                        return null;
                }

            }
            return null;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
    }

    public void addBooking()
    {
        boolean check_userid = false, check_propertyid = false, check_host = false;
        Date start_date = null, end_date = null;
        User user = null;
        boolean check=false;
        Property property = null;
        int userId=0;
        int propertyId=0;

        try {
            userId = Integer.parseInt(addBookinguserId.getText());
            propertyId = Integer.parseInt(addBookingPropertyId.getText());
        } catch (NumberFormatException e) {
            check = true;
            JOptionPane.showMessageDialog(null, "Please enter a number for Id's!");
        }


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
            JOptionPane.showMessageDialog(null,"User id does not exist!");
            return;
        }
        if (!check_propertyid) {
            JOptionPane.showMessageDialog(null,"Property id does not exist!");
            return;
        }
        if (check_host) {
            JOptionPane.showMessageDialog(null,"User id belong to host not customer!");//So that it doesn't allow for booking
            return;
        }
        SimpleDateFormat simple_date = new SimpleDateFormat("dd/MM/yyyy");
        try {
            start_date =simple_date.parse(addBookingStartDate.getText());
            end_date =simple_date.parse(addBookingEndDate.getText());


        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,"Please use the correct date format!!(dd/mm/yyyy) for dates!");
            check=true;
        }
        if(!check) { //If there is an error don't book anything
            Booking booking = new Booking(start_date, end_date, property);
            user.setBookings(booking);
            JOptionPane.showMessageDialog(null,"Booking is added!");
        }

    }

    class BookingTableModel extends AbstractTableModel {
        private List<Booking> bookings;
        private String[] columnNames = {"City", "Start Date", "End Date"};

        public BookingTableModel(User user) {
            this.bookings = user.getBookings();
        }

        @Override
        public int getRowCount() {
            return bookings.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Booking booking = bookings.get(row);
                switch (col) {
                    case 0:
                        return booking.getProperty().getCity();
                    case 1:
                        return booking.getStartDate();
                    case 2:
                        return booking.getEndDate();
                    default:
                        return null;
            }

        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }
    }

    public void get_booking_cost(){

        boolean check1 = false, check2 = false;
        boolean check=false,check_property=false;
        User user = null;
        Property property=null;
        int userId=0,propertyId=0;
        try{
            userId=Integer.parseInt(getBookingCostUserId.getText());
            propertyId=Integer.parseInt(getBookingCostPropertyId.getText());
        }
        catch (NumberFormatException e) {
            check=true;
            JOptionPane.showMessageDialog(null, "Please write a number!!!");
        }
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
            JOptionPane.showMessageDialog(null, "User id does not exist!");
            check=true;
        }
        if (!check2) {
            JOptionPane.showMessageDialog(null, "Property id does not exist!");
            check=true;
        }
        if(!check) {



            if(user.getBookings().isEmpty()) {
                if (user instanceof Host)
                JOptionPane.showMessageDialog(null, "User has no booking since it's a host");
                else
                    JOptionPane.showMessageDialog(null, "User has no booking done yet");
            }

            else {
                for (int i = 0; i < user.getBookings().size(); i++) { //Loops all the bookings the user has
                    if (user.getBookings().get(i).getProperty() == property) {
                        check_property=true;
                        JOptionPane.showMessageDialog(null, "Cost for the property is " + (user.getBookings().get(i).totalCost() - (user.getBookings().get(i).totalCost() * (getDiscountForUser(user.getUserId()) / 100))));
                    }
                }
                if(!check_property)
                    JOptionPane.showMessageDialog(null, "User doesn't have any reservation on this property");
            }

        }
    }

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
                    JOptionPane.showMessageDialog(null, "Host doesn't have discount!");
                return 0.0;
            }

        }
        JOptionPane.showMessageDialog(null, "Couldn't found the user!");

        return 0.0;
    }

    public void add_inspection() throws ParseException {
            int propertyId=0;
            String string;
            try{
                propertyId=Integer.parseInt(addInspectionPropertyId.getText());
                string=addInspectionsNote.getText();
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
                            JOptionPane.showMessageDialog(null, "You already added inspection for this property today");
                            return;
                        }
                        else
                        {   hashMap.put(current,string); //Puts the key and value pair to hashmap
                            property.setInspection(hashMap);//Inserts it to properties inspection
                            JOptionPane.showMessageDialog(null, "Inspection is added to the property");
                        }
                    }

                }
                if (check==false)
                    JOptionPane.showMessageDialog(null, "Couldn't find the property!");
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Please write a number!!!");
            }

        }

    public void comparePropertyPricesPerDay()
    {

        int propertyId_one=0;
        int propertyId_two=0;
        try{
            propertyId_one=Integer.parseInt(compareFirstPricesPropertyId.getText());
            propertyId_two=Integer.parseInt(compareSecondPricesPropertyId.getText());
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
            if (!check_one) {
                JOptionPane.showMessageDialog(null, "Property one doesn't exist");
            }
            else if (!check_two) {
                JOptionPane.showMessageDialog(null, "Property two doesn't exist");
            }
            else if (property_one.compareTo(property_two) > 0) {
                JOptionPane.showMessageDialog(null, "Property ID " + property_two.getPropertyId() + " is cheaper");
            }
            else if (property_one.compareTo(property_two) < 0) {
                JOptionPane.showMessageDialog(null, "Property ID " + property_one.getPropertyId() + " is cheaper");
            }
            else {
                JOptionPane.showMessageDialog(null, "They have the same price!");
            }

        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please write a number!!!");
        }



    }

}
