package baseTests;
import baseSetup.BaseSetup;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;



public class CreatePost extends BaseSetup{

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void testCreateUser() {

      createUser();
    }


@Severity(SeverityLevel.CRITICAL)
@Test(priority = 2)
    public void testLogIn() {

     logIn();
    }


@Test(priority = 3)
    public void testCreatePost() {

     createPost();

    }




@Test(priority = 4)
    public void testDeletePost() {

     deletePost();

    }
}
