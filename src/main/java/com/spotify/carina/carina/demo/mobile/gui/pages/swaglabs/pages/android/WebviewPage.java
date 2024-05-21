package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.WebviewPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WebviewPage extends WebviewPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-GO TO SITE']")
    private ExtendedWebElement goToSiteBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']")
    private ExtendedWebElement errorMessage;
    protected WebviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(goToSiteBtn);
    }

    @Override
    public void clickGoToSiteBtn() {
        goToSiteBtn.click();
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
