package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.MenuPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuComponentBase extends AbstractUIObject {


    public HeaderMenuComponentBase(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract CartPageBase clickOnCartBtn();
    public abstract MenuPageBase clickOnMenuBtn();
}
