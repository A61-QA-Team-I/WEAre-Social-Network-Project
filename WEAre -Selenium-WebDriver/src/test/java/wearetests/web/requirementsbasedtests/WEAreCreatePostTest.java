package wearetests.web.requirementsbasedtests;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreCreatePostTest extends WEAreBaseTest {


    @BeforeMethod
    public void beforeTest() {
        homeWEArePage.assertNavigated();
    }


    @Test
    public void createNewPost() {

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getValidPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        boolean isPostTextCorrect = createPostPage.isPostTextVisible();
        Assertions.assertTrue(isPostTextCorrect, "The post text is not correct!");

        deletePostPage.deletePost();
        String actualPageTitle = deletePostPage.getPageTitle();
        Assertions.assertEquals("Post deleted successfully", actualPageTitle, "Page title is not correct.");

        homeWEArePage.navigate();
        loginWEArePage.logout();
    }
}