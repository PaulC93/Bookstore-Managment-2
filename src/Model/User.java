package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Paul on 16/04/2015.
 */

@XmlType(propOrder = { "ID","name","username","password"})
public class User {

    private int ID;
    private String name,username,password;

    public User(){}

    public User(int ID, String name, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object object)
    {
        if (object instanceof User)
        {
            User user=(User) object;
            if(this.getID()==user.getID() && this.getName().equals(user.getName())
                    && this.getUsername().equals(user.getUsername()) && this.getPassword().equals(user.getPassword()))
                return true;
            else return false;
        }
        else return false;
    }
}
