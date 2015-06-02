package Model;

import java.util.ArrayList;

/**
 * Created by Paul on 20/04/2015.
 */
public class Model {
    private BookManager bookManager;
    private UserManager userManager;

    public Model()
    {
        bookManager=BookMapper.loadBooks();
        userManager=UserMapper.loadUsers();
    }

    public boolean isLoggedIn() {
        return userManager.isLoggedIn();
    }

    public String login(String username, String password) {
        return userManager.login(username,password);
    }

    public void logOut() {
        userManager.logOut();
    }

    public Book getBookByISBN(long isbn) {
        return bookManager.getBookByISBN(isbn);
    }

    public ArrayList<Book> getBooksByGenre(String genre) {
        return bookManager.getBooksByGenre(genre);
    }

    public ArrayList<Book> getBooksByTitle(String title) {
        return bookManager.getBooksByTitle(title);
    }

    public ArrayList<Book> getBooksByAuthor(String author) {
        return bookManager.getBooksByAuthor(author);
    }

    public ArrayList<Book> getAllBooks() {
        return bookManager.getAllBooks();
    }

    public String sellBook(long isbn) {
        return bookManager.sellBook(isbn);
    }

    public String addBook(long isbn, String title,ArrayList<String> authorList, String genre, int quantity, float price) {
            return bookManager.addBook(isbn, title, authorList, genre, quantity, price);
    }

    public void saveToFile() {
        BookMapper.saveBooks(bookManager);
        UserMapper.saveUsers(userManager);
    }

    public String updateBook(long oldISBN, long isbn, String title, ArrayList<String> author, String genre, int quantity, float price) {
        return  bookManager.updateBook(oldISBN, isbn, title, author, genre, quantity, price);
    }

    public String deleteBook(long isbn) {
        return bookManager.deleteBook(isbn);
    }

    public String addUser(int id, String name, String username, String password) {
        return userManager.addUser(id, name, username, password);
    }

    public String updateUser(int oldID, int id, String name, String userUsername, String userPassword) {
        return userManager.updateUser(oldID, id, name, userUsername, userPassword);
    }

    public User getUserByID(int id) {
        return userManager.getUserByID(id);
    }

    public ArrayList<User> getAllUsers() {
        return userManager.getAllUsers();
    }

    public String deleteUser(int id) {
        return userManager.deleteUser(id);
    }

    public String generateReport() {
      return bookManager.generateReport();
    }
}
