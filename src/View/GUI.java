package View;

import javax.swing.*; //Necessary for GUI
import java.awt.*; //Necessary for GUI
import java.awt.event.*; //Necessary for ActionListener
import java.util.ArrayList;


/**
 * The class that builds the GUI of the application.
 * @author Paul Calean
 * @version 1.0
 */
public class GUI {

    private boolean connected;

    //GUI variables
    private JFrame frame1;
    private Container pane;
    private JTable table;
    private JScrollPane scrollPane;
    private Insets insets;
    private JMenuBar adminMenuBar, userMenuBar;
    private JMenu menuBooksForUser, menuBooks, menuUsers, menuGenerateReport;
    private JMenuItem menuItemAddBook, menuItemAddUser,
            menuItemViewBookByISBN, menuItemViewBooksByGenre, menuItemViewBooksByTitle, menuItemViewBooksByAuthor, menuItemViewAllBooks,
            menuItemViewBookByISBNForUser, menuItemViewBooksByGenreForUser, menuItemViewBooksByTitleForUser, menuItemViewBooksByAuthorForUser,
            menuItemViewAllBooksForUser, menuItemGenerateReport,
            menuItemSellBook, menuItemViewAllUsers, menuItemViewUserByID,
            menuItemUpdateBook, menuItemUpdateUser,
            menuItemDeleteBook, menuItemDeleteUser;


    private JLabel lblUsername, lblPassword, lblID, lblName, lblOldID, lblUserUsername, lblUserPassword,
            lblISBN, lblOldISBN, lblTitle, lblAuthor, lblGenre, lblQuantity, lblPrice;
    private JTextField txtUsername, txtID, txtName, txtOldID,
            txtUserUsername, txtISBN, txtOldISBN, txtTitle, txtAuthor, txtGenre, txtQuantity, txtPrice;
    private JPasswordField txtPassword, txtUserPassword;
    private JButton btnConnect, btnAddBook, btnAddUser,
            btnUpdateBook, btnUpdateUser,
            btnGenerate, btnSave;

    private static final int HS = 10, VS = 10; //HS=HorizontalSpacing VS=VerticalSpacing

    /**
     * Initialise the GUI. Creates and adds the different components of the GUI.
     * Shows the application's window and sets its position to the centre of the screen.
     */
    public GUI() {

        connected = false;

        // Set Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (UnsupportedLookAndFeelException e) {
        }

        // Create the frame
        frame1 = new JFrame("Book Store");
        frame1.setSize(450, 80);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = frame1.getContentPane();
        insets = pane.getInsets();
        pane.setLayout(null);
        //Create the components
        //Create the menuBars
        adminMenuBar = new JMenuBar();
        userMenuBar = new JMenuBar();
        //Create menus
        menuBooksForUser = new JMenu("Books");
        menuBooks = new JMenu("Books");
        menuUsers = new JMenu("Users");
        menuGenerateReport = new JMenu("Generate Report");
        //Create menu items

        menuItemViewBookByISBNForUser = new JMenuItem("View Book By ISBN");
        menuItemViewBooksByAuthorForUser = new JMenuItem("View Book By Author");
        menuItemViewBooksByGenreForUser = new JMenuItem("View Book By Genre");
        menuItemViewBooksByTitleForUser = new JMenuItem("View Book By Title");
        menuItemViewAllBooksForUser = new JMenuItem("View All Books");
        menuItemSellBook=new JMenuItem("Sell book");

        menuItemAddBook = new JMenuItem("Add Book");
        menuItemAddUser = new JMenuItem("Add user");
        menuItemViewBookByISBN = new JMenuItem("View Book By ISBN");
        menuItemViewBooksByAuthor = new JMenuItem("View Book By Author");
        menuItemViewBooksByGenre = new JMenuItem("View Book By Genre");
        menuItemViewBooksByTitle = new JMenuItem("View Book By Title");
        menuItemViewAllBooks = new JMenuItem("View All Books");

        menuItemViewUserByID = new JMenuItem("View User By ID");
        menuItemViewAllUsers = new JMenuItem("View All Users");
        menuItemUpdateBook = new JMenuItem("Update Book By ISBN");
        menuItemUpdateUser = new JMenuItem("Update user By ID");
        menuItemDeleteBook = new JMenuItem("Delete Book By ISBN");
        menuItemDeleteUser = new JMenuItem("Delete user ID");

        menuItemGenerateReport= new JMenuItem("Generate report");

