package com.forum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class AllTopicsPage extends BaseStageForumPage {

    private final By containerLocator = By.cssSelector("tbody.topic-list-body");
    private final By topicTitleLocator = By.cssSelector("tbody.topic-list-body tr.topic-list-item td" +
            ".main-link a.title.raw-link.raw-topic-link");
    private final By showMoreButtonLocator = By.cssSelector("div.show-more.has-topics");
    private final By titleLinkButtonLocator = By.cssSelector("a.title.raw-link.raw-topic-link");

    private final By moreActionButtonLocator = By.cssSelector("button.widget-button.btn-flat.show-more-actions.no-text.btn-icon");
    private final By deleteTopicButtonLocator = By.cssSelector("button.widget-button.btn-flat.delete.no-text.btn-icon");
    private final By cookieDivLocator = By.cssSelector("div.cooked");

    public AllTopicsPage() {
        super("/latest");
    }

    public boolean validateNewTopicCreated(String expectedTopicTitle) {
        try {
            WebElement showMoreButton;

            try {
                showMoreButton = driverWait().until(ExpectedConditions.visibilityOfElementLocated(showMoreButtonLocator));
                if (showMoreButton.isDisplayed()) {
                    showMoreButton.click();
                    driverWait().until(ExpectedConditions.invisibilityOf(showMoreButton));
                }
            } catch (Exception e1) {
                WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(3));
                try {
                    showMoreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(showMoreButtonLocator));

                    if (showMoreButton.isDisplayed()) {
                        showMoreButton.click();
                        driverWait().until(ExpectedConditions.invisibilityOf(showMoreButton));
                    }
                } catch (TimeoutException e2) {
                    driver().navigate().refresh();
                }
            }

            driverWait().until(ExpectedConditions.visibilityOfElementLocated(containerLocator));

            List<WebElement> topics = driverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan
                    (topicTitleLocator, 0));

            boolean isTopicFound = false;
            for (WebElement topic : topics) {
                String topicText = topic.getText().trim();

                if (topicText.toLowerCase().contains(expectedTopicTitle.toLowerCase().trim())) {
                    System.out.println("New topic found: " + topicText);
                    isTopicFound = true;
                    break;
                }
            }

            if (!isTopicFound) {
                System.out.println("New topic not found.");
            }

            return isTopicFound;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteTopic ( String expectedTopicTitle) {


        try {
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(containerLocator));

            List<WebElement> topics = driverWait().until(ExpectedConditions.numberOfElementsToBeMoreThan
                    (topicTitleLocator, 0));

            boolean isTopicFound = false;

            for (WebElement topic : topics) {
                String topicText = topic.getText().trim();

                if (topicText.toLowerCase().contains(expectedTopicTitle.toLowerCase().trim())) {


                    driverWait().until(ExpectedConditions.visibilityOfElementLocated(titleLinkButtonLocator));
                    driverWait().until(ExpectedConditions.elementToBeClickable(titleLinkButtonLocator)).click();


                    driverWait().until(ExpectedConditions.visibilityOfElementLocated(moreActionButtonLocator));
                    driverWait().until(ExpectedConditions.elementToBeClickable(moreActionButtonLocator)).click();


                    driverWait().until(ExpectedConditions.visibilityOfElementLocated(deleteTopicButtonLocator));
                    driverWait().until(ExpectedConditions.elementToBeClickable(deleteTopicButtonLocator)).click();


                    System.out.println("Topic deleted: " + topicText);
                    isTopicFound = true;
                    break;
                }
            }

            if (!isTopicFound) {
                System.out.println("Topic not found: " + expectedTopicTitle);
            }

            return isTopicFound;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }

    }
    }







