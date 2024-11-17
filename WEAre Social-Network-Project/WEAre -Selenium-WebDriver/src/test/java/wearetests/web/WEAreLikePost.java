package wearetests.web;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLikePost extends WEAreBaseTest {


    @BeforeEach
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }


    @Test
    public void likePost() {

        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(), TestData.getPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        createPostPage.navigate();
        createPostPage.createPost();

        homeWEArePage.navigate();
        loginWEArePage.logout();

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getSecondRegisteredName(), TestData.getSecondPassword());
        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        likePostPage.navigate();
        likePostPage.likePost();

        String newValue = likePostPage.getLikeButtonValue();
        Assertions.assertEquals("Dislike", newValue, "The button did not change to 'Dislike' after being clicked!");

        homeWEArePage.navigate();
        loginWEArePage.logout();


       }
}