        //Create the labels
        lblUsername = new JLabel("Username:");
        lblPassword = new JLabel("Password:");
        lblID = new JLabel("ID:");
        lblName = new JLabel("Name:");
        lblOldID = new JLabel("Old ID:");
        lblOldISBN = new JLabel("Old ISBN:");
        lblISBN = new JLabel("ISBN:");
        lblUserUsername = new JLabel("User Username:");
        lblUserPassword = new JLabel("User Password:");
        lblTitle = new JLabel("Title:");
        lblAuthor = new JLabel("Author:");
        lblGenre = new JLabel("Genre:");
        lblQuantity= new JLabel("Quantity:");
        lblPrice = new JLabel("Price:");


        ///Create text fields
        txtUsername = new JTextField(10);
        txtID = new JTextField(5);
        txtName = new JTextField(10);
        txtOldID = new JTextField(13);
        txtOldISBN = new JTextField(13);
        txtISBN = new JTextField(13);
        txtUserUsername = new JTextField(10);
        txtTitle = new JTextField(10);
        txtAuthor = new JTextField(10);
        txtGenre = new JTextField(10);
        txtQuantity = new JTextField(5);
        txtPrice = new JTextField(5);

        //Create Password field
        txtPassword = new JPasswordField(10);
        txtUserPassword = new JPasswordField(10);
        //Create buttons
        btnConnect = new JButton("Connect");
        btnAddBook = new JButton("Add Book");
        btnAddUser = new JButton("Add User");
        btnUpdateBook = new JButton("Update Book");
        btnUpdateUser = new JButton("Update User");
        btnGenerate = new JButton("Generate");
        btnSave =new JButton("Save to file");

        //Add menus to me menuBars
        userMenuBar.add(menuBooksForUser);
        adminMenuBar.add(menuBooks);
        adminMenuBar.add(menuUsers);
        adminMenuBar.add(menuGenerateReport);

        //Add menuItems to menus
        menuBooksForUser.add(menuItemViewBookByISBNForUser);
        menuBooksForUser.add(menuItemViewBooksByAuthorForUser);
        menuBooksForUser.add(menuItemViewBooksByGenreForUser);
        menuBooksForUser.add(menuItemViewBooksByTitleForUser);
        menuBooksForUser.add(menuItemViewAllBooksForUser);
        menuBooksForUser.add(menuItemSellBook);

        menuBooks.add(menuItemAddBook);
        menuBooks.add(menuItemViewBookByISBN);
        menuBooks.add(menuItemViewBooksByAuthor);
        menuBooks.add(menuItemViewBooksByGenre);
        menuBooks.add(menuItemViewBooksByTitle);
        menuBooks.add(menuItemViewAllBooks);
        menuBooks.add(menuItemUpdateBook);
        menuBooks.add(menuItemDeleteBook);

        menuUsers.add(menuItemAddUser);
        menuUsers.add(menuItemViewAllUsers);
        menuUsers.add(menuItemViewUserByID);
        menuUsers.add(menuItemUpdateUser);
        menuUsers.add(menuItemDeleteUser);

        menuGenerateReport.add(menuItemGenerateReport);

        // Add components to the panels
        pane.add(lblUsername);
        pane.add(lblPassword);
        pane.add(txtUsername);
        pane.add(txtPassword);
        pane.add(btnConnect);


        pane.add(lblOldISBN);
        pane.add(txtOldISBN);
        pane.add(lblISBN);
        pane.add(txtISBN);
        pane.add(lblTitle);
        pane.add(txtTitle);
        pane.add(lblAuthor);
        pane.add(txtAuthor);
        pane.add(lblGenre);
        pane.add(txtGenre);
        pane.add(lblQuantity);
        pane.add(txtQuantity);
        pane.add(lblPrice);
        pane.add(txtPrice);

        pane.add(lblOldID);
        pane.add(txtOldID);
        pane.add(lblID);
        pane.add(txtID);
        pane.add(lblName);
        pane.add(txtName);
        pane.add(lblUserUsername);
        pane.add(txtUserUsername);
        pane.add(lblUserPassword);
        pane.add(txtUserPassword);

        //buttons
        pane.add(btnAddBook);
        pane.add(btnUpdateBook);
        pane.add(btnAddUser);
        pane.add(btnUpdateUser);
        pane.add(btnGenerate);
        pane.add(btnSave);

