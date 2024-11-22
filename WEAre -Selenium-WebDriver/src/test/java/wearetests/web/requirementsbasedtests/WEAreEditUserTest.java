package wearetests.web.requirementsbasedtests;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreEditUserTest extends WEAreBaseTest {




    @Test
    public void editUserInfoTest(){

        loginWEArePage.navigate();
        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),TestData.getValidPassword());

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button is missing.");


        editUserWEArePage.navigate();
        editUserWEArePage.editUserInfo();

        String actualName = editUserWEArePage.getName();
        String expectedName = editUserWEArePage.getExpectedName();

        Assertions.assertEquals(expectedName, actualName, "The profile name does not match!");

        likePostPage.navigate();
        likePostPage.likePost();


    }
}
