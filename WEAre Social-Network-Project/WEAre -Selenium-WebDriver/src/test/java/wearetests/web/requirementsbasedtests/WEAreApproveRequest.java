package wearetests.web.requirementsbasedtests;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;


public class WEAreApproveRequest extends WEAreBaseTest {


    @BeforeMethod
    public void beforeTest(){

        homeWEArePage.assertNavigated();
    }


    @Test
    public void approveRequestTest () {

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();
        requestWEArePage.sendRequest();

        homeWEArePage.navigate();
        loginWEArePage.logout();

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(),TestData.getSecondPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();

        homeWEArePage.navigate();
        requestWEArePage.approveRequest();

        String actualPageTitle = requestWEArePage.getPageApproveTitle();
        Assertions.assertEquals(
                "There are no requests",actualPageTitle,"Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();
    }
}

