package baseTests;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
//import org.junit.Test;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;
import testData.TestData;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static testData.TestData.*;
import static WEArenetwork.api.tests.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreatePost {



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
    public void testCreatePost() {

        boolean isPublic = true;
        File file = new File("src/main/resources/welcome Massage.png");

        Response response = given()
                .header("Content-Type", "multipart/form-data")
                .cookie("JSESSIONID", TestData.jsessionId)
                .multiPart("content", content)
                .multiPart("name", TestData.randomName)
                .multiPart("public", String.valueOf(isPublic))
                .multiPart("imagefile", file)
                .when()
                .post(CREATE_PUBLIC_POST_USER_1_ENDPOINT +  content + "&name="+randomName+"&public=true");

        //response.prettyPrint();

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        String contentType = response.getHeader("Content-Type");
        assertThat("Response should be HTML", contentType, containsString("text/html"));

        Document doc = Jsoup.parse(response.getBody().asString());

        isPublic = doc.select(".position").stream()
            .anyMatch(element -> element.text().contains("Public post: true"));
        assertThat("Post should be marked as public", isPublic, is(true));
        assertThat("Response should contain post title", doc.text(), containsString(content));

    System.out.println("Post with title: " + content + " was created");

    }
}
