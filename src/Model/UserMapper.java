package Model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Paul on 16/04/2015.
 */
public class UserMapper {

    private static final String USERS_XML = "D:\\Faculta\\PS\\Assignments\\A2\\users.xml";

    public static UserManager loadUsers() {

        UserManager userManager = new UserManager();
        try {
            // create JAXB context and instantiate unmarshaller
            JAXBContext context = JAXBContext.newInstance(UserManager.class);
            // get variables from our xml file, created before
            Unmarshaller um = context.createUnmarshaller();
            userManager = (UserManager) um.unmarshal(new FileReader(USERS_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return userManager;
    }

    public static void saveUsers(UserManager UserManager) {
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(UserManager.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to File
            m.marshal(UserManager, new File(USERS_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
