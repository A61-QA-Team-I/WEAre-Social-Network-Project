package baseTests;
import baseSetup.BaseSetup;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;




public class FriendRequest extends BaseSetup{

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void testCreateUser() {

       createUser();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void testLogIn() {

        logIn();

    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void testCreateUser2() {

        createUser2();
    }


    @Test(priority = 4)
    public void testSendRequest() {

        sendRequest();

    }


    @Severity(SeverityLevel.CRITICAL)
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