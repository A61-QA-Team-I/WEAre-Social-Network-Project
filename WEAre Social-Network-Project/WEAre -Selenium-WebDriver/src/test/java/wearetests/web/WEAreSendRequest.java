package wearetests.web;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreSendRequest extends WEAreBaseTest {


    @BeforeEach
    public void beforeTest(){

        homeWEArePage.assertNavigated();
        registerWEArePage.navigate();
    }

    @Test
    public void sendRequestTest () {


        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();
        requestWEArePage.sendRequest();

        String actualPageTitle = requestWEArePage.getPageTitle();
        Assertions.assertEquals("Good job! You have send friend request!", actualPageTitle, "Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();

    }
}
