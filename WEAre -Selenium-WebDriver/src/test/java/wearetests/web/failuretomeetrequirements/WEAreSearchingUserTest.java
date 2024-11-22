package wearetests.web.failuretomeetrequirements;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreSearchingUserTest extends WEAreBaseTest {

    @BeforeMethod
    public void beforeTest(){

        homeWEArePage.assertNavigated();
        loginWEArePage.navigate();

    }

    @Test
    public void searchingUserByFirstName() {

        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        homeWEArePage.searchUser();

        boolean titleNotPresent = homeWEArePage.isTitleNotPresent();

        Assertions.assertTrue(titleNotPresent, "The title should not be present on the page.");

    }



    @Test
    public void searchingUserByEmail() {

        //loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        homeWEArePage.searchUserByEmail();

        boolean titleNotPresent = homeWEArePage.isTitleNotPresent();

        Assertions.assertTrue(titleNotPresent, "The title should not be present on the page.");

    }
}
