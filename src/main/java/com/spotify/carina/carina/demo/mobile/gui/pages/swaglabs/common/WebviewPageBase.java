package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebviewPageBase extends AbstractPage {

    protected WebviewPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void clickGoToSiteBtn();
    public abstract String getErrorMessage();
}
