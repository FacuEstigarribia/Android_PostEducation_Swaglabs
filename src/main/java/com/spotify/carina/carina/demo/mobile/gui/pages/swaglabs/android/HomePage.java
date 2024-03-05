package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement iconCart;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[%s]")
    private ExtendedWebElement productByIndex;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement menuBtn;



    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(iconCart);
    }

    @Override
    public boolean isCartIconPresent() {
        return iconCart.isElementPresent();
    }

    @Override
    public void addProductToCart(Integer index){
        productByIndex.format(index).click();
    }

    @Override
    public CartPage clickCartBtn() {
        iconCart.click();
        CartPage cartPage = new CartPage(getDriver());
        return cartPage;
    }

    @Override
    public MenuPage clickMenuBtn() {
        menuBtn.click();
        MenuPage menuPage = new MenuPage(getDriver());
        return menuPage;
    }


}
