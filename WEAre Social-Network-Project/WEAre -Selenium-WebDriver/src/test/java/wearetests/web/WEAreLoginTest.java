package wearetests.web;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLoginTest extends WEAreBaseTest {


    @Test
    public void loginTest() {
        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button is missing.");

        loginWEArePage.logout();
    }
    
}