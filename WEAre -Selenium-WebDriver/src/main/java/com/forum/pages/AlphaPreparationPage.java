package com.forum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlphaPreparationPage extends BaseStageForumPage {


    public AlphaPreparationPage() {
        super("/t/alpha-61-qa-we-are-awesome-and-great/");
    }


    private final By listAreaLocator = By.id("list-area");
    private final By createButtonLocator = By.cssSelector("button.widget-button.btn-flat.reply.create.fade-out.btn-icon-text");
    private final By textAreaLocator = By.cssSelector(".d-editor-input");
    private final By createReplyButtonLocator = By.cssSelector("div.save-or-cancel button" +
            ".btn.btn-icon-text.btn-primary.create");

    public static final String titleComment = "Hi, I am Ivan , and I did it";
    public static final String textEmojiComment = " :smile: :partying_face: :beers: :see_no_evil: :hear_no_evil: :speak_no_evil: :heart:";
    private final By repliesCountLocator = By.cssSelector(".topic-map .replies .number");



    private int initialRepliesCount;



    public void checkElementVisibility() {

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(listAreaLocator));

    }


    public void addReplyToTopic () {

        initialRepliesCount = getRepliesCount();


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createButtonLocator)).click();


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(textAreaLocator))
                .sendKeys(titleComment + textEmojiComment);


        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createReplyButtonLocator));
        driverWait().until(ExpectedConditions.elementToBeClickable(createReplyButtonLocator)).click();


    }
    public int getRepliesCount() {
        WebElement repliesElement = driverWait().until(ExpectedConditions.visibilityOfElementLocated(repliesCountLocator));
        String repliesText = repliesElement.getText();
        return Integer.parseInt(repliesText);
    }


    public boolean validateCommentIsVisible () {

        int newRepliesCount = getRepliesCount();

        if (newRepliesCount > initialRepliesCount) {
            System.out.println("Post was successfully created!");
            return true;
        } else {
            System.out.println("Post creation failed.");
            return false;
        }
    }
}