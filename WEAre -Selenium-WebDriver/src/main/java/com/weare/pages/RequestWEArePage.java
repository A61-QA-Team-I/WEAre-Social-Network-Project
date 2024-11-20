package com.weare.pages;

import com.testData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestWEArePage extends BaseWEArePage {


    private final By seeProfile =By.xpath("//h2[@class='mr-3 text-black' and text()='" + TestData.getSecondRegisteredName() + "']");
    private final By submitLinkLocator = By.xpath("//input[@value='connect']");
    private final By titleLinkLocator = By.xpath("//div[text()='Good job! You have send friend request!']");
    private final By approveLinkLocator = By.cssSelector("form.search-job input.btn-primary[type='submit']");
    private final By personalProfLinkLocator = By.xpath("//a[normalize-space(text())='Personal Profile']");
    private final By approveLocator = By.cssSelector("input.btn.btn-primary[value='Approve Request']");
    private final By approveTextLocator = By.cssSelector("h3.mb-3.bread");




    public RequestWEArePage() {
        super("/search?searchParam1=&searchParam2=&index=0&size=10");
    }


    public void sendRequest() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(seeProfile));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         submitButton = wait.until(ExpectedConditions.elementToBeClickable(seeProfile));
        submitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement connectBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(submitLinkLocator));

        connectBtn = wait.until(ExpectedConditions.elementToBeClickable(submitLinkLocator));

        connectBtn.click();

    }


    public String getPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(titleLinkLocator));
        return pageTitle.getText();
    }


    public void approveRequest() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement personalProfile = wait.until(ExpectedConditions.elementToBeClickable(personalProfLinkLocator));
        personalProfile.click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement connectBtn = wait.until(ExpectedConditions.elementToBeClickable(approveLinkLocator));
        connectBtn.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement approvebtn = wait.until(ExpectedConditions.elementToBeClickable(approveLocator));
        approvebtn.click();

    }


    public String getPageApproveTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(approveTextLocator));
        return pageTitle.getText();
    }
}







