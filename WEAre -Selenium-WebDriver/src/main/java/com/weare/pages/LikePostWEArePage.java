package com.weare.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LikePostWEArePage extends BaseWEArePage {


    private final By likeBtnLocator = By.xpath("//input[@value='Like']");
    private final By disLikeBtnLocator = By.xpath("//input[@value='Dislike']");



    public LikePostWEArePage() {
        super("/posts#");
    }


    public boolean likePost() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(2));

        try {
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(likeBtnLocator));

            if (submitButton.isEnabled()) {
                submitButton.click();
                return true;
            } else {
                return false;
            }
        } catch (TimeoutException e) {
            return false;
        }


    }


    public String getLikeButtonValue() {

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        WebElement likeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(disLikeBtnLocator));
        return likeButton.getAttribute("value");
    }
}
