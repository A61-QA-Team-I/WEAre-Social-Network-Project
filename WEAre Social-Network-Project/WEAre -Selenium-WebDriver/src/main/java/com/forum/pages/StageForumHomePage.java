package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StageForumHomePage extends BaseStageForumPage{


    public StageForumHomePage() {
        super("/categories");
    }

    private final By newTopicButtonLocator = By.id("create-topic");
    private final By sidebarSectionLocator = By.className("sidebar-section-link-content-text");
    private final By currentUserLocator = By.id("current-user");
    private final By userMenuButtonLocator = By.id("user-menu-button-profile");
    private final By logoutButtonLocator = By.className("sidebar-section-link-content-text");


    public void waitForPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sidebarSectionLocator));
    }

    public void checkElementVisibility () {

        WebElement appBox = driver().findElement(newTopicButtonLocator);
        boolean isVisible = appBox.isDisplayed();

    }

    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }

    public void logout() {

        driverWait().until(ExpectedConditions.elementToBeClickable(currentUserLocator));
        driver().findElement(currentUserLocator).click();

        driverWait().until(ExpectedConditions.elementToBeClickable(userMenuButtonLocator));
        driver().findElement(userMenuButtonLocator).click();

        driverWait().until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
        driver().findElement(logoutButtonLocator).click();


    }
}
