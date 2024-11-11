package baseSetup;
import io.qameta.allure.Allure;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;
import testData.TestData;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static WEArenetwork.api.tests.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isA;
import static testData.TestData.*;
//import static testData.TestData.requestId;

public class BaseSetup {

    protected TestData testData = new TestData();


    public void createUser() {
        addIssueAndLink("Jira-84", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-84");
        String requestBody = "{"
                + "\"username\": \"" + testData.randomName + "\","
                + "\"password\": \"" + testData.userPassword + "\","
                + "\"confirmPassword\": \"" + testData.userPassword + "\","
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

        assertThat("Response body should contain the randomName", responseBody, containsString("User with name " + testData.randomName));
        assertThat("Response body should confirm creation", responseBody, containsString("was created"));
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        Pattern pattern = Pattern.compile("id (\\d+)");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            testData.userId = Integer.parseInt(matcher.group(1));
            System.out.println("Extracted userId: " +"\u001B[32m" + testData.userId + "\u001B[0m");
        } else {
            System.out.println("User ID not found in response.");
            testData.userId = 0;
        }

        if (testData.userId != 0) {

        } else {
            System.out.println("Failed to extract a valid userId.");
        }

        assertThat("userId should be greater than 0", testData.userId, greaterThan(0));
        assertThat("userId should not be 0", testData.userId, not(equalTo(0)));
    }



