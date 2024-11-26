package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class LoginWEArePage extends BaseWEArePage {

    private final By usernameLinkLocator = By.id("username");
    private final By passwordLinkLocator = By.id("password");
    private final By submitLinkLocator = By.xpath("//input[@value='Login']");
    private final By LogoutLinkLocator = By.cssSelector("a.nav-link[href='/logout']");


    public LoginWEArePage() {
        super("/login");
    }


    public boolean attemptLoginWithCommonPasswords(String name, String validEmail, String validPassword, String registeredName) {

        List<String> commonPasswords = Arrays.asList(
                "12345678", "password", "123456789", "123456", "1234567", "qwerty", "abc123", "monkey", "letmein", "127834", "VankoI"
        );

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        for (String password : commonPasswords) {
            try {
                WebElement nameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLinkLocator));
                nameButton.clear();
                nameButton.sendKeys(registeredName);

                WebElement passwordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLinkLocator));
                passwordButton.clear();
                passwordButton.sendKeys(password);

                WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitLinkLocator));
                submitButton.sendKeys(Keys.ENTER);

                if (isLogoutButtonVisible()) {
                    System.out.println("Successful login with password: "+ "\u001B[32m" + password + "\u001B[0m");
                    return true;
                }

            } catch (Exception e) {
                System.out.println("Failed login attempt with password: " + password);
            }
        }

        return false;
    }

    public boolean isLogoutButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(2));

        try {
            WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutLinkLocator));
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {

        driverWait().until(ExpectedConditions.elementToBeClickable(LogoutLinkLocator));
        driver().findElement(LogoutLinkLocator).sendKeys(Keys.ENTER);
    }
}
