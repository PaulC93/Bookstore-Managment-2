package Model;

import java.util.ArrayList;

/**
 * Created by Paul on 16/04/2015.
 */
public class BookValidator {

    public static String validateBookData(long ISBN, String title, ArrayList<String> author, String genre, int quantity, float price)
    {
        if (!(ISBN>=1000000000000L && ISBN<=9999999999999L)) return "Invalid ISBN";
        else if (!(quantity>=0)) return "Invalid quantity";
        else if (!(price>=0)) return "Invalid price";
        else return "Valid";
    }
}
