package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android.HomePage;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    protected LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract HomePageBase login();

    public abstract LoginPageBase failureLogin();

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract HomePage clickLoginBtn();

    public abstract String getErrorMessageLogin();
}
