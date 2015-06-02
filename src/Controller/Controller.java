package Controller;

import Model.*;
import View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Paul on 14/04/2015.
 */
public class Controller {

    private Model model;
    private GUI view;

    public Controller(GUI view, Model model) {
        this.model = model;
        this.view = view;

        view.addConnectActionListener(new ConnectActionListener());
        view.addViewBooksByISBNActionListener(new ViewBooksByISBNActionListener());
        view.addViewBooksByGenreActionListener(new ViewBooksByGenreActionListener());
        view.addViewBooksByTitleActionListener(new ViewBooksByTitleActionListener());
        view.addViewBooksByAuthorActionListener(new ViewBooksByAuthorActionListener());
        view.addViewAllBooksActionListener(new ViewAllBooksActionListener());
        view.addSellBookActionListener(new SellBookActionListener());
        view.addAddBookActionListener(new AddBookActionListener());
        view.addSaveActionListener(new SaveActionListener());
        view.addUpdateBookActionListener(new UpdateBookActionListener());
        view.addDeleteBookActionListener(new DeleteBookActionListener());
        view.addAddUserActionListener(new AddUserActionListener());
        view.addViewAllUsersActionListener(new ViewAllUsersActionListener());
        view.addViewUserByIDActionListener(new ViewUserByIDActionListener());
        view.addUpdateUserActionListener(new UpdateUserActionListener());
        view.addDeleteUserActionListener(new DeleteUserActionListener());
        view.addGenerateReportActionListener(new GenerateReportActionListener());
    }

