package wearetests.core;

import com.weare.pages.BaseWEArePage;
import com.weare.pages.HomeWEArePage;
import com.weare.pages.LoginWEArePage;
import com.weare.pages.RegisterWEArePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;



public class WEAreBaseTest extends BaseWebTest {



    protected BaseWEArePage baseWEArePage;
    protected HomeWEArePage homeWEArePage;
    protected RegisterWEArePage registerWEArePage;
    protected LoginWEArePage loginWEArePage;






    @BeforeEach
    public void beforeTests() {

        baseWEArePage = new BaseWEArePage();
        homeWEArePage = new HomeWEArePage();
        registerWEArePage = new RegisterWEArePage();
        loginWEArePage = new LoginWEArePage();

        driver().get(PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl"));
    }

    @BeforeAll
    public static void beforeAll() {
    }

    @AfterEach
    public void afterTest() {
        driver().close();
    }

    @AfterAll
    public static void afterAll() {

        //logout
    }
}

