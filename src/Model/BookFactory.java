package Model;

/**
 * Created by Paul on 16/04/2015.
 */
public abstract class BookFactory{

    public OutOfStockBook Build()
    {
        return buildCore();
    }

    protected abstract OutOfStockBook buildCore();

    public static BookFactory getFactory(String type)
    {
        if (type.equals("OutOfStockBook")) return new OutOfStockBookFactory();
        else return null;
    }
}
