package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLikePostTest extends WEAreBaseTest {


    @BeforeEach
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }


    @Test
    public void likePost() {

        addIssueAndLink("Jira-135", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-135");

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        homeWEArePage.navigate();
        loginWEArePage.logout();

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(), TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        likePostPage.navigate();
        likePostPage.likePost();

        String newValue = likePostPage.getLikeButtonValue();
        Assertions.assertEquals("Dislike", newValue, "The button did not change to 'Dislike' after being clicked!");

        homeWEArePage.navigate();
        loginWEArePage.logout();

    }
}
