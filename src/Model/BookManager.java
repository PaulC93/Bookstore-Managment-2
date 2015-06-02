package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Paul on 14/04/2015.
 */

@XmlRootElement(name= "bookList")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookManager {

     @XmlElement(name = "book")
    private ArrayList<Book> bookList;

    public BookManager()
    {
        bookList=new ArrayList<Book>();
    }

    public String addBook(long ISBN, String title, ArrayList<String> author, String genre, int quantity, float price)
    {
        String status=BookValidator.validateBookData(ISBN, title, author, genre, quantity, price);

        if (status.equals("Valid")) {
            Book book = new Book(ISBN, title, author, genre, quantity, price);
            if (!bookList.contains(book)) bookList.add(book);
            else return "Book already exists";
            if (bookList.contains(book)) return "Success";
            else return "Failure";
        }
        return status;
    }


    public Book getBookByISBN(long ISBN)
    {
        for(Book book:bookList)
            if (book.getISBN()==ISBN) return book;
        return null;
    }

    public ArrayList<Book> getBooksByTitle(String title)
    {
        ArrayList<Book> foundBooks=new ArrayList<Book>();

        for(Book book:bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) foundBooks.add(book);
        }
        return foundBooks;
    }

    public ArrayList<Book> getBooksByGenre(String genre)
    {
        ArrayList<Book> foundBooks=new ArrayList<Book>();

        for(Book book:bookList) {
            if (book.getGenre().equalsIgnoreCase(genre)) foundBooks.add(book);
        }
        return foundBooks;
    }


    public ArrayList<Book> getBooksByAuthor(String author)
    {
        ArrayList<Book> foundBooks=new ArrayList<Book>();

        for(Book book:bookList) {
            for (String authorName:book.getAuthor())
            if (author.equalsIgnoreCase(authorName)) foundBooks.add(book);
        }
        return foundBooks;
    }

    public String sellBook(long ISBN)
    {
        for(Book book:bookList)
            if (book.getISBN()==ISBN) {
                if (book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1);
                    return "Success";
                } else return "Not enough books to sell";
            }
       return "Book not found";
    }

    public String updateBook(long oldISB, long ISBN, String title, ArrayList<String> author, String genre, int quantity, float price)
    {
        Book book=getBookByISBN(oldISB);
        if (book==null) return "Book not found";

        String status=BookValidator.validateBookData(ISBN, title, author, genre, quantity, price);
        if (status.equals("Valid")) {
            book.setISBN(ISBN);
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            book.setQuantity(quantity);
            book.setPrice(price);
            return "Success";
        }
        else return status;
    }

    public String deleteBook(long ISBN)
    {
        Book bookToRemove=null;
        for(Book book:bookList) {
            if (book.getISBN() == ISBN) bookToRemove=book;
        }
        if (bookToRemove != null)
        {
            bookList.remove(bookToRemove);
            return "Success";
        }
        else  return "Book not found";
    }

    public String generateReport()
    {
        ArrayList<Book> outOfStock=new ArrayList<Book>();
        ArrayList<OutOfStockBook> outOfStock2=new ArrayList<OutOfStockBook>();
        for(Book book:bookList) {
            if (book.getQuantity()==0) outOfStock.add(book);
        }

        BookFactory bookFactory=BookFactory.getFactory("OutOfStockBook");

        for (Book book:outOfStock) {
            OutOfStockBook outOfStockBook = bookFactory.Build();
            outOfStockBook.setISBN(book.getISBN());
            outOfStockBook.setTitle(book.getTitle());
            outOfStockBook.setAuthor(book.getAuthor());
            outOfStockBook.setGenre(book.getGenre());
            outOfStock2.add(outOfStockBook);
        }

       return BookMapper.saveReport(new OutOfStockBooks(outOfStock2));
    }

    public ArrayList<Book> getAllBooks() {
        return bookList;
    }
}
