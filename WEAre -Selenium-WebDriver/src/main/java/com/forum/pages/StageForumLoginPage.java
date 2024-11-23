package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StageForumLoginPage extends BaseStageForumPage{


    private final By emailLocator = By.id("Email");
    private final By passwordLocator = By.id("Password");
    private final By submitButtonLocator = By.id("next");



    public StageForumLoginPage() {
        super("/login");
    }

    public void submitLoginForm(String email, String password) {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement emailButton = wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        emailButton.sendKeys(email);

        WebElement passwordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordButton.sendKeys(password);

         WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }


    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }
}
