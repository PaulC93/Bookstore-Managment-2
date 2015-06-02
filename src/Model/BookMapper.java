package Model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * Created by Paul on 14/04/2015.
 */



public class BookMapper {

    private static final String BOOKS_XML = "D:\\Faculta\\PS\\Assignments\\A2\\books.xml";
    private static final String OUT_OF_STOCK_BOOKS_XML = "D:\\Faculta\\PS\\Assignments\\A2\\booksOutOfStock.xml";

    public static BookManager loadBooks() {

        BookManager bookManager=new BookManager();
        try {
            // create JAXB context and instantiate unmarshaller
            JAXBContext context = JAXBContext.newInstance(BookManager.class);
            // get variables from our xml file, created before
            Unmarshaller um = context.createUnmarshaller();
           bookManager= (BookManager) um.unmarshal(new FileReader(BOOKS_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bookManager;
    }

    public static void saveBooks(BookManager bookManager) {
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(BookManager.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to File
            m.marshal(bookManager, new File(BOOKS_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static String saveReport(OutOfStockBooks outOfStockBooks) {
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(OutOfStockBooks.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to File
            m.marshal(outOfStockBooks, new File(OUT_OF_STOCK_BOOKS_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return OUT_OF_STOCK_BOOKS_XML;
    }
}