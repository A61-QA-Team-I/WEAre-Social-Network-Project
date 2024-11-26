package testData;
import testData.UniqueNameGenerator;

public class TestData {

    public  String randomName;
    public  String randomNameUser2;
    public  String firstName;
    public  String lastName;
    public  int userId;
    public  int user2Id;
    public  int postId;
    public  int commentId;
    public  String jsessionId;
    public  String JSESSIONID_USER2;
    public  String requestId;
    public  String content = "Demo title for Post";
    public  String userPassword = "VankoVelchev#";




    public TestData() {
        UniqueNameGenerator generator = UniqueNameGenerator.getInstance();
        this.randomName = generator.generateUniqueName();
        this.randomNameUser2 = generator.generateUniqueName();
        this.firstName = generator.generateUniqueName();
        this.lastName = generator.generateUniqueName();
    }

}
