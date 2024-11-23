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
    private final By passwordTitleLocator =  By.xpath("//i[contains(text(), 'password must be minimum 8 characters')]");
    private final By usernameTitleLocator =  By.xpath("//i[contains(text(), 'username must be maximum 20 characters')]");
    private final By emailTitleLocator =  By.xpath("//i[contains(text(), 'the email already exist')]");



    public RegisterWEArePage() {
        super("/register");
    }


    public void assertNavigated() {

        String actualUrl = driver().getCurrentUrl();

    }


    public void submitRegisterForm(String name, String email, String password, String confPassword ) {


        //WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement nameButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(nameLinkLocator));
        nameButton.sendKeys(name);

        WebElement emailButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(emailLinkLocator));
        emailButton.sendKeys(email);

        WebElement passButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordLinkLocator));
        passButton.sendKeys(password);

        WebElement passConfButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(confirmLinkLocator));
        passConfButton.sendKeys(confPassword);

        WebElement submitButton = driverWait().until(ExpectedConditions.elementToBeClickable(submitLinkLocator));
        submitButton.click();

    }


    public String getSuccessfulCreateUserPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(createUserLoginTitleLocator));
        return pageTitle.getText();

    }
    public String getPasswordErrorTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(2));

        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTitleLocator));
        return pageTitle.getText();

    }

    public String getUsernameErrorTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(2));

        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTitleLocator));
        return pageTitle.getText();

    }

    public String getEmailErrorTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(2));

        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTitleLocator));
        return pageTitle.getText();

    }


}
