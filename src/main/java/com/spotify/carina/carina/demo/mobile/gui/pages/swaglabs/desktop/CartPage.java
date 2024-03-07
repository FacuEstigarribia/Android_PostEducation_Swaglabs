package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.CheckoutPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickRemoveBtn() {

    }

    @Override
    public CheckoutPage clickCheckoutBtn() {
        return null;
    }
}
