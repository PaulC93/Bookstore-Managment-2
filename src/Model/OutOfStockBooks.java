package Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Paul on 16/04/2015.
 */

@XmlRootElement(name="bookList")
public class OutOfStockBooks {

    @XmlElement(name="book")
    private ArrayList<OutOfStockBook> outOfStock;

    public OutOfStockBooks(){}

    public OutOfStockBooks(ArrayList<OutOfStockBook> outOfStock) {
        this.outOfStock = outOfStock;
    }
}
