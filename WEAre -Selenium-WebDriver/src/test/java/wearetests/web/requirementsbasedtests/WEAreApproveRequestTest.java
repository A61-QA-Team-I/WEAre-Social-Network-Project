package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;


public class WEAreApproveRequestTest extends WEAreBaseTest {


    @BeforeEach
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }


    @Test
    public void approveRequestTest() {
        addIssueAndLink("Jira-140", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-140");


        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();
        requestWEArePage.sendRequest();

        homeWEArePage.navigate();
        loginWEArePage.logout();

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        requestWEArePage.navigate();

        homeWEArePage.navigate();
        requestWEArePage.approveRequest();

        String actualPageTitle = requestWEArePage.getPageApproveTitle();
        Assertions.assertEquals(
                "There are no requests", actualPageTitle, "Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();
    }
}

