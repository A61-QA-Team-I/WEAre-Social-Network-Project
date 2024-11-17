package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAndLikeSpecificTopicPage extends BaseStageForumPage{


    private final By likeButtonLocator = By.xpath("//button[contains(@class, 'toggle-like')]");
    private final By repliesCountLocator = By.cssSelector(".topic-map .replies .number");



    public OpenAndLikeSpecificTopicPage(){

        super("/t/alpha-61-qa-we-are-awesome-and-great/");
    }


    public void LikeTheTopic () {

        WebElement likeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(likeButtonLocator));


        driver().findElement(repliesCountLocator);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(repliesCountLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(repliesCountLocator));

        driver().scrollToElement(repliesCountLocator);


        String titleAttribute = likeButton.getAttribute("title");
        System.out.println("Current button title: " + titleAttribute);


        if (titleAttribute.equals("like this post")) {


            driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButtonLocator));
            driver().scrollToElement(likeButtonLocator);
            driver().findElement(likeButtonLocator);
            driverWait().until(ExpectedConditions.elementToBeClickable(likeButtonLocator));

            likeButton.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else if (titleAttribute.equals("you've liked this post") || titleAttribute.equals("undo like") || titleAttribute.equals("you liked this post")) {

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(likeButtonLocator));
            driver().scrollToElement(likeButtonLocator);

            driverWait().until(ExpectedConditions.elementToBeClickable(likeButtonLocator));
            likeButton.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("The button has an unexpected title: " + titleAttribute);
        }
    }


    public String getLikeButtonTitle() {
        WebElement likeButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'toggle-like')]")));
        return likeButton.getAttribute("title");
    }


}
