package wearetests.web;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreCreatePostTest extends WEAreBaseTest {


    @BeforeEach
    public void beforeTest() {
        homeWEArePage.assertNavigated();
    }


    @Test
    public void createNewPost() {

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        boolean isPostTextCorrect = createPostPage.isPostTextVisible();
        Assertions.assertTrue(isPostTextCorrect, "The post text is not correct!");


        homeWEArePage.navigate();
        loginWEArePage.logout();
    }
}