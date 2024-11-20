package com.weare.pages;

import com.testData.TestData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class DeletePostPage extends BaseWEArePage{

    private final By seeProfile = By.xpath("//h2[@class='mr-3 text-black' and text()='" + TestData.getRegisteredName() + "']");
    private final By latestAct = By.xpath("//div[@id='post-container']//a[contains(@class, 'block-20')]");
    private final By TimelineLocator = By.xpath("//h3[@class='heading']/a[text()='Demo post']");





    public DeletePostPage() {
        super("/search?searchParam1=&searchParam2=&index=0&size=10");
    }


    public void deletePost () {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(seeProfile));
        profile = wait.until(ExpectedConditions.elementToBeClickable(seeProfile));
        profile.click();



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement timelineElement = wait.until(ExpectedConditions.visibilityOfElementLocated(TimelineLocator));

        Actions actions = new Actions(driver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();



        WebElement latestPost = wait.until(ExpectedConditions.visibilityOfElementLocated(latestAct));
        latestPost = wait.until(ExpectedConditions.elementToBeClickable(latestAct));
        latestPost.click();


    }
}
