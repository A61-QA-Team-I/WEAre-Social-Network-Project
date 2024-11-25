package wearetests.web.failuretomeetrequirements;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

@Order(15)
public class WEAreSearchingUserTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest() {

        homeWEArePage.assertNavigated();
        loginWEArePage.navigate();

    }

    @Test
    public void searchingUserByFirstName() {

        addIssueAndLink("Jira-147", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-147");

        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        homeWEArePage.searchUser();

        boolean titleNotPresent = homeWEArePage.isTitleNotPresent();

        Assertions.assertTrue(titleNotPresent, "The title should not be present on the page.");

    }


    @Test
    public void searchingUserByEmail() {

        addIssueAndLink("Jira-148", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-148");
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        homeWEArePage.searchUserByEmail();

        boolean titleNotPresent = homeWEArePage.isTitleNotPresent();

        Assertions.assertTrue(titleNotPresent, "The title should not be present on the page.");

    }
}
