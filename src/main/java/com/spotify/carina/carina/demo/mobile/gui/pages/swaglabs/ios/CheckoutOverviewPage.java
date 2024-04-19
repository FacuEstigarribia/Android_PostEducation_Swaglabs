package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutCompletePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == 'CHECKOUT: OVERVIEW'`]" )
    private ExtendedWebElement checkoutOverviewTitle;
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutOverviewTitle);
    }

    @Override
    public CheckoutCompletePageBase clickFinishBtn() {
        return null;
    }
}
