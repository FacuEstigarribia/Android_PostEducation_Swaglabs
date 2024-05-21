package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutOverviewPageBase extends AbstractPage {

    public CheckoutOverviewPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }


    public abstract CheckoutCompletePageBase clickFinishBtn();
}
