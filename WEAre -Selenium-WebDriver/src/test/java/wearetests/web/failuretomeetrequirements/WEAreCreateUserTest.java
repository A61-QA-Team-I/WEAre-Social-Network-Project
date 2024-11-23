package wearetests.web.failuretomeetrequirements;
import com.testData.TestData;
import com.testData.UniqueNameGenerator;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreCreateUserTest extends WEAreBaseTest {


    @Test
    public void createUserWithShortPassword() {

        String uniqueName = UniqueNameGenerator.getInstance().generateUniqueName();

        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(uniqueName, TestData.getValidEmail(),
                TestData.getShortPassword(),
                TestData.getShortConfPassword()
        );

        String actualPageTitle = registerWEArePage.getPasswordErrorTitle();

        Assertions.assertEquals("password must be minimum 8 characters", actualPageTitle, "Page title is not correct.");
    }


    @Test
    public void createUserWithLongUsername() {

        String uniqueSecondName = UniqueNameGenerator.getInstance().generateUniqueName() + "BillyGibbonsTestUser";
        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(uniqueSecondName, TestData.getValidEmail(),
                TestData.getValidPassword(),
                TestData.getConfValidPassword());


         String actualPageTitle = registerWEArePage.getUsernameErrorTitle();
         Assertions.assertEquals("username must be maximum 20 characters", actualPageTitle, "Page title is not correct.");

    }


    @Test
    public void createUserWithExistingEmail() {

        String username = UniqueNameGenerator.getInstance().generateUniqueName();
        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(username, TestData.getValidEmail(),
                TestData.getValidPassword(),
                TestData.getConfValidPassword()
        );


        String actualPageTitle = registerWEArePage.getEmailErrorTitle();
        Assertions.assertEquals("the email already exist", actualPageTitle, "Page title is not correct.");

    }
}

