package baseTests;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
//import org.junit.Test;
import org.testng.annotations.Test;
import testData.TestData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static WEArenetwork.api.tests.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CreateUsersTestSetup {


@Test(priority = 1)
    public void testCreateUser() {

        String requestBody = "{"
                + "\"username\": \"" + TestData.randomName + "\","
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

    assertThat("Response body should contain the randomName", responseBody, containsString("User with name " + TestData.randomName));
    assertThat("Response body should confirm creation", responseBody, containsString("was created"));
    assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

    Pattern pattern = Pattern.compile("id (\\d+)");
    Matcher matcher = pattern.matcher(responseBody);

    if (matcher.find()) {
        TestData.userId = Integer.parseInt(matcher.group(1));
        System.out.println("Extracted userId: " + TestData.userId);
    } else {
        System.out.println("User ID not found in response.");
        TestData.userId = 0;
    }

    if (TestData.userId != 0) {

    } else {
        System.out.println("Failed to extract a valid userId.");
    }

    assertThat("userId should be greater than 0", TestData.userId, greaterThan(0));
    assertThat("userId should not be 0", TestData.userId, not(equalTo(0)));
}



    @Test(priority = 2)
    public void testLogIn() {

        Response response = RestAssured.given()
                .config(RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", TestData.randomName)
                .formParam("password", "VankoVelchev#")
                .when()
                .post(LOGIN_USER_1_ENDPOINT);


        response.prettyPrint();

        TestData.jsessionId = response.getCookie("JSESSIONID");

        if (TestData.jsessionId != null) {
            System.out.println("Extracted JSESSIONID: " + TestData.jsessionId);
            System.out.println();
        } else {
            System.out.println("JSESSIONID cookie not found.");

            String contentType = response.getHeader("Content-Type");
            assertThat("Response should be HTML", contentType, containsString("text/html"));
            assertThat("Response should contain 'LOGOUT' button",
                    response.getBody().asString(), containsString("LOGOUT"));

        }
    }



    @Test(priority = 3)
    public void testUpdateUserPersonalInfo() {

        String requestBody = "{"
                + "\"id\": " + TestData.userId + ","
                + "\"firstName\": \"" + TestData.firstName + "\","
                + "\"lastName\": \"" + TestData.lastName + "\","
                + "\"sex\": \"MALE\","
                + "\"birthYear\": \"1876-01-01\","
                + "\"personalReview\": \"\","
                + "\"picture\": \"\","
                + "\"location\": {}"
                + "}";


        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", TestData.jsessionId)
                .body(requestBody)
                .when()
                .post(EDIT_USER_ENDPOINT + "/" + TestData.userId + "/personal/");



        response.prettyPrint();

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));
        assertThat("Response should contain 'id' as an integer", response.jsonPath().get("id"), instanceOf(Integer.class));
        assertThat("Response should contain 'firstName' as a string", response.jsonPath().get("firstName"), instanceOf(String.class));
        assertThat("Response should contain 'lastName' as a string", response.jsonPath().get("lastName"), instanceOf(String.class));
        assertThat("Response should contain 'sex' as a string", response.jsonPath().get("sex"), instanceOf(String.class));
        assertThat("Response should contain 'birthYear' as a string", response.jsonPath().get("birthYear"), instanceOf(String.class));
        assertThat("Response should contain 'picturePrivacy' as a boolean", response.jsonPath().get("picturePrivacy"), instanceOf(Boolean.class));
        System.out.println();
    }



    @Test(priority = 4)
    public void testCreateUser2() {

        String requestBody = "{"
                + "\"username\": \"" + TestData.randomNameUser2 + "\","
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

        assertThat("Response body should contain the randomName", responseBody, containsString("User with name " + TestData.randomNameUser2));
        assertThat("Response body should confirm creation", responseBody, containsString("was created"));
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        Pattern pattern = Pattern.compile("id (\\d+)");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            TestData.user2Id = Integer.parseInt(matcher.group(1));
            System.out.println("Extracted userId: " + TestData.user2Id);
            System.out.println();
        } else {
            System.out.println("User ID not found in response.");
        }
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

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        assertThat("Response should contain 'userId'", responseBody, containsString("userId"));
        assertThat("Response should contain 'username'", responseBody, containsString("username"));
        assertThat("Response should contain 'category'", responseBody, containsString("category"));

        Integer userId = response.jsonPath().getInt("[0].userId");
        assertThat("userId should be an integer", userId, isA(Integer.class));

        String username = response.jsonPath().getString("[0].username");
        assertThat("username should be a string", username, isA(String.class));

        System.out.println("User: " + TestData.randomName );
        System.out.println("User: " + TestData.randomNameUser2);

    }
}
