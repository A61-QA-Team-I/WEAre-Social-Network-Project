package wearetests.core;

import com.testData.TestData;
import com.weare.pages.*;
import org.junit.jupiter.api.*;
import testframework.core.BaseWebTest;



public class WEAreBaseTest extends BaseWebTest {


    private static boolean isUserRegistered = false;
    protected BaseWEArePage baseWEArePage;
    protected HomeWEArePage homeWEArePage;
    protected static RegisterWEArePage registerWEArePage;
    protected LoginWEArePage loginWEArePage;
    protected CreatePostPage createPostPage;
    protected LikePostWEArePage likePostPage;
    protected RequestWEArePage requestWEArePage;


    @BeforeAll
    public static void setupSharedUser() {
        if (!isUserRegistered) {
            registerWEArePage = new RegisterWEArePage();

            registerWEArePage.navigate();
            registerWEArePage.submitRegisterForm(TestData.getRegisteredName(), TestData.getEmail(),
                    TestData.getPassword(),
                    TestData.getConfPassword()
            );

            registerWEArePage.navigate();
            registerWEArePage.submitRegisterForm(TestData.getSecondRegisteredName(), TestData.getSecondEmail(),
                    TestData.getSecondPassword(),
                    TestData.getSecondConfPassword()
            );

            isUserRegistered = true;
        }
    }



    @BeforeEach
    public void beforeTests() {
        baseWEArePage = new BaseWEArePage();
        homeWEArePage = new HomeWEArePage();
        loginWEArePage = new LoginWEArePage();
        createPostPage = new CreatePostPage();
        likePostPage = new LikePostWEArePage();
        requestWEArePage = new RequestWEArePage();

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