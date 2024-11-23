package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLoginTest extends WEAreBaseTest {


    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginTest() {
        addIssueAndLink("Jira-134", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-134");


        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button is missing.");

        loginWEArePage.logout();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginTestUser2() {
        addIssueAndLink("Jira-134", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-134");


        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button is missing.");

        loginWEArePage.logout();
    }
}