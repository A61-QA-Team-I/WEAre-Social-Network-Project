package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

@Order(11)
public class WEAreCreateCommentTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest() {
        homeWEArePage.assertNavigated();
    }

    @Test
    public void createComment() {
        addIssueAndLink("Jira-150", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-150");


        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());

        createPostPage.navigate();
        createPostPage.createPost();

        boolean isPostTextCorrect = createPostPage.isPostTextVisible();
        Assertions.assertTrue(isPostTextCorrect, "The post text is not correct!");

        homeWEArePage.navigate();
        loginWEArePage.logout();


        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(), TestData.getValidPassword());


        likePostPage.navigate();

        int initialCommentCount = createPostPage.getCommentsCount();
        createPostPage.createComment();

        likePostPage.navigate();
        int updatedCommentCount = createPostPage.getCommentsCount();

        Assertions.assertEquals(initialCommentCount + 1, updatedCommentCount,
                "Comment count did not increase after adding a comment. Initial: "
                        + initialCommentCount + ", Updated: " + updatedCommentCount);


        homeWEArePage.navigate();
        loginWEArePage.logout();

    }
}
