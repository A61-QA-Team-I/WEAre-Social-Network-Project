package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import com.testData.UniqueNameGenerator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreAdminDeletePostTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest() {
        homeWEArePage.assertNavigated();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void adminDeletePost() {
        addIssueAndLink("Jira-151", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-151");


        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        homeWEArePage.navigate();
        loginWEArePage.logout();


        String uniqueAdminName = UniqueNameGenerator.getInstance().generateUniqueName() + "admin";
        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(uniqueAdminName, TestData.getValidEmail(),
                TestData.getValidPassword(),
                TestData.getConfValidPassword());

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(uniqueAdminName, TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");


        likePostPage.navigate();
        deletePostPage.deletePost();

        String actualPageTitle = deletePostPage.getPageTitle();
        Assertions.assertEquals("Post deleted successfully", actualPageTitle, "Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();
    }
}
