package wearetests.web.requirementsbasedtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

@Order(1)
public class WEAreCreateUserTest extends WEAreBaseTest {


    @Test
    public void createUserWithValidCredentials() {
        addIssueAndLink("Jira-138", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-138");
        String actualPageTitle = registerWEArePage.getSuccessfulCreateUserPageTitle();

        Assertions.assertEquals("Welcome to our community.", actualPageTitle, "Page title is not correct.");

    }
}
