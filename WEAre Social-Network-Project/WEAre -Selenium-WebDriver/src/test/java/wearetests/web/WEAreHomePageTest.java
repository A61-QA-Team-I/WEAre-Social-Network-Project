package wearetests.web;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

public class WEAreHomePageTest extends WEAreBaseTest {


    @Test
    public void homePage (){

        homeWEArePage.navigate();
        homeWEArePage.assertNavigated();

        homeWEArePage.checkElementVisibility();

        String actualPageTitle = homeWEArePage.getPageTitle();
        Assertions.assertEquals("The Easiest Way to Hack the Crisis", actualPageTitle, "Page title is not correct.");

    }
}
