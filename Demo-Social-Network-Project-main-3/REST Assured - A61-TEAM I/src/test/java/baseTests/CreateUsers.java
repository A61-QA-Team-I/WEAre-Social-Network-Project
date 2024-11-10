package baseTests;
import baseSetup.BaseSetup;
import org.testng.annotations.Test;



public class CreateUsers extends BaseSetup {


    @Test(priority = 1)
    public void testCreateUser() {

       createUser();
    }


    @Test(priority = 2)
    public void testLogIn() {

        logIn();
    }


    @Test(priority = 3)
    public void testUpdateUserPersonalInfo() {

   updateUserPersonalInfo();
    }


    @Test(priority = 4)
    public void testCreateUser2() {

       createUser2();
    }


    @Test(priority = 5)
    public void testGetAllUsers() {

        getAllUsers();
    }
}