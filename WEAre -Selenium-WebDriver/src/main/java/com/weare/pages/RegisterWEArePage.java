package com.weare.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterWEArePage extends BaseWEArePage {


    private final By nameLinkLocator = By.id("name");
    private final By emailLinkLocator = By.id("email");
    private final By passwordLinkLocator = By.id("password");
    private final By confirmLinkLocator = By.id("confirm");
    private final By submitLinkLocator = By.xpath("//input[@value='Register']");
    private final By createUserLoginTitleLocator =  By.cssSelector("h1.mb-3");
    private final By TitleLocator =  By.xpath("//i[contains(text(), 'password must be minimum 6 characters')]");



    public RegisterWEArePage() {
        super("/register");
    }


    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }


    public void submitRegisterForm(String name, String email, String password, String confPassword ) {


        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement nameButton = wait.until(ExpectedConditions.visibilityOfElementLocated(nameLinkLocator));
        nameButton.sendKeys(name);

        WebElement emailButton = wait.until(ExpectedConditions.visibilityOfElementLocated(emailLinkLocator));
        emailButton.sendKeys(email);

        WebElement passButton = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLinkLocator));
        passButton.sendKeys(password);

        WebElement passConfButton = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmLinkLocator));
        passConfButton.sendKeys(confPassword);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitLinkLocator));
        submitButton.click();

    }


    public String getPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(createUserLoginTitleLocator));
        return pageTitle.getText();

    }
    public String getTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(TitleLocator));
        return pageTitle.getText();

    }


}
