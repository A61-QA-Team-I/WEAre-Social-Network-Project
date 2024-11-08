package baseTests;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
//import org.junit.Test;
import org.testng.annotations.Test;
import testData.TestData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static testData.TestData.*;
import static WEArenetwork.api.tests.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class FriendRequest {



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
            userId = Integer.parseInt(matcher.group(1));
            System.out.println("Extracted userId: " + userId);
        } else {
            System.out.println("User ID not found in response.");
            userId = 0;
        }

        if (userId != 0) {

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
                .formParam("username", TestData.randomName)
                .formParam("password", "VankoVelchev#")
                .when()
                .post(LOGIN_USER_1_ENDPOINT);


        response.prettyPrint();

        jsessionId = response.getCookie("JSESSIONID");

        if (jsessionId != null) {
            System.out.println("Extracted JSESSIONID: " + jsessionId);
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
            user2Id = Integer.parseInt(matcher.group(1));
            System.out.println("Extracted userId: " + user2Id);
            System.out.println();
        } else {
            System.out.println("User ID not found in response.");
        }
    }



    @Test(priority = 4)
    public void testSendRequest () {

        String requestBody = "{"
                + "\"id\": " + user2Id + ","
                + "\"username\": \"\""
                + "}";


        Response response = given()
              .header("Content-Type", "application/json")
              .cookie("JSESSIONID", jsessionId)
              .body(requestBody)
              .when()
              .post(SEND_REQUEST_ENDPOINT + userId );

        response.prettyPrint();

        String responseBody = response.getBody().asString();
        assertThat("Response should contain 'send friend request to'",
                responseBody, containsString("send friend request to"));

    }



    @Test(priority = 5)
    public void testLogInUser2() {

        Response response = RestAssured.given()
                .config(RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", TestData.randomNameUser2)
                .formParam("password", "VankoVelchev#")
                .when()
                .post(LOGIN_USER_2_ENDPOINT);


        response.prettyPrint();

        JSESSIONID_USER2 = response.getCookie("JSESSIONID");

        if (JSESSIONID_USER2 != null) {
            System.out.println("Extracted JSESSIONID: " + JSESSIONID_USER2);
            System.out.println();
        } else {
            System.out.println("JSESSIONID cookie not found.");

            String contentType = response.getHeader("Content-Type");
            assertThat("Response should be HTML", contentType, containsString("text/html"));
            assertThat("Response should contain 'LOGOUT' button",
                    response.getBody().asString(), containsString("LOGOUT"));

        }
    }



    @Test(priority = 6)
    public void testGetRequestUser2 () {

        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", JSESSIONID_USER2)
                .when()
                .get(GET_REQUEST_ENDPOINT + user2Id + "/request/");

        String responseBody = response.getBody().asString();

         requestId = response.jsonPath().getString("[0].id");

        assertThat("Response should contain 'id'", responseBody, containsString("id"));
        assertThat("Response should contain 'approved'", responseBody, containsString("approved"));
        assertThat("Response should contain 'seen'", responseBody, containsString("seen"));
        assertThat("Response should contain 'timeStamp'", responseBody, containsString("timeStamp"));

        System.out.println("Extracted request ID: " + requestId);
        System.out.println();

    }



    @Test(priority = 7)
    public void testApproveRequest() {

        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .cookie("JSESSIONID", JSESSIONID_USER2)
                .formParam("requestId", requestId)
                .when()
                .post(APPROVE_REQUEST_ENDPOINT + user2Id + "/request/approve?requestId=" + requestId);

        response.prettyPrint();

        assertThat("Status code should be 200", response.getStatusCode(), equalTo(200));

        String responseText = response.getBody().asString();
        assertThat("Response should contain the expected friend request format", responseText, containsString("approved request of"));

    }
}
