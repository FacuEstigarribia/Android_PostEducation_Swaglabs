package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class HomeEmulatorPage extends AbstractPage implements IMobileUtils {


    @FindBy(xpath = "//android.widget.TextView[@content-desc='Predicted app: Pinterest']")
    private ExtendedWebElement pinterestIconApp;
    protected HomeEmulatorPage(WebDriver driver) {
        super(driver);
    }

    public WelcomePage openPinterest(){
        pinterestIconApp.click();
        return initPage(getDriver(), WelcomePage.class);
    }
}
