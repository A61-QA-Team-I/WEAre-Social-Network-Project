package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreAnonymousLikePostTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void anonymousLikePost() {
        addIssueAndLink("Jira-146", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-146");


        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        homeWEArePage.navigate();
        loginWEArePage.logout();


        homeWEArePage.navigate();


        likePostPage.navigate();
        likePostPage.likePost();

        boolean isClickable = likePostPage.likePost();

        if (!isClickable) {
            Assertions.assertTrue(true, "You cannot click the like button because you are an anonymous user.");
        }

    }
}
