package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.PasswordPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {


    protected WelcomePageBase(WebDriver driver) {
        super(driver);
    }


    public abstract void typeEmail(String email);


    public abstract PasswordPage clickContinue();
}
