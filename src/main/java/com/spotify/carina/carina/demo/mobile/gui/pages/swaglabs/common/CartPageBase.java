package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    protected CartPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void clickRemoveBtn();

    public abstract CheckoutPageBase clickCheckoutBtn();
}
