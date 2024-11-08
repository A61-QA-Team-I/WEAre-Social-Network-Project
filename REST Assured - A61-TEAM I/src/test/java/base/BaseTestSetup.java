package base;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
//import org.junit.Test;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static WEArenetwork.api.tests.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTestSetup {

protected static String randomName;
private static String randomNameUser2;
private static int userId;
private static int user2Id;
private static String jsessionId;




@Test(priority = 1)
    public void testCreateUser() {
        List<String> names = Arrays.asList(
                "Alice", "Vanko", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank",
                "Ivy", "Jack", "Armine", "Leo", "Mona", "Nate", "Olivia", "Paul",
                "Quinn", "Rachel", "Steve", "Tina", "Uma", "Vince", "Wendy", "Xander",
                "Yara", "Zane", "Liam", "Noah", "Emma", "Olivia", "Ava", "Sophia"
        );
        Random random = new Random();
        randomName = names.get(random.nextInt(names.size()));

        String requestBody = "{"
                + "\"username\": \"" + randomName + "\","
                + "\"password\": \"VankoVelchev#\","
                + "\"confirmPassword\": \"VankoVelchev#\","
                + "\"email\": \"ivan.velchev@abv.bg\","
                + "\"category\": { \"id\": 157 },"
                + "\"authorities\": [\"ROLE_USER\"]"
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(CREATE_USER_1_ENDPOINT);


    response.prettyPrint();
    String responseBody = response.getBody().asString();

    assertThat("Response body should contain the randomName", responseBody, containsString("User with name " + randomName));
    assertThat("Response body should confirm creation", responseBody, containsString("was created"));
    assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

    Pattern pattern = Pattern.compile("id (\\d+)");
    Matcher matcher = pattern.matcher(responseBody);

    if (matcher.find()) {
        userId = Integer.parseInt(matcher.group(1));
        System.out.println("Extracted userId: " + userId);
    } else {
        System.out.println("User ID not found in response.");
        userId = 0;
    }

    if (userId != 0) {
        System.out.println("Extracted userId: " + userId);
    } else {
        System.out.println("Failed to extract a valid userId.");
    }

    assertThat("userId should be greater than 0", userId, greaterThan(0));


    assertThat("userId should not be 0", userId, not(equalTo(0)));
}

    @Test(priority = 2)
    public void testLogIn() {
        Response response = RestAssured.given()
                .config(RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", randomName)
                .formParam("password", "VankoVelchev#")
                .when()
                .post("http://localhost:8081/authenticate");

        // Проверка на статус кода
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders());
        System.out.println("Response Body: ");
        System.out.println("Extracted JSESSIONID: " + jsessionId);

        response.prettyPrint();

        // Извличане на JSESSIONID бисквитката
        jsessionId = response.getCookie("JSESSIONID");

        if (jsessionId != null) {
            System.out.println("Extracted JSESSIONID: " + jsessionId);
        } else {
            System.out.println("JSESSIONID cookie not found.");


        }
    }
    @Test(priority = 3)
    public void testUpdateUserPersonalInfo() {
        List<String> firstNames = Arrays.asList(
                "Arthur", "Blake", "Cody", "Damian", "Elliot", "Felix", "Gavin", "Harvey",
                "Ian", "Jasper", "Vanko", "Lance", "Marshall", "Nolan", "Orson", "Preston",
                "Quentin", "Armine", "Sawyer", "Tanner", "Ulysses", "Vaughn", "Wesley", "Xander",
                "Yosef", "Zeke", "Anderson", "Bryce", "Clayton", "Derek"
        );

        List<String> lastNames = Arrays.asList(
                "Armstrong", "Bennett", "Carter", "Dixon", "Ellison", "Fletcher", "Grant",
                "Hawkins", "Ingram", "Jefferson", "Keller", "Lambert", "McCarthy", "Nelson",
                "O'Connor", "Patterson", "Quigley", "Reynolds", "Sullivan", "Turner",
                "Underwood", "Vinson", "Waters", "Xiong", "Velchev", "Zimmerman",
                "Adler", "Barron", "Carson", "Stoykova"
        );

        Random random = new Random();
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));


        String requestBody = "{"
                + "\"id\": " + userId + ","
                + "\"firstName\": \"" + firstName + "\","
                + "\"lastName\": \"" + lastName + "\","
                + "\"sex\": \"MALE\","
                + "\"birthYear\": \"1876-01-01\","
                + "\"personalReview\": \"\","
                + "\"picture\": \"\","
                + "\"location\": {}"
                + "}";


        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", jsessionId)
                .body(requestBody)
                .when()
                .post(EDIT_USER_ENDPOINT + "/" + userId + "/personal/");


        System.out.println("Response Body:");
        response.prettyPrint();

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

//        String responseFirstName = response.jsonPath().getString("firstName");
//        String responseLastName = response.jsonPath().getString("lastName");
//        assertThat("First name should match", responseFirstName, equalTo(firstName));
//        assertThat("Last name should match", responseLastName, equalTo(lastName));
    }


    @Test(priority = 4)
    public void testCreateUser2() {
        List<String> names = Arrays.asList(
                "Benjamin", "Catherine", "Daniel", "Ella", "Finn", "Georgia", "Henry", "Isla",
                "Jacob", "Kylie", "Lucas", "Mason", "Nora", "Owen", "Penelope", "Quincy",
                "Riley", "Sophie", "Thomas", "Ursula", "Victor", "Willow", "Xenia", "Yusuf",
                "Zara", "Aiden", "Bella", "Caleb", "Delilah", "Ethan"
        );
        Random random = new Random();
        randomNameUser2 = names.get(random.nextInt(names.size()));

        String requestBody = "{"
                + "\"username\": \"" + randomNameUser2 + "\","
                + "\"password\": \"VankoVelchev#\","
                + "\"confirmPassword\": \"VankoVelchev#\","
                + "\"email\": \"ivan.velchev@abv.bg\","
                + "\"category\": { \"id\": 157 },"
                + "\"authorities\": [\"ROLE_USER\"]"
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(CREATE_USER_2_ENDPOINT);


        response.prettyPrint();
        String responseBody = response.getBody().asString();

        assertThat("Response body should contain the randomName", responseBody, containsString("User with name " + randomNameUser2));
        assertThat("Response body should confirm creation", responseBody, containsString("was created"));
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        Pattern pattern = Pattern.compile("id (\\d+)");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            user2Id = Integer.parseInt(matcher.group(1));
            System.out.println("Extracted userId: " + user2Id);
        } else {
            System.out.println("User ID not found in response.");
        }
        System.out.println("Saved randomName: " + randomNameUser2);
    }



    @Test(priority = 5)
    public void testGetAllUsers() {

        String requestBody = "{"
                + "\"index\": 0,"
                + "\"size\": 10,"
                + "\"searchParam1\": \"\","
                + "\"searchParam2\": \"\""
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(GET_ALL_USERS_ENDPOINT);

        String responseBody = response.getBody().asString();
        response.prettyPrint();
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        assertThat("Response should contain 'userId'", responseBody, containsString("userId"));
        assertThat("Response should contain 'username'", responseBody, containsString("username"));
        assertThat("Response should contain 'category'", responseBody, containsString("category"));

        Integer userId = response.jsonPath().getInt("[0].userId");
        assertThat("userId should be an integer", userId, isA(Integer.class));

        String username = response.jsonPath().getString("[0].username");
        assertThat("username should be a string", username, isA(String.class));
    }




}
