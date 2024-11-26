package com.weare.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseWEArePage extends BaseWebPage {


    public BaseWEArePage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    public BaseWEArePage() {
        super("");

    }

    @Override
    public String getBasePageUrl() {
        return PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl");

    }
}