    public void logIn() {
        addIssueAndLink("Jira-87", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-87");

        Response response = RestAssured.given()
                .config(RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", testData.randomName)
                .formParam("password", testData.userPassword)
                .when()
                .post(LOGIN_USER_1_ENDPOINT);


        response.prettyPrint();

        testData.jsessionId = response.getCookie("JSESSIONID");

        if (testData.jsessionId != null) {
            System.out.println("\u001B[32m LogIn User 1 \u001B[0m - JSESSIONID: " + testData.jsessionId);
            System.out.println();
        } else {
            System.out.println("JSESSIONID cookie not found.");

            String contentType = response.getHeader("Content-Type");
            assertThat("Response should be HTML", contentType, containsString("text/html"));
            assertThat("Response should contain 'LOGOUT' button",
                    response.getBody().asString(), containsString("LOGOUT"));

        }
    }



    public  void updateUserPersonalInfo() {
        addIssueAndLink("Jira-81", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-81");

        String requestBody = "{"
                + "\"id\": " + testData.userId + ","
                + "\"firstName\": \"" + testData.firstName + "\","
                + "\"lastName\": \"" + testData.lastName + "\","
                + "\"sex\": \"MALE\","
                + "\"birthYear\": \"1876-01-01\","
                + "\"personalReview\": \"\","
                + "\"picture\": \"\","
                + "\"location\": {}"
                + "}";


        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", testData.jsessionId)
                .body(requestBody)
                .when()
                .post(EDIT_USER_ENDPOINT + "/" + testData.userId + "/personal/");


        System.out.println("Update User Personal Info");
        response.prettyPrint();

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        assertThat("Response should contain 'id' as an integer", response.jsonPath().get("id"), instanceOf(Integer.class));
        assertThat("Response should contain 'firstName' as a string", response.jsonPath().get("firstName"), instanceOf(String.class));
        assertThat("Response should contain 'lastName' as a string", response.jsonPath().get("lastName"), instanceOf(String.class));
        assertThat("Response should contain 'sex' as a string", response.jsonPath().get("sex"), instanceOf(String.class));
        assertThat("Response should contain 'birthYear' as a string", response.jsonPath().get("birthYear"), instanceOf(String.class));
        assertThat("Response should contain 'picturePrivacy' as a boolean", response.jsonPath().get("picturePrivacy"), instanceOf(Boolean.class));
        System.out.println();
    }



    public  void createUser2() {
        addIssueAndLink("Jira-83", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-83");

        String requestBody = "{"
                + "\"username\": \"" + testData.randomNameUser2 + "\","
                + "\"password\": \"" + testData.userPassword + "\","
                + "\"confirmPassword\": \"" + testData.userPassword + "\","
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

        assertThat("Response body should contain the randomName", responseBody, containsString("User with name " + testData.randomNameUser2));
        assertThat("Response body should confirm creation", responseBody, containsString("was created"));
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        Pattern pattern = Pattern.compile("id (\\d+)");
        Matcher matcher = pattern.matcher(responseBody);

        if (matcher.find()) {
            testData.user2Id = Integer.parseInt(matcher.group(1));
            System.out.println("Extracted userId: " +"\u001B[32m" + testData.user2Id + "\u001B[0m");

            System.out.println();
        } else {
            System.out.println("User ID not found in response.");
        }
    }


    public void getAllUsers() {
        addIssueAndLink("Jira-82", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-82");

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

        System.out.println("User: " +"\u001B[32m"+ testData.randomName + "\u001B[0m");
        System.out.println("User: " +"\u001B[32m"+ testData.randomNameUser2 + "\u001B[0m");
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

    }



    public void sendRequest () {
        addIssueAndLink("Jira-93", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-93");

        String requestBody = "{"
                + "\"id\": " + testData.user2Id + ","
                + "\"username\": \"\""
                + "}";


        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", testData.jsessionId)
                .body(requestBody)
                .when()
                .post(SEND_REQUEST_ENDPOINT + testData.userId );

        response.prettyPrint();

        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));
        String responseBody = response.getBody().asString();
        assertThat("Response should contain 'send friend request to'",
                responseBody, containsString("send friend request to"));

    }





    public  void logInUser2() {
        addIssueAndLink("Jira-86", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-86");

        Response response = RestAssured.given()
                .config(RestAssured.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("username", testData.randomNameUser2)
                .formParam("password", testData.userPassword)
                .when()
                .post(LOGIN_USER_2_ENDPOINT);


        response.prettyPrint();

        testData.JSESSIONID_USER2 = response.getCookie("JSESSIONID");

        if (testData.JSESSIONID_USER2 != null) {
            System.out.println("\u001B[32m LogIn User 2 \u001B[0m -  JSESSIONID: " + testData.JSESSIONID_USER2);
            System.out.println();
        } else {
            System.out.println("JSESSIONID cookie not found.");

            String contentType = response.getHeader("Content-Type");
            assertThat("Response should be HTML", contentType, containsString("text/html"));
            assertThat("Response should contain 'LOGOUT' button",
                    response.getBody().asString(), containsString("LOGOUT"));

        }
    }


    public  void getRequestUser2 () {
        addIssueAndLink("Jira-94", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-94");

        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", testData.JSESSIONID_USER2)
                .when()
                .get(GET_REQUEST_ENDPOINT + testData.user2Id + "/request/");

        String responseBody = response.getBody().asString();

        testData.requestId = response.jsonPath().getString("[0].id");


        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));
        assertThat("Response should contain 'id'", responseBody, containsString("id"));
        assertThat("Response should contain 'approved'", responseBody, containsString("approved"));
        assertThat("Response should contain 'seen'", responseBody, containsString("seen"));
        assertThat("Response should contain 'timeStamp'", responseBody, containsString("timeStamp"));

        System.out.println("Extracted request ID: " +"\u001B[32m" + testData.requestId + "\u001B[0m");
        System.out.println();

    }


    public void approveRequest() {
        addIssueAndLink("Jira-92", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-92");

        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .cookie("JSESSIONID", testData.JSESSIONID_USER2)
                .formParam("requestId", testData.requestId)
                .when()
                .post(APPROVE_REQUEST_ENDPOINT + testData.user2Id + "/request/approve?requestId=" + testData.requestId);

        response.prettyPrint();

        assertThat("Status code should be 200", response.getStatusCode(), equalTo(200));

        String responseText = response.getBody().asString();
        assertThat("Response should contain the expected friend request format", responseText, containsString("approved request of"));
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();
    }


    public void createPost() {
        addIssueAndLink("Jira-90", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-90");

        boolean isPublic = true;
        File file = new File("src/main/resources/welcome Massage.png");

        Response response = given()
                .header("Content-Type", "multipart/form-data")
                .cookie("JSESSIONID", testData.jsessionId)
                .multiPart("name", testData.randomName)
                .multiPart("public", String.valueOf(isPublic))
                .multiPart("imagefile", file)
                .when()
                .post(CREATE_PUBLIC_POST_USER_1_ENDPOINT +  testData.content + "&name="+ testData.randomName+"&public=true");


        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        String contentType = response.getHeader("Content-Type");
        assertThat("Response should be HTML", contentType, containsString("text/html"));

        Document doc = Jsoup.parse(response.getBody().asString());


        Element postIdElement = doc.selectFirst("input#postId");
        if (postIdElement != null) {
            String postIdValue = postIdElement.attr("value");
            System.out.println("Extracted Post ID: " + "\u001B[32m" + postIdValue + "\u001B[0m");

            try {
                int postId = Integer.parseInt(postIdValue);
                testData.postId = postId;
            } catch (NumberFormatException e) {
                System.out.println("Failed to parse postId as an integer.");
            }
        } else {
            System.out.println("Post ID input element not found in the response.");
        }

        isPublic = doc.select(".position").stream()
                .anyMatch(element -> element.text().contains("Public post: true"));
        assertThat("Post should be marked as public", isPublic, is(true));
        assertThat("Response should contain post title", doc.text(), containsString(testData.content));

        System.out.println("Post with title: "+ "\u001B[32m" + testData.content + "\u001B[0m" + " was created");
        System.out.println();

    }

    public  void deletePost() {
        addIssueAndLink("Jira-103", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-103");

        Response response = given()
                .cookie("JSESSIONID", testData.jsessionId)
                .when()
                .delete(DELETE_POST_ENDPOINT + testData.postId);

        String responseBody = response.getBody().asString();
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        //response.prettyPrint();
        System.out.println("Post with id: " + "\u001B[32m" + testData.postId + "\u001B[0m" + " was deleted");
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();


    }

    public void createCommentPost() {
        addIssueAndLink("Jira-97", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-97");


        String requestBody = "{"
                + "\"commentId\": \"\","
                + "\"postId\": \"" + testData.postId + "\","
                + "\"userId\": \"" +testData.user2Id + "\","
                + "\"content\": \"demo 1\""
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .cookie("JSESSIONID", testData.JSESSIONID_USER2)
                .body(requestBody)
                .when()
                .post(COMMENT_POST_ENDPOINT);


        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        JsonPath jsonResponse = response.jsonPath();

        int commentId = jsonResponse.getInt("commentId");
        assertThat("commentId should be an integer", commentId, instanceOf(Integer.class));

        testData.commentId = commentId;

        assertThat("Response should contain 'commentId'", jsonResponse.get("commentId"), notNullValue());
        assertThat("Response should contain 'content'", jsonResponse.get("content"), notNullValue());
        assertThat("Response should contain 'likes'", jsonResponse.get("likes"), notNullValue());
        assertThat("Response should contain 'date'", jsonResponse.get("date"), notNullValue());
        assertThat("Response should contain 'liked'", jsonResponse.get("liked"), notNullValue());

        System.out.println("Saved Comment ID: \u001B[32m" + commentId + "\u001B[0m");
        System.out.println();

    }


    public void likePost() {
        addIssueAndLink("Jira-100", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-100");

        Response response = given()
                .cookie("JSESSIONID", testData.JSESSIONID_USER2)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("postId", testData.postId)
                .when()
                .post(LIKE_POST_ENDPOINT);


        JsonPath jsonResponse = response.jsonPath();
        assertThat("Status Code should be 200", response.getStatusCode(), equalTo(200));

        assertThat("Response should contain 'commentId'", jsonResponse.get("postId"), notNullValue());
        assertThat("Response should contain 'content'", jsonResponse.get("content"), notNullValue());
        assertThat("Response should contain 'likes'", jsonResponse.get("picture"), notNullValue());
        assertThat("Response should contain 'date'", jsonResponse.get("date"), notNullValue());
        assertThat("Response should contain 'liked'", jsonResponse.get("liked"), notNullValue());

        int commentId = jsonResponse.getInt("postId");
        assertThat("postId should be an integer", commentId, instanceOf(Integer.class));

        boolean likedStatus = jsonResponse.getBoolean("liked");
        assertThat("liked should be true", likedStatus, equalTo(true));

        System.out.println("Liked status: "+ "\u001B[32m" + likedStatus + "\u001B[0m");

    }

    protected void addIssueAndLink(String issueId, String taskName, String taskUrl) {
        Allure.link(taskName, taskUrl);
        Allure.issue(issueId, taskUrl);
    }
}
