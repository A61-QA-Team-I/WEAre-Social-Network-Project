package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreCreateCommentTest extends WEAreBaseTest {

    @BeforeMethod
    public void beforeTest() {
        homeWEArePage.assertNavigated();
    }

    @Test
    public void createComment() {



        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        boolean isPostTextCorrect = createPostPage.isPostTextVisible();
        Assertions.assertTrue(isPostTextCorrect, "The post text is not correct!");

        homeWEArePage.navigate();
        loginWEArePage.logout();



        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");


        likePostPage.navigate();
        //likePostPage.likePost();

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
