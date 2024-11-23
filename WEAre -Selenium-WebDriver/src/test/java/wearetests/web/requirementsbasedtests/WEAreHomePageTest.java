package wearetests.web.requirementsbasedtests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreHomePageTest extends WEAreBaseTest {


    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void homePage() {

        addIssueAndLink("Jira-136", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-136");

        homeWEArePage.navigate();
        homeWEArePage.assertNavigated();

        homeWEArePage.checkElementVisibility();

        String actualPageTitle = homeWEArePage.getPageTitle();
        Assertions.assertEquals("The Easiest Way to Hack the Crisis", actualPageTitle, "Page title is not correct.");

    }
}
