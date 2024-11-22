package wearetests.web.requirementsbasedtests;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreCreateUserTest extends WEAreBaseTest {


    @Test
    public void createUserWithValidCredentials() {

        String actualPageTitle = registerWEArePage.getSuccessfulCreateUserPageTitle();

        Assertions.assertEquals("Welcome to our community.", actualPageTitle, "Page title is not correct.");

    }
}
