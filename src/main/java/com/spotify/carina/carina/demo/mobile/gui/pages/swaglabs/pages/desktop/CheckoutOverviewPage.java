package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutCompletePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutOverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutOverviewPageBase.class)
public class CheckoutOverviewPage extends CheckoutOverviewPageBase {


    @FindBy(xpath = "//button[@data-test='finish']")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(finishBtn);
    }

    @Override
    public CheckoutCompletePageBase clickFinishBtn() {
        finishBtn.click();
        return initPage(getDriver(), CheckoutCompletePageBase.class);
    }
}
