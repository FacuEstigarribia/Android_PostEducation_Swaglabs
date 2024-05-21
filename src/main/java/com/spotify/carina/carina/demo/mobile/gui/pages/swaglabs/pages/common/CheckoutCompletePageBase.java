package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutCompletePageBase extends AbstractPage {


    protected CheckoutCompletePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract String getOrderBeenDispatchedText(String text);
}
