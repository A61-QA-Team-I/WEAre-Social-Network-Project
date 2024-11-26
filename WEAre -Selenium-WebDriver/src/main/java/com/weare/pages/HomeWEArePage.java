package com.weare.pages;

import com.testData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomeWEArePage extends BaseWEArePage {

    public HomeWEArePage() {
        super("");
    }


    private final By registerLinkLocator = By.cssSelector("a.nav-link[href='/register']");
    private final By signInLinkLocator = By.cssSelector("a.nav-link[href='/login']");
    private final By titleLinkLocator = By.cssSelector("h1.mb-2");
    private final By searchBoxLinkLocator = By.id("searchParam2");
    private final By searchPageTextLocator = By.cssSelector("h3.mb-3.bread");


    public void checkElementVisibility() {

        WebElement Register = driver().findElement(registerLinkLocator);
        boolean isVisibleRegister = Register.isDisplayed();


        WebElement SignIn = driver().findElement(signInLinkLocator);
        boolean isVisibleSignIn = SignIn.isDisplayed();

    }


    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }


    public String getPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(titleLinkLocator));
        return pageTitle.getText();
    }


    public void searchUser() {


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchBoxLinkLocator))
                .sendKeys(TestData.getSecondRegisteredName() + Keys.ENTER);

    }


    public void searchUserByEmail() {


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(searchBoxLinkLocator))
                .sendKeys(TestData.getValidEmail() + Keys.ENTER);

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
