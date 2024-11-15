package wearetests.web;

import org.junit.jupiter.api.*;
import wearetests.core.WEAreBaseTest;
import wearetests.unums.WEAreTestData;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class WEAreRegisterTest extends WEAreBaseTest {

    @BeforeEach
    public void beforeTest(){

        homeWEArePage.assertNavigated();
        registerWEArePage.navigate();

    }


    @Test
    @Order(1)
    public void createUser () {


//        homeWEArePage.assertNavigated();
//
//        registerWEArePage.navigate();

        registerWEArePage.submitRegisterForm(WEAreTestData.name.getValue(),WEAreTestData.email.getValue(), WEAreTestData.password.getValue(),WEAreTestData.confPassword.getValue());

        String actualPageTitle = registerWEArePage.getPageTitle();
        Assertions.assertEquals("Welcome to our community.", actualPageTitle, "Page title is not correct.");



    }

    @Test
    @Order(2)
    public void createUser2 () {


//        homeWEArePage.assertNavigated();
//
//        registerWEArePage.navigate();

        registerWEArePage.submitRegisterUser2Form(WEAreTestData.name.getValue(),WEAreTestData.email.getValue(), WEAreTestData.password.getValue(),WEAreTestData.confPassword.getValue());

        String actualPageTitle = registerWEArePage.getPageTitle();
        Assertions.assertEquals("Welcome to our community.", actualPageTitle, "Page title is not correct.");



    }
}
