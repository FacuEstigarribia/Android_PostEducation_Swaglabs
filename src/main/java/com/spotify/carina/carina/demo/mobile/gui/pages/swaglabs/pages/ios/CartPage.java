package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == 'REMOVE'`][2]")
    private ExtendedWebElement removeBtn;

    @ExtendedFindBy(iosPredicate = "label == 'CHECKOUT' AND name == 'test-CHECKOUT'")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(removeBtn);
    }

    @Override
    public void clickRemoveBtn() {
        removeBtn.click();
    }

    @Override
    public CheckoutPageBase clickCheckoutBtn() {
        checkoutBtn.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}
