package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.android.HeaderMenuComponent;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.HomePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.MenuPageBase;
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

    @FindBy(xpath = "//*[@content-desc='test-Menu']/..")
    private HeaderMenuComponent headerMenuComponent;

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

//    @Override
//    public CartPage clickCartBtn() {
//        iconCart.click();
//        return initPage(getDriver(), CartPage.class);
//    }
//
//    @Override
//    public MenuPageBase clickMenuBtn() {
//        menuBtn.click();
//        return initPage(getDriver(), MenuPageBase.class);
//    }

    public HeaderMenuComponent getHeaderMenuComponent(){
        return headerMenuComponent;
    }
}
