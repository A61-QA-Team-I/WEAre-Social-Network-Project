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
}
