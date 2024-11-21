package wearetests.web.requirementsbasedtests;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreLikePost extends WEAreBaseTest {


    @BeforeMethod
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }


    @Test
    public void likePost() {

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
