package wearetests.web.failuretomeetrequirements;
import com.testData.TestData;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreCreateUserTest extends WEAreBaseTest {


    @Test
    public void createUser() {



        String actualPageTitle = registerWEArePage.getTitle();

        Assertions.assertEquals("password must be minimum 6 characters", actualPageTitle, "Page title is not correct.");


    }
}