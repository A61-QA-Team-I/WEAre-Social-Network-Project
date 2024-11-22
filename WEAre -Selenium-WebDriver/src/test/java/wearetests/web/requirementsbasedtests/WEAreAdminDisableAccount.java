package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import com.testData.UniqueNameGenerator;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreAdminDisableAccount extends WEAreBaseTest {

    @BeforeMethod
    public void beforeTest() {
        homeWEArePage.assertNavigated();

    }
    @Test
    public void adminDisableAccount() {

        String uniqueAdminName = UniqueNameGenerator.getInstance().generateUniqueName() + "admin";
        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(uniqueAdminName, TestData.getValidEmail(),
                TestData.getValidPassword(),
                TestData.getConfValidPassword());

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(uniqueAdminName, TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        administrationPage.navigate();
        administrationPage.disableProfile();

        homeWEArePage.navigate();
        loginWEArePage.logout();

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(),TestData.getValidPassword());

        String actualPageTitle = administrationPage.getPageTitle();
        Assertions.assertEquals("Wrong username or password.", actualPageTitle, "Page title is not correct.");


        homeWEArePage.navigate();

    }
}
