package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.MenuPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.HomePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]/XCUIElementTypeOther")
    private ExtendedWebElement cartIcon;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == 'ADD TO CART'`][%s]")
    private ExtendedWebElement addToCartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Menu'`]/XCUIElementTypeOther")
    private ExtendedWebElement menuBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartIcon);
    }

    @Override
    public boolean isCartIconPresent() {

        return cartIcon.isElementPresent();
    }

    @Override
    public void addProductToCart(Integer index) {
        addToCartBtn.format(index).click();
    }

    @Override
    public CartPageBase clickCartBtn() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickMenuBtn() {
         menuBtn.click();
         return initPage(getDriver(), MenuPageBase.class);
    }
}
