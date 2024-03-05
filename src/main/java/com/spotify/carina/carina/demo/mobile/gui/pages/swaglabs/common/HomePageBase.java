package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.CartPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.MenuPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    protected HomePageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isCartIconPresent();

    public abstract void addProductToCart(Integer index);

    public abstract CartPage clickCartBtn();

    public abstract MenuPage clickMenuBtn();

}
