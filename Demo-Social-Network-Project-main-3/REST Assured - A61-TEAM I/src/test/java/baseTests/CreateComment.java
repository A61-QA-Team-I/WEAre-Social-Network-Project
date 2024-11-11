package baseTests;

import baseSetup.BaseSetup;
import io.qameta.allure.*;
import org.testng.annotations.Test;


public class CreateComment extends BaseSetup {


    @Severity(SeverityLevel.CRITICAL)
    @Feature("User Management")
    @Test(priority = 1)
    public void testCreateUser() {

        createUser();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void testLogIn() {

        logIn();
    }

    @Test(priority = 3)
    public void testCreatePost() {

        createPost();

    }


    @Severity(SeverityLevel.CRITICAL)
    @Feature("User Management")
    @Test(priority = 4)
    public void testCreateUser2() {

        createUser2();
    }


    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void testLogInUser2() {

        logInUser2();
    }


    @Test(priority = 6)
    public void testCreateCommentPost() {

        createCommentPost();

    }


    @Test(priority = 7)
    public void testDeletePost() {

        deletePost();
    }

}
