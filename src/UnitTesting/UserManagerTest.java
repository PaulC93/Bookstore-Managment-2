package UnitTesting;

import Model.User;
import Model.UserManager;
import Model.UserMapper;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UserManagerTest {

    private UserManager userManager;
    private int newID, existingID;
    private String newName, newUsername, newPassword, existingName,existingUsername,existingPassword;

    @Before
    public void setUp()
    {
        existingID=0;
        existingName="Zero";
        existingUsername="0";
        existingPassword="0";
        newID=12348;
        newName="newName";
        newUsername="newUsername";
        newPassword="newPassword";
        userManager= UserMapper.loadUsers();
    }

    @Test
    public void testAddUser() throws Exception {
        userManager.addUser(newID,newName,newUsername,newPassword);
        User newUser=userManager.getUserByID(newID);
        assertEquals(newID, newUser.getID());
    }

    @Test
    public void testGetUserByID() throws Exception {
        User user=userManager.getUserByID(existingID);
        assertEquals(existingID,user.getID());
    }

    @Test
    public void testUpdateUser() throws Exception {
        userManager.updateUser(existingID,newID,newName,newUsername,newPassword);
        User updatedUser=new User(newID,newName, newUsername,newPassword);
        User oldUser=userManager.getUserByID(existingID);
        User obtainedUser=userManager.getUserByID(newID);

        assertEquals(oldUser,null);
        assertEquals(updatedUser,obtainedUser);

       //rollback
       userManager.updateUser(newID,existingID,existingName,existingUsername,existingPassword);
    }

    @Test
         public void testDeleteUser() throws Exception {
        userManager.addUser(newID,newName,newUsername,newPassword);
        userManager.deleteUser(newID);
        User oldUser=userManager.getUserByID(newID);

        assertEquals(null,oldUser);
    }

    @Test
    public void testLoginUser() throws Exception {

        String status=userManager.login("A0","A0");
        assertEquals("Admin", status);

        status=userManager.login("0","0");
        assertEquals("User",status);

         status=userManager.login("","");
        assertEquals("Not found",status);
    }
}