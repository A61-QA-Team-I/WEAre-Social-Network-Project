package baseTests;
import baseSetup.BaseSetup;
import org.testng.annotations.Test;




public class FriendRequest extends BaseSetup{


    @Test(priority = 1)
    public void testCreateUser() {

       createUser();
    }

    @Test(priority = 2)
    public void testLogIn() {

        logIn();

    }


    @Test(priority = 3)
    public void testCreateUser2() {

        createUser2();
    }


    @Test(priority = 4)
    public void testSendRequest() {

        sendRequest();

    }


    @Test(priority = 5)
    public void testLogInUser2() {

        logInUser2();
    }


    @Test(priority = 6)
    public void testGetRequestUser2() {

        getRequestUser2();

    }


    @Test(priority = 7)
    public void testApproveRequest() {

        approveRequest();
    }
}