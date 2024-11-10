package baseTests;
import baseSetup.BaseSetup;
import org.testng.annotations.Test;



public class CreatePost extends BaseSetup{


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
    public void testDeletePost() {

     deletePost();

    }
}
