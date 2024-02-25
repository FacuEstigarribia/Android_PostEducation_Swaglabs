package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE , parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(removeBtn);
    }
}
