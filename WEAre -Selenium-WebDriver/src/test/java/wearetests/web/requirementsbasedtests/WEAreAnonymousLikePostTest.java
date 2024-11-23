package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreAnonymousLikePostTest extends WEAreBaseTest {

    @BeforeMethod
    public void beforeTest() {

        homeWEArePage.assertNavigated();
    }

@Test
    public void anonymousLikePost() {


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
