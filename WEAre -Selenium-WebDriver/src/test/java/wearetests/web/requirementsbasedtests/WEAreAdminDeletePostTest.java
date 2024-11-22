package wearetests.web.requirementsbasedtests;

import com.testData.TestData;
import com.testData.UniqueNameGenerator;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreAdminDeletePostTest extends WEAreBaseTest {

    @BeforeMethod
    public void beforeTest() {
        homeWEArePage.assertNavigated();

    }

    @Test
    public void adminDeletePost() {


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
