package wearetests.core;
import com.testData.TestData;
import com.weare.pages.*;
import org.junit.jupiter.api.AfterAll;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
    protected DeletePostPage deletePostPage;
    protected EditUserWEArePage editUserWEArePage;



    @BeforeSuite
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



    @BeforeMethod
    public void beforeTests() {
        baseWEArePage = new BaseWEArePage();
        homeWEArePage = new HomeWEArePage();
        loginWEArePage = new LoginWEArePage();
        createPostPage = new CreatePostPage();
        likePostPage = new LikePostWEArePage();
        requestWEArePage = new RequestWEArePage();
        deletePostPage = new DeletePostPage();
        editUserWEArePage = new EditUserWEArePage();

       // driver().get(PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl"));
    }

    @AfterMethod
    public void afterTest() {
        driver().close();
    }

    @AfterAll
    public static void afterAll() {
    }
}