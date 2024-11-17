package com.forum.pages;
import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseStageForumPage extends BaseWebPage {


    public BaseStageForumPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    public BaseStageForumPage() {
        super("");

    }


    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("TelerikStageForumBaseUrl");
    }
}
