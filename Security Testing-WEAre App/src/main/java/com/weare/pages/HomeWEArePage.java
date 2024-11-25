package com.weare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomeWEArePage extends BaseWEArePage {

    public HomeWEArePage() {
        super("");
    }


    private final By titleLinkLocator = By.cssSelector("h1.mb-2");
    private final By searchPageTextLocator = By.cssSelector("h3.mb-3.bread");


    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }


    public String getPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(titleLinkLocator));
        return pageTitle.getText();
    }


    public boolean isTitleNotPresent() {
        try {
            WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchPageTextLocator));
            return !pageTitle.isDisplayed();
        } catch (NoSuchElementException e) {

            return true;
        }
    }
}
