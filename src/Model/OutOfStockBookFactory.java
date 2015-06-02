package Model;

/**
 * Created by Paul on 16/04/2015.
 */
public class OutOfStockBookFactory extends BookFactory {

    @Override
    protected OutOfStockBook buildCore() {
        OutOfStockBook book=new OutOfStockBook();
        return book;
    }

    public static BookFactory getFactory(String type)
    {
        if (type.equals("OutOfStockBook")) return new OutOfStockBookFactory();
        else return null;
    }
}
