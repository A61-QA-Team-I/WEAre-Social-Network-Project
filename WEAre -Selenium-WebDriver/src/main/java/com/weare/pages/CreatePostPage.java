package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreatePostPage extends BaseWEArePage{


    public static final String postTitle = "Demo post";
    private final By textareaLocator = By.id("message");
    private final By submitBtnLocator = By.xpath("//input[@value='Save post']");
    private final By visibilityBtnLocator = By.id("StringListId");
    private final By postTextLocator =By.xpath("//p[contains(text(), '" + postTitle + "')]");

    private final By explorePostLocator = By.cssSelector("a.btn.btn-primary");
    private final By massageFieldLocator = By.id("message");
    private final By postCommentLocator = By.cssSelector("input[type='submit'][value='Post Comment']");
    private final By commentsElement = By.xpath("//span[@class='position' and contains(text(), 'Comments:')]");



    public CreatePostPage() {
        super("/posts/auth/newPost");
    }



    public void createPost() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));


        WebElement visibility = wait.until(ExpectedConditions.visibilityOfElementLocated(visibilityBtnLocator));
        visibility.sendKeys("Public post");


        WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(textareaLocator));
        textField.sendKeys(postTitle);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitBtnLocator));
        submitButton.click();

    }

    public boolean isPostTextVisible() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        try {
            WebElement postTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(postTextLocator));

            String actualText = postTextElement.getText();
            return actualText.equals(postTitle);
        } catch (Exception e) {
            return false;
        }
    }



    public void createComment() {


        WebElement explorePost = driverWait().until(ExpectedConditions.elementToBeClickable(explorePostLocator));
        explorePost.click();

        WebElement massageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(massageFieldLocator));
        massageTitle.sendKeys("Demo Comment Title");


        WebElement postCommentBtn = driverWait().until(ExpectedConditions.elementToBeClickable(postCommentLocator));
        postCommentBtn.click();

    }

    public int getCommentsCount() {

        WebElement commentsElements = driverWait().until(ExpectedConditions.visibilityOfElementLocated(commentsElement));
        String commentsText = commentsElements.getText();
        return Integer.parseInt(commentsText.replace("Comments: ", "").trim());
    }

//    public void deletePost() {
//
//
//        WebElement explorePost = driverWait().until(ExpectedConditions.elementToBeClickable(explorePostLocator));
//        explorePost.click();
//
//
//
//
//
//
//    }
}
