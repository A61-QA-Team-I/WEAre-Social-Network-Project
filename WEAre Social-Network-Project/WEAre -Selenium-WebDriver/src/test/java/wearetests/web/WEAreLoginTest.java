package wearetests.web;

import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;
import wearetests.unums.WEAreTestData;

public class WEAreLoginTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest(){

        //homeWEArePage.assertNavigated();
//        registerWEArePage.navigate();
//        registerWEArePage.submitRegisterForm(WEAreTestData.name.getValue(),WEAreTestData.email.getValue(), WEAreTestData.password.getValue(),WEAreTestData.confPassword.getValue());
    }


    @Test
    public void loginTest () {

        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(WEAreTestData.name.getValue(),WEAreTestData.email.getValue(), WEAreTestData.password.getValue(),WEAreTestData.confPassword.getValue());


        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();

        loginWEArePage.submitLoginForm(TestData.getRegisteredName(),WEAreTestData.password.getValue());

        loginWEArePage.checkElementVisibility();

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        loginWEArePage.logout();



    }

    @Test
    public void loginUser2Test () {

        registerWEArePage.navigate();
        registerWEArePage.submitRegisterUser2Form(WEAreTestData.name.getValue(),WEAreTestData.email.getValue(), WEAreTestData.password.getValue(),WEAreTestData.confPassword.getValue());


        loginWEArePage.navigate();
        loginWEArePage.assertNavigated();

        loginWEArePage.submitLoginUser2Form(TestData.getRegisteredUser2Name(),WEAreTestData.password.getValue());

        loginWEArePage.checkElementVisibility();

        Assertions.assertTrue(loginWEArePage.isLogoutButtonVisible(), "LOGOUT button missing");

        loginWEArePage.logout();



    }
}
