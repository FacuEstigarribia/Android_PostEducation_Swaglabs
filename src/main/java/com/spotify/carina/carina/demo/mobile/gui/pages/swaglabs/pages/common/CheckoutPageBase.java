package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {
    protected CheckoutPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void typeFirstName(String name);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipCode(String zipCode);

    public abstract CheckoutOverviewPageBase clickContinueBtn();
}
