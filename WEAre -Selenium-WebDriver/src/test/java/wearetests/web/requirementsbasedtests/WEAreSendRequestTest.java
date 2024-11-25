package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreSendRequestTest extends WEAreBaseTest {


    @BeforeEach
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }


    @Test
    public void sendRequestTest() {
        addIssueAndLink("Jira-133", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-133");

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();
        requestWEArePage.sendRequest();

        String actualPageTitle = requestWEArePage.getPageTitle();
        Assertions.assertEquals("Good job! You have send friend request!", actualPageTitle, "Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();

    }
}
