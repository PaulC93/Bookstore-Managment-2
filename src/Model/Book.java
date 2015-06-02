package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Created by Paul on 14/04/2015.
 */

@XmlRootElement(name = "book")
@XmlType(propOrder = { "quantity", "price"})
public class Book extends  OutOfStockBook{

    private int quantity;
    private float price;

    public Book() {};

    public Book(long ISBN, String title,ArrayList<String> author, String genre, int quantity, float price) {
        this.setISBN(ISBN);
        this.setTitle(title);
        this.setAuthor(author);
        this.setGenre(genre);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;

            if (this.getAuthor().containsAll(book.getAuthor()) && book.getAuthor().containsAll(this.getAuthor())
            && (this.getISBN()==book.getISBN() && this.getTitle().equals(book.getTitle())  &&
                    this.getGenre().equals(book.getGenre()) && this.getQuantity()==book.getQuantity() && this.getPrice()==book.getPrice()))
                return true;
            else return false;
        }
        else return false;
    }
}
