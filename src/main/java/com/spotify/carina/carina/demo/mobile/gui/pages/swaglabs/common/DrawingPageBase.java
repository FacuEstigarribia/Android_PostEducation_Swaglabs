package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage {
    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawPicture();
}