    private class ConnectActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!model.isLoggedIn()) {
                String status = model.login(view.getUsername(), view.getPassword());
                if (status.equals("Admin")) view.setAdminOptions();
                else if (status.equals("User")) view.setUserOptions();
                else view.showMessage("Check inputs and try again");
            } else {
                model.logOut();
                view.setAllOptionsInvisibleAndTable();
            }

            if (model.isLoggedIn()) view.setLoginEnabled(false);
            else view.setLoginEnabled(true);
        }
    }


    private class ViewBooksByISBNActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                long ISBN = Long.parseLong(view.showInputDialog("Input the ISBN of the book that you wish to view:"));
                Book book = model.getBookByISBN(ISBN);
                if (book != null) {
                    String[] columnNames = {"ISBN", "title", "author", "genre", "quantity", "price"};
                    Object[][] data = new Object[1][6];
                    data[0][0] = book.getISBN();
                    data[0][1] = book.getTitle();
                    data[0][2] = book.getAuthor();
                    data[0][3] = book.getGenre();
                    data[0][4] = book.getQuantity();
                    data[0][5] = book.getPrice();
                    view.addTable(columnNames, data);
                } else view.showMessage("No Book found or invalid ID");
            } catch (NumberFormatException nfe) {
                view.showMessage("Invalid ID");
                //nfe.printStackTrace();
            }
        }
    }

    private class ViewBooksByGenreActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String genre = view.showInputDialog("Input the genre of the books that you wish to view:");
            if (genre != null) {
                ArrayList<Book> bookList = model.getBooksByGenre(genre);
                if (!bookList.isEmpty()) {
                    String[] columnNames = {"ISBN", "title", "author", "genre", "quantity", "price"};
                    Object[][] data = new Object[bookList.size()][6];
                    for (int i = 0; i < bookList.size(); i++) {
                        Book book = bookList.get(i);
                        data[i][0] = book.getISBN();
                        data[i][1] = book.getTitle();
                        data[i][2] = book.getAuthor();
                        data[i][3] = book.getGenre();
                        data[i][4] = book.getQuantity();
                        data[i][5] = book.getPrice();
                    }
                    view.addTable(columnNames, data);
                } else view.showMessage("No books found");
            }
        }
    }

    private class ViewBooksByTitleActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = view.showInputDialog("Input the title of the books that you wish to view:");
            if (title != null) {
                ArrayList<Book> bookList = model.getBooksByTitle(title);
                if (bookList != null)
                    if (!bookList.isEmpty()) {
                        String[] columnNames = {"ISBN", "title", "author", "genre", "quantity", "price"};
                        Object[][] data = new Object[bookList.size()][6];
                        for (int i = 0; i < bookList.size(); i++) {
                            Book book = bookList.get(i);
                            data[i][0] = book.getISBN();
                            data[i][1] = book.getTitle();
                            data[i][2] = book.getAuthor();
                            data[i][3] = book.getGenre();
                            data[i][4] = book.getQuantity();
                            data[i][5] = book.getPrice();
                        }
                        view.addTable(columnNames, data);
                    } else view.showMessage("No books found");
            }
        }
    }

    private class ViewBooksByAuthorActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String author = view.showInputDialog("Input the author of the books that you wish to view:");
            if (author != null) {
                ArrayList<Book> bookList = model.getBooksByAuthor(author);
                if (bookList != null)
                    if (!bookList.isEmpty()) {
                        String[] columnNames = {"ISBN", "title", "author", "genre", "quantity", "price"};
                        Object[][] data = new Object[bookList.size()][6];
                        for (int i = 0; i < bookList.size(); i++) {
                            Book book = bookList.get(i);
                            data[i][0] = book.getISBN();
                            data[i][1] = book.getTitle();
                            data[i][2] = book.getAuthor();
                            data[i][3] = book.getGenre();
                            data[i][4] = book.getQuantity();
                            data[i][5] = book.getPrice();
                        }
                        view.addTable(columnNames, data);
                    } else view.showMessage("No books found");
            }
        }
    }

    private class ViewAllBooksActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Book> bookList = model.getAllBooks();
            if (!bookList.isEmpty()) {
                String[] columnNames = {"ISBN", "title", "author", "genre", "quantity", "price"};
                Object[][] data = new Object[bookList.size()][6];
                for (int i = 0; i < bookList.size(); i++) {
                    Book book = bookList.get(i);
                    data[i][0] = book.getISBN();
                    data[i][1] = book.getTitle();
                    data[i][2] = book.getAuthor();
                    data[i][3] = book.getGenre();
                    data[i][4] = book.getQuantity();
                    data[i][5] = book.getPrice();
                }
                view.addTable(columnNames, data);
            } else view.showMessage("No books found");
        }
    }


    private class SellBookActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                long ISBN = Long.parseLong(view.showInputDialog("Input the ISBN of the book that you wish to sell:"));
                view.showMessage(model.sellBook(ISBN));
            } catch (NumberFormatException e1) {
                //e1.printStackTrace();
                view.showMessage("Invalid ISBN");
            }
        }
    }

    private class AddBookActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage(model.addBook(view.getISBN(), view.getTitle(), view.getAuthor(), view.getGenre(), view.getQuantity(), view.getPrice()));
        }
    }

    private class UpdateBookActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage(model.updateBook(view.getOldISBN(), view.getISBN(), view.getTitle(), view.getAuthor(), view.getGenre(), view.getQuantity(), view.getPrice()));
        }
    }

    private class DeleteBookActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Long ISBN=Long.parseLong(view.showInputDialog("Input the ISBN of the book you wish to delete"));
               if(ISBN!=null) view.showMessage(model.deleteBook(ISBN));
            } catch (NumberFormatException e1) {
               // e1.printStackTrace();
                view.showMessage("Invalid ISBN");
            }
        }
    }

    private class SaveActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.saveToFile();
            view.showMessage("Saved to file");
        }
    }

    private class AddUserActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage(model.addUser(view.getID(), view.getName(), view.getUserUsername(), view.getUserPassword()));
        }
    }

    private class ViewUserByIDActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int ID =Integer.parseInt(view.showInputDialog("Input the ID of the user that you wish to view:"));
                User user = model.getUserByID(ID);
                if (user != null) {
                    String[] columnNames = { "ID","name","username","password"};
                    Object[][] data = new Object[1][4];
                    data[0][0] = user.getID();
                    data[0][1] = user.getName();
                    data[0][2] = user.getUsername();
                    data[0][3] = user.getPassword();
                    view.addTable(columnNames, data);
                } else view.showMessage("No user found or invalid ID");
            } catch (NumberFormatException nfe) {
                view.showMessage("Invalid ID");
                //nfe.printStackTrace();
            }
        }
    }

    private class ViewAllUsersActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<User> userList = model.getAllUsers();
            if (!userList.isEmpty()) {
                String[] columnNames = { "ID","name","username","password"};
                Object[][] data = new Object[userList.size()][4];
                for (int i = 0; i < userList.size(); i++) {
                    User user=userList.get(i);
                    data[i][0] = user.getID();
                    data[i][1] = user.getName();
                    data[i][2] = user.getUsername();
                    data[i][3] = user.getPassword();
                }
                view.addTable(columnNames, data);
            } else view.showMessage("No users found");
        }
    }

    private class UpdateUserActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage(model.updateUser(view.getOldID(), view.getID(), view.getName(), view.getUserUsername(), view.getUserPassword()));
        }
    }

    private class DeleteUserActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Integer ID=Integer.parseInt(view.showInputDialog("Input the ID of the user you wish to delete"));
                if(ID!=null) view.showMessage(model.deleteUser(ID));
            } catch (NumberFormatException e1) {
              //  e1.printStackTrace();
                view.showMessage("Invalid ID");
            }
        }
    }

    private class GenerateReportActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showMessage("Report generated in "+model.generateReport());
        }
    }
}