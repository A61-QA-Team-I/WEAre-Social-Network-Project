package wearetests.web.securitytesting;

import com.testData.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLoginWithCommonPasswords extends WEAreBaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testAttemptLoginWithCommonPasswords() {
        addIssueAndLink("Jira-169", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-169");

        loginWEArePage.navigate();
        String registeredName = TestData.getRegisteredName();

        boolean loginSuccess = loginWEArePage.attemptLoginWithCommonPasswords(registeredName, TestData.getValidEmail(), TestData.getValidPassword(), registeredName);
        Assertions.assertTrue(loginSuccess, "Login with common passwords should succeed if one password matches.");

        loginWEArePage.logout();
    }
}
