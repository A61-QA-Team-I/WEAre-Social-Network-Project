package com.weare.pages;
import com.testData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class DeletePostPage extends BaseWEArePage{

    private final By seeProfile = By.xpath("//h2[@class='mr-3 text-black' and text()='" + TestData.getRegisteredName() + "']");
    private final By latestAct = By.xpath("//div[@id='post-container']//a[contains(@class, 'block-20')]");
    private final By TimelineLocator = By.xpath("//h3[@class='heading']/a[text()='Demo post']");

    private final By explorePostLocator = By.cssSelector("a.btn.btn-primary");
    private final By deletePostLocator = By.xpath("//a[contains(@class, 'btn') and contains(@class, 'btn-primary') and text()='Delete post']");
    private final By deletedConfirmedLocator = By.id("StringListId");
    private final By submitLocator = By.cssSelector("input.btn.py-3.px-4.btn-primary[type='submit'][value='Submit']");
    private final By deletedSuccessfullyTextLocator = By.cssSelector("h1.mb-3.bread");






    public DeletePostPage() {
        super("/search?searchParam1=&searchParam2=&index=0&size=10");
    }


    public void deletePost () {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement explorePost = wait.until(ExpectedConditions.visibilityOfElementLocated(explorePostLocator));
        explorePost = wait.until(ExpectedConditions.elementToBeClickable(explorePostLocator));
        explorePost.click();

        WebElement deletePostBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(deletePostLocator));
        deletePostBtn = wait.until(ExpectedConditions.elementToBeClickable(deletePostLocator));
        deletePostBtn.click();

        WebElement confirmedDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(deletedConfirmedLocator));
        confirmedDelete.sendKeys("Delete post");

        WebElement Submit = wait.until(ExpectedConditions.visibilityOfElementLocated(submitLocator));
        Submit = wait.until(ExpectedConditions.elementToBeClickable(submitLocator));
        Submit.click();


    }

    public String getPageTitle() {

        WebElement pageTitle = driverWait().until(ExpectedConditions.visibilityOfElementLocated(deletedSuccessfullyTextLocator));
        return pageTitle.getText();
    }


}
