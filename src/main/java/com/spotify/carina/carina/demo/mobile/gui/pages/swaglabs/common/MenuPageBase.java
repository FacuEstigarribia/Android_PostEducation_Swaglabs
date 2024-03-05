package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.LoginPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.WebviewPage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends AbstractPage {
    protected MenuPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract LoginPage clickLogoutBtn();

    public abstract WebviewPage clickWebviewBtn();
}
