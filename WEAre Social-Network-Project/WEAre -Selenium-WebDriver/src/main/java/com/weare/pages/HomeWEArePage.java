package com.weare.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomeWEArePage extends BaseWEArePage {

    public HomeWEArePage() {
        super("");
    }



    private final By registerLinkLocator = By.cssSelector("a.nav-link[href='/register']");
    private final By signInLinkLocator = By.cssSelector("a.nav-link[href='/login']");
    private final By titleLinkLocator = By.cssSelector("h1.mb-2");




    public void checkElementVisibility () {

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
}
