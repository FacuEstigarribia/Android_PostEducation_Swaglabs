package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.MenuPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {



    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCartIconPresent() {
        return false;
    }

    @Override
    public void addProductToCart(Integer index) {

    }

    @Override
    public CartPageBase clickCartBtn() {
        return null;
    }

    @Override
    public MenuPage clickMenuBtn() {
        return null;
    }
}
