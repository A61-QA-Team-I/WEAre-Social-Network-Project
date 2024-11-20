package com.weare.pages;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditUserWEArePage extends BaseWEArePage{

    public static final String FIRST_NAME = "Billy";
    public static final String LAST_NAME = "Gibbons";
    public static final String BIRTH_DAY = "25/11/1965";
    private final By personalProfLinkLocator = By.xpath("//a[normalize-space(text())='Personal Profile']");
    private final By editProfileLinkLocator = By.xpath("//a[contains(@class, 'nav-link') and contains(text(), 'edit')]");
    private final By firstNameLinkLocator = By.id("nameE");
    private final By lastNameLinkLocator = By.id("lastnameE");
    private final By birthDayLinkLocator = By.id("birthDayE");
    private final By submitBtnLinkLocator = By.xpath("//button[@name='submit']");
    private final By profileHomeLinkLocator = By.id("list-front-list");

    private final String editName = FIRST_NAME + " " + LAST_NAME;

    @Getter
    private final By nameTextLocator = By.xpath("//p[text()='" + editName + "']");


    @Getter
    private final String expectedName = FIRST_NAME + " " + LAST_NAME;


    public EditUserWEArePage() {
        super("");
    }


    public void editUserInfo() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement personalProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(personalProfLinkLocator));
        personalProfile.click();

        WebElement editProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileLinkLocator));
        editProfile.click();



        driverWait().until(ExpectedConditions.visibilityOfElementLocated(firstNameLinkLocator)).sendKeys(FIRST_NAME);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(lastNameLinkLocator)).sendKeys(LAST_NAME);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(birthDayLinkLocator)).sendKeys(BIRTH_DAY);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(submitBtnLinkLocator)).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(profileHomeLinkLocator)).click();

    }

        public String getName() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

                WebElement nameElement = driver().findElement(nameTextLocator);
                return nameElement.getText();
            }
}