package testData;
import testData.UniqueNameGenerator;

public class TestData {

    public static String randomName= UniqueNameGenerator.getInstance().generateUniqueName();
    public static String randomNameUser2= UniqueNameGenerator.getInstance().generateUniqueName();
    public static String firstName= UniqueNameGenerator.getInstance().generateUniqueName();
    public static String lastName= UniqueNameGenerator.getInstance().generateUniqueName();
    public static int userId;
    public static int user2Id;
    public static String jsessionId;
    public static String JSESSIONID_USER2;
    public static String requestId;
    public static String content = "Demo title for Post";
    ;

}
