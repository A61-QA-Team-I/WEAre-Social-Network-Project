package wearetests.core;

import com.testData.TestData;
import com.weare.pages.*;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.core.BaseWebTest;


public class WEAreBaseTest extends BaseWebTest {


    protected BaseWEArePage baseWEArePage;
    protected HomeWEArePage homeWEArePage;
    protected static RegisterWEArePage registerWEArePage;
    protected LoginWEArePage loginWEArePage;



    @BeforeAll
    public static void setupSharedUser() {

            registerWEArePage = new RegisterWEArePage();

            registerWEArePage.navigate();
            registerWEArePage.submitRegisterForm(TestData.getRegisteredName(), TestData.getValidEmail(),
                    TestData.getValidPassword(),
                    TestData.getConfValidPassword());


    }
    protected void addIssueAndLink(String issueId, String taskName, String taskUrl) {
        Allure.link(taskName, taskUrl);
        Allure.issue(issueId, taskUrl);
    }

    @BeforeEach
    public void beforeTests() {
        baseWEArePage = new BaseWEArePage();
        homeWEArePage = new HomeWEArePage();
        loginWEArePage = new LoginWEArePage();


        // driver().get(PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl"));
    }

    @AfterEach
    public void afterTest() {
        driver().close();
    }

    @AfterAll
    public static void afterAll() {
    }
}