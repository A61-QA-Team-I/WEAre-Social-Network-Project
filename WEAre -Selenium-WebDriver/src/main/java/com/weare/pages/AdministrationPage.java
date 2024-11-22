package com.weare.pages;

import com.testData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdministrationPage extends BaseWEArePage{

    private final By seeProfile =By.xpath("//h2[@class='mr-3 text-black' and text()='" + TestData.getSecondRegisteredName() + "']");
    private final By disableBtnProfile = By.xpath("//input[@value='disable']");
    private final By usernameTitleLocator =  By.xpath("//i[contains(text(), 'Wrong username')]");



    public AdministrationPage() {
        super("/search?searchParam1=&searchParam2=&index=0&size=10");
    }

    public void disableProfile() {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(seeProfile)).click();


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(disableBtnProfile)).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
    public String getPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameTitleLocator));
        return pageTitle.getText();
    }
}
