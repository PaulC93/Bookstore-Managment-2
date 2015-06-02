package Model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Paul on 20/04/2015.
 */

@XmlRootElement(name = "book")
@XmlType(propOrder = { "ISBN", "title", "author", "genre"})
public class OutOfStockBook {

    private long ISBN;
    private String title, genre;
    private ArrayList<String> author;

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<String> author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
