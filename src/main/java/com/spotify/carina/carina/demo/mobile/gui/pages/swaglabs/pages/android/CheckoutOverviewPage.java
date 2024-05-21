package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutCompletePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE , parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {


    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'CHECKOUT: OVERVIEW')]")
    private ExtendedWebElement checkoutOverview;
    protected CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutOverview);
    }

    @Override
    public CheckoutCompletePageBase clickFinishBtn() {
        return null;
    }
}
