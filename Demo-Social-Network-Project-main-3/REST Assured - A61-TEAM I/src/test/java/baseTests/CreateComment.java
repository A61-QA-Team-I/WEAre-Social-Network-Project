package baseTests;
import baseSetup.BaseSetup;
import org.testng.annotations.Test;


public class CreateComment extends BaseSetup{


    @Test(priority = 1)
    public void testCreateUser() {

        createUser();
    }


    @Test(priority = 2)
    public void testLogIn() {

       logIn();
    }


    @Test(priority = 3)
    public void testCreatePost() {

        createPost();

    }


    @Test(priority = 4)
    public void testCreateUser2() {

        createUser2();
    }


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