        //set the position of the components
        //login components
        lblUsername.setBounds(insets.left + HS, insets.top + VS, lblUsername.getPreferredSize().width, lblUsername.getPreferredSize().height);
        txtUsername.setBounds(lblUsername.getX() + lblUsername.getWidth(), lblUsername.getY(), txtUsername.getPreferredSize().width, txtUsername.getPreferredSize().height);
        lblPassword.setBounds(txtUsername.getX() + txtUsername.getWidth() + HS, lblUsername.getY(), lblPassword.getPreferredSize().width, lblPassword.getPreferredSize().height);
        txtPassword.setBounds(lblPassword.getX() + lblPassword.getWidth(), lblUsername.getY(), txtPassword.getPreferredSize().width, txtPassword.getPreferredSize().height);
        btnConnect.setBounds(txtPassword.getX() + txtPassword.getWidth() + HS, lblPassword.getY(), btnConnect.getPreferredSize().width, btnConnect.getPreferredSize().height);

        lblOldID.setBounds(lblUsername.getX(), lblUsername.getY()+lblUsername.getHeight()+VS, lblOldID.getPreferredSize().width, lblOldID.getPreferredSize().height);
        txtOldID.setBounds(lblOldID.getX() + lblOldID.getWidth() + HS, lblOldID.getY(), txtOldID.getPreferredSize().width, txtOldID.getPreferredSize().height);

        lblOldISBN.setBounds(lblUsername.getX(), lblUsername.getY()+lblUsername.getHeight()+VS, lblOldISBN.getPreferredSize().width, lblOldISBN.getPreferredSize().height);
        txtOldISBN.setBounds(lblOldISBN.getX() + lblOldISBN.getWidth() + HS, lblOldISBN.getY(), txtOldISBN.getPreferredSize().width, txtOldISBN.getPreferredSize().height);

        btnSave.setBounds(insets.left+HS, lblOldISBN.getY()+ lblOldISBN.getHeight()+VS, btnSave.getPreferredSize().width, btnSave.getPreferredSize().height);

        //Sets the frame visible, and its position to the centre of the screen
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
        setAllOptionsInvisibleAndTable();

        menuItemAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setAddBookOptions(true);
            }
        });

        menuItemUpdateBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setUpdateBookOptions(true);
            }
        });

        menuItemAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setAddUserOptions(true);
            }
        });

        menuItemUpdateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllOptionsInvisible();
                setUpdateUserOptions(true);
            }
        });
    }

    public void addConnectActionListener(ActionListener actionListener)
    {
        btnConnect.addActionListener(actionListener);
    }

    public void addViewBooksByISBNActionListener(ActionListener actionListener) {
        menuItemViewBookByISBNForUser.addActionListener(actionListener);
        menuItemViewBookByISBN.addActionListener(actionListener);
    }

    public void addViewBooksByGenreActionListener(ActionListener actionListener) {
        menuItemViewBooksByGenreForUser.addActionListener(actionListener);
        menuItemViewBooksByGenre.addActionListener(actionListener);
    }

    public void addViewBooksByTitleActionListener(ActionListener actionListener) {
        menuItemViewBooksByTitleForUser.addActionListener(actionListener);
        menuItemViewBooksByTitle.addActionListener(actionListener);
    }

    public void addViewBooksByAuthorActionListener(ActionListener actionListener) {
        menuItemViewBooksByAuthorForUser.addActionListener(actionListener);
        menuItemViewBooksByAuthor.addActionListener(actionListener);
    }

    public void addViewAllBooksActionListener(ActionListener actionListener)
    {
        menuItemViewAllBooksForUser.addActionListener(actionListener);
        menuItemViewAllBooks.addActionListener(actionListener);
    }

    public void addSellBookActionListener(ActionListener actionListener) {
        menuItemSellBook.addActionListener(actionListener);
    }

    public void addAddBookActionListener(ActionListener actionListener) {
        btnAddBook.addActionListener(actionListener);
    }

    public void addSaveActionListener(ActionListener actionListener)
    {
        btnSave.addActionListener(actionListener);
    }

    public void addUpdateBookActionListener(ActionListener actionListener) {
        btnUpdateBook.addActionListener(actionListener);
    }

    public void addDeleteBookActionListener(ActionListener actionListener) {
        menuItemDeleteBook.addActionListener(actionListener);
    }

    public void addAddUserActionListener(ActionListener actionListener)
    {
        btnAddUser.addActionListener(actionListener);
    }

    public void addViewAllUsersActionListener(ActionListener actionListener)
    {
        menuItemViewAllUsers.addActionListener(actionListener);
    }

    public void addViewUserByIDActionListener(ActionListener actionListener)
    {
        menuItemViewUserByID.addActionListener(actionListener);
    }
    
    public void addUpdateUserActionListener(ActionListener actionListener)
    {
        btnUpdateUser.addActionListener(actionListener);
    }

    public void addDeleteUserActionListener(ActionListener actionListener)
    {
        menuItemDeleteUser.addActionListener(actionListener);
    }


    public void addGenerateReportActionListener(ActionListener actionListener)
    {
        menuItemGenerateReport.addActionListener(actionListener);
    }

    public void addTable(String[] columnsNames,Object[][] data)
    {
        if (scrollPane!=null) pane.remove(scrollPane);
        table = new JTable(data,columnsNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        scrollPane=new JScrollPane(table);
        // scrollPane.setVisible(true);
        scrollPane.setBounds(pane.getInsets().left+HS,lblUsername.getY()+lblUsername.getHeight()+6*VS,scrollPane.getPreferredSize().width+300,scrollPane.getPreferredSize().width);
        pane.add(scrollPane);
        pane.revalidate();
        frame1.setSize(1100, scrollPane.getHeight() + 200);
        frame1.setLocationRelativeTo(null);
    }

    public void setAdminOptions()
    {
        setMenuBar("Admin");
        btnSave.setVisible(true);
    }

    public void setUserOptions()
    {
        setMenuBar("User");
    }

    private void setMenuBar(String menuBar)
    {
        if (menuBar.contains("Admin"))
            frame1.setJMenuBar(adminMenuBar);
        else frame1.setJMenuBar(userMenuBar);
    }

    /**
     * sets the view so only login options are available or all others according to b
     * @param b true to set enabled, false to set disabled
     */
    public void setLoginEnabled(boolean b) {
        lblUsername.setEnabled(b);
        txtUsername.setEnabled(b);
        lblPassword.setEnabled(b);
        txtPassword.setEnabled(b);
        if (b)
        {
            txtUsername.setText("");
            txtPassword.setText("");
            frame1.setJMenuBar(null);
            frame1.setSize(450, 80);
            frame1.setLocationRelativeTo(null);
            btnConnect.setText("Connect");

        }
        else{
            frame1.setSize(1100, 200);
            frame1.setLocationRelativeTo(null);
            btnConnect.setText("Disconnect");
            btnConnect.setBounds(txtPassword.getX()+txtPassword.getWidth()+HS,lblPassword.getY(),btnConnect.getPreferredSize().width,btnConnect.getPreferredSize().height);
        }

    }


    public void setAllOptionsInvisibleAndTable() {
        setAllOptionsInvisible();
        if (scrollPane!=null) scrollPane.setVisible(false);
        btnSave.setVisible(false);
    }

    private void setAllOptionsInvisible()
    {
        lblOldISBN.setVisible(false);
        txtOldISBN.setVisible(false);
        lblISBN.setVisible(false);
        txtISBN.setVisible(false);
        lblTitle.setVisible(false);
        txtTitle.setVisible(false);
        lblAuthor.setVisible(false);
        txtAuthor.setVisible(false);
        lblGenre.setVisible(false);
        txtGenre.setVisible(false);
        lblQuantity.setVisible(false);
        txtQuantity.setVisible(false);
        lblPrice.setVisible(false);
        txtPrice.setVisible(false);
        btnAddBook.setVisible(false);
        btnUpdateBook.setVisible(false);

        lblOldID.setVisible(false);
        txtOldID.setVisible(false);
        lblID.setVisible(false);
        txtID.setVisible(false);
        lblName.setVisible(false);
        txtName.setVisible(false);
        lblUserUsername.setVisible(false);
        txtUserUsername.setVisible(false);
        lblUserPassword.setVisible(false);
        txtUserPassword.setVisible(false);
        btnAddUser.setVisible(false);
        btnUpdateUser.setVisible(false);
        btnGenerate.setVisible(false);
    }

    private void setBookComponentsPositions() {

        txtISBN.setBounds(lblISBN.getX()+lblISBN.getWidth()+HS,lblOldISBN.getY(),txtISBN.getPreferredSize().width,txtISBN.getPreferredSize().height);
        lblTitle.setBounds(txtISBN.getX()+txtISBN.getWidth()+HS,lblISBN.getY(), lblTitle.getPreferredSize().width, lblTitle.getPreferredSize().height);
        txtTitle.setBounds(lblTitle.getX()+lblTitle.getWidth()+HS,lblISBN.getY(), txtTitle.getPreferredSize().width, txtTitle.getPreferredSize().height);
        lblAuthor.setBounds(txtTitle.getX()+txtTitle.getWidth()+HS,lblISBN.getY(), lblAuthor.getPreferredSize().width, lblAuthor.getPreferredSize().height);
        txtAuthor.setBounds(lblAuthor.getX()+lblAuthor.getWidth()+HS,lblISBN.getY(), txtAuthor.getPreferredSize().width, txtAuthor.getPreferredSize().height);
        lblGenre.setBounds(txtAuthor.getX()+txtAuthor.getWidth()+HS,lblISBN.getY(), lblGenre.getPreferredSize().width, lblGenre.getPreferredSize().height);
        txtGenre.setBounds(lblGenre.getX()+lblGenre.getWidth()+HS,lblISBN.getY(), txtGenre.getPreferredSize().width, txtGenre.getPreferredSize().height);
        lblQuantity.setBounds(txtGenre.getX()+txtGenre.getWidth()+HS,lblISBN.getY(), lblQuantity.getPreferredSize().width, lblQuantity.getPreferredSize().height);
        txtQuantity.setBounds(lblQuantity.getX()+lblQuantity.getWidth()+HS,lblISBN.getY(), txtQuantity.getPreferredSize().width, txtQuantity.getPreferredSize().height);
        lblPrice.setBounds(txtQuantity.getX()+txtQuantity.getWidth()+HS,lblISBN.getY(), lblPrice.getPreferredSize().width, lblPrice.getPreferredSize().height);
        txtPrice.setBounds(lblPrice.getX()+lblPrice.getWidth()+HS,lblISBN.getY(), txtPrice.getPreferredSize().width, txtPrice.getPreferredSize().height);
        btnAddBook.setBounds(txtPrice.getX() +  txtPrice.getWidth() + HS, lblOldISBN.getY(), btnAddBook.getPreferredSize().width, btnAddBook.getPreferredSize().height);
        btnUpdateBook.setBounds(txtPrice.getX() +  txtPrice.getWidth() + HS, lblOldISBN.getY(), btnUpdateBook.getPreferredSize().width, btnUpdateBook.getPreferredSize().height);
      }

    private void setUserComponentsPositions() {
        txtID.setBounds(lblID.getX()+lblID.getWidth()+HS,lblID.getY(),txtID.getPreferredSize().width,txtID.getPreferredSize().height);
        lblName.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblName.getPreferredSize().width,lblName.getPreferredSize().height);
        txtName.setBounds(lblName.getX()+lblName.getWidth()+HS,lblID.getY(),txtName.getPreferredSize().width,txtName.getPreferredSize().height);
        lblUserUsername.setBounds(txtName.getX()+txtName.getWidth()+HS,lblID.getY(),lblUserUsername.getPreferredSize().width,lblUserUsername.getPreferredSize().height);
        txtUserUsername.setBounds(lblUserUsername.getX()+lblUserUsername.getWidth()+HS,lblID.getY(),txtUserUsername.getPreferredSize().width,txtUserUsername.getPreferredSize().height);
        lblUserPassword.setBounds(txtUserUsername.getX()+txtUserUsername.getWidth()+HS,lblID.getY(),lblUserPassword.getPreferredSize().width,lblUserPassword.getPreferredSize().height);
        txtUserPassword.setBounds(lblUserPassword.getX()+lblUserPassword.getWidth()+HS,lblID.getY(),txtUserPassword.getPreferredSize().width,txtUserPassword.getPreferredSize().height);
        btnAddUser.setBounds(txtUserPassword.getX()+txtUserPassword.getWidth()+HS,lblID.getY(),btnAddUser.getPreferredSize().width,btnAddUser.getPreferredSize().height);
        btnUpdateUser.setBounds(txtUserPassword.getX()+txtUserPassword.getWidth()+HS,lblID.getY(),btnUpdateUser.getPreferredSize().width,btnUpdateUser.getPreferredSize().height);
    }

    private void setAddUserOptions(boolean visible) {
        lblID.setBounds(lblOldID.getX(), lblOldID.getY(), lblID.getPreferredSize().width, lblID.getPreferredSize().height);
        setUserComponentsPositions();
        lblID.setVisible(visible);
        txtID.setVisible(visible);
        lblName.setVisible(visible);
        txtName.setVisible(visible);
        lblUserUsername.setVisible(visible);
        txtUserUsername.setVisible(visible);
        lblUserPassword.setVisible(visible);
        txtUserPassword.setVisible(visible);
        btnAddUser.setVisible(visible);
    }

    private void setUpdateUserOptions(boolean visible) {
        lblID.setBounds(txtOldID.getX()+ txtOldID.getWidth()+HS, lblOldID.getY(),lblID.getPreferredSize().width,lblID.getPreferredSize().height);
        setUserComponentsPositions();
        lblOldID.setVisible(visible);
        txtOldID.setVisible(visible);
        lblID.setVisible(visible);
        txtID.setVisible(visible);
        lblName.setVisible(visible);
        txtName.setVisible(visible);
        lblUserUsername.setVisible(visible);
        txtUserUsername.setVisible(visible);
        lblUserPassword.setVisible(visible);
        txtUserPassword.setVisible(visible);
        btnUpdateUser.setVisible(visible);
    }

    private void setAddBookOptions(boolean visible)
    {
        lblISBN.setBounds(lblOldISBN.getX(),lblOldISBN.getY(),lblISBN.getPreferredSize().width,lblISBN.getPreferredSize().height);
        setBookComponentsPositions();
        lblISBN.setVisible(visible);
        txtISBN.setVisible(visible);
        lblTitle.setVisible(visible);
        txtTitle.setVisible(visible);
        lblAuthor.setVisible(visible);
        txtAuthor.setVisible(visible);
        lblGenre.setVisible(visible);
        txtGenre.setVisible(visible);
        lblQuantity.setVisible(visible);
        txtQuantity.setVisible(visible);
        lblPrice.setVisible(visible);
        txtPrice.setVisible(visible);
        btnAddBook.setVisible(visible);
    }

    private void setUpdateBookOptions(boolean visible)
    {
        lblOldISBN.setVisible(visible);
        txtOldISBN.setVisible(visible);
        lblISBN.setBounds(txtOldISBN.getX()+txtOldISBN.getWidth()+HS,lblOldISBN.getY(),lblISBN.getPreferredSize().width,lblISBN.getPreferredSize().height);
        setBookComponentsPositions();
        lblISBN.setVisible(visible);
        txtISBN.setVisible(visible);
        lblTitle.setVisible(visible);
        txtTitle.setVisible(visible);
        lblAuthor.setVisible(visible);
        txtAuthor.setVisible(visible);
        lblGenre.setVisible(visible);
        txtGenre.setVisible(visible);
        lblQuantity.setVisible(visible);
        txtQuantity.setVisible(visible);
        lblPrice.setVisible(visible);
        txtPrice.setVisible(visible);
        btnUpdateBook.setVisible(visible);
    }

    /**
     * Shows an informative message
     * @param s the string containing the message to be showed
     */
    public void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public String showInputDialog(String s) {
        String input=(JOptionPane.showInputDialog(frame1,s));
        if (input!=null) return input;
        else return "";
    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    public long getISBN() {
        try {
            return Long.parseLong(txtISBN.getText());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
           // showMessage("Input a valid ISBN");
        }
        return -1;
    }

    public String getTitle() {
        return txtTitle.getText();
    }

    public ArrayList<String> getAuthor() {

        String author=txtAuthor.getText();
        String[] authors=author.split(", ");
        ArrayList<String> authorList=new ArrayList<String>();
        for(String authorName:authors)
            authorList.add(authorName);
        return authorList;
    }

    public String getGenre() {
        return txtGenre.getText();
    }

    public int getQuantity() {
        try {
            return Integer.parseInt(txtQuantity.getText());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
           // showMessage("Invalid quantity");
        }
        return -1;
    }

    public float getPrice() {
        try {
            return Float.parseFloat(txtPrice.getText());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
           // showMessage("Invalid price");
        }
        return -1;
    }

    public long getOldISBN() {
        try {
            return Long.parseLong(txtOldISBN.getText());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
           // showMessage("Input a valid OldISBN");
        }
        return -1;
    }

    public int getID() {
        try {
            return Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
           // showMessage("Input a valid ID");
        }
        return -1;
    }

    public String getName() {
        return txtName.getText();
    }

    public String getUserUsername() {
        return txtUserUsername.getText();
    }

    public String getUserPassword() {
        return new String(txtUserPassword.getPassword());
    }

    public int getOldID() {
        try {
            return Integer.parseInt(txtOldID.getText());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
           // showMessage("Input a valid OldID");
        }
        return -1;
    }
}