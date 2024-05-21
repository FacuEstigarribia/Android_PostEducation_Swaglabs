package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop.HeaderMenuComponent;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android.MenuPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements ICustomTypePageFactory {

    @FindBy(xpath = "//div[@data-test='primary-header']")
    private HeaderMenuComponent headerMenuComponent;
    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//div[@class='inventory_item'][%s]//button[contains(@class, btn)]")
    private ExtendedWebElement addToCartBtnOfSelectedProduct;
    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartIcon);
    }

    @Override
    public boolean isCartIconPresent() {
        return false;
    }

    @Override
    public void addProductToCart(Integer index) {
        addToCartBtnOfSelectedProduct.format(index).click();
    }

    @Override
    public HeaderMenuComponent getHeaderMenuComponent() {
        return headerMenuComponent;
    }

//    @Override
//    public CartPageBase clickCartBtn() {
//        cartIcon.click();
//        return initPage(getDriver(), CartPageBase.class);
//    }
//
//    @Override
//    public MenuPage clickMenuBtn() {
//        return null;
//    }
}
