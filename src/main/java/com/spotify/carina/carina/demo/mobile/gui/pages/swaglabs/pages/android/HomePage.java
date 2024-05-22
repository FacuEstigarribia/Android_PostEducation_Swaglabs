package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.android.HeaderMenuComponent;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.android.ProductListComponent;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.HeaderMenuComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement iconCart;
    @FindBy(xpath = "//*[@content-desc='test-Menu']/..")
    private HeaderMenuComponent headerMenuComponent;

    @FindBy(xpath = "//*[@content-desc='test-PRODUCTS']/..")
    private ProductListComponent productListComponent;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(iconCart);
    }

    @Override
    public boolean isCartIconPresent() {
        return iconCart.isElementPresent();
    }

    public HeaderMenuComponentBase getHeaderMenuComponent(){
        return headerMenuComponent;
    }
    public ProductListComponentBase getProductListComponent(){return productListComponent;}
}
