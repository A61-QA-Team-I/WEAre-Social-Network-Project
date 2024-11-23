package wearetests.web.requirementsbasedtests;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreSendRequest extends WEAreBaseTest {


    @BeforeMethod
    public void beforeTest(){

        homeWEArePage.assertNavigated();
        //registerWEArePage.navigate();
    }

    @Test
    public void sendRequestTest () {

//133
        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();
        requestWEArePage.sendRequest();

        String actualPageTitle = requestWEArePage.getPageTitle();
        Assertions.assertEquals("Good job! You have send friend request!", actualPageTitle, "Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();

    }
}
