package wearetests.web.requirementsbasedtests;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLoginTest extends WEAreBaseTest {


    @Test
    public void loginTest() {
        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button is missing.");

        loginWEArePage.logout();
    }

    @Test
    public void loginTestUser2() {
        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button is missing.");

        loginWEArePage.logout();
    }
    
}