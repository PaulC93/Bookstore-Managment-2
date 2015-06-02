package Model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Paul on 16/04/2015.
 */

@XmlRootElement(name= "userList")
@XmlAccessorType(XmlAccessType.FIELD)

public class UserManager {
    @XmlElement(name = "user")
    private ArrayList<User> regularUsers;
    @XmlElement(name = "admin")
    private ArrayList<User> adminUsers;

    @XmlTransient
    private boolean loggedIn;

    public UserManager()
    {
        loggedIn=false;
    }

    public String addUser(int ID, String name, String username, String password)
    {
            User user = new User(ID, name, username, password);
            if (!regularUsers.contains(user)) regularUsers.add(user);
            else return "User already exists";
            if (regularUsers.contains(user)) return "Success";
            else return "Failure";
    }


    public User getUserByID(int ID)
    {
        for(User user:regularUsers)
            if (user.getID()==ID) return user;
        return null;
    }

    public String updateUser(int oldISB, int ID, String name, String username, String password)
    {
        User user=getUserByID(oldISB);
        if (user==null) return "User not found";
        user.setID(ID);
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        return "Success";
    }

    public String deleteUser(int ID)
    {
        User userToRemove=null;
        for(User user:regularUsers) {
            if (user.getID() == ID) userToRemove=user;
        }
        if (userToRemove != null)
        {
            regularUsers.remove(userToRemove);
            return "Success";
        }
        else  return "User not found";
    }

    public String login(String username,String password) {
        for (User user : adminUsers)
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedIn=true;
                return "Admin";
            }

        for (User user : regularUsers)
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    loggedIn=true;
                    return "User";
                }
        return "Not found";
    }

    public void logOut()
    {
        loggedIn=false;
    }


    public boolean isLoggedIn() {
        return loggedIn;
    }

    public ArrayList<User> getAllUsers() {
        return regularUsers;
    }
}