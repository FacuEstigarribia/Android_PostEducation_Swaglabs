package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.MenuPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements ICustomTypePageFactory {


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
    public CartPage clickCartBtn() {
        cartIcon.click();
        CartPage cartPage = new CartPage(getDriver());
        return cartPage;
    }

    @Override
    public MenuPage clickMenuBtn() {
        return null;
    }
}
