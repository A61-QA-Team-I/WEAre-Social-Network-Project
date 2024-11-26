package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import com.testData.UniqueNameGenerator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

@Order(13)
public class WEAreAdminDisableAccountTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest() {
        homeWEArePage.assertNavigated();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void adminDisableAccount() {
        addIssueAndLink("Jira-152", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-152");


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
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(), TestData.getValidPassword());

        String actualPageTitle = administrationPage.getPageTitle();
        Assertions.assertEquals("Wrong username or password.", actualPageTitle, "Page title is not correct.");


        homeWEArePage.navigate();

    }
}
