package com.weare.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginWEArePage extends BaseWEArePage{

private final By usernameLinkLocator = By.id("username");
private final By passwordLinkLocator = By.id("password");
private final By submitLinkLocator = By.xpath("//input[@value='Login']");
private final By LogoutLinkLocator = By.cssSelector("a.nav-link[href='/logout']");



    public LoginWEArePage() {
        super( "/login");
    }


    public void submitLoginForm (String registeredName, String password) {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement nameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLinkLocator));
        nameButton.sendKeys(registeredName);

        WebElement emailButton = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLinkLocator));
        emailButton.sendKeys(password);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitLinkLocator));
        submitButton.click();

    }


    public void checkElementVisibility () {


        WebElement logout = driver().findElement(LogoutLinkLocator);
        boolean isVisibleSignIn = logout.isDisplayed();

    }


    public boolean isLogoutButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutLinkLocator));
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void logout() {

        driverWait().until(ExpectedConditions.elementToBeClickable(LogoutLinkLocator));
        driver().findElement(LogoutLinkLocator).click();
    }
}
