package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.HeaderMenuComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop.HeaderMenuComponent;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop.ProductListComponent;
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

    @FindBy(xpath = "//div[@data-test='inventory-list']")
    private ProductListComponent productListComponent;
    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private ExtendedWebElement cartIcon;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartIcon);
    }

    @Override
    public boolean isCartIconPresent() {
        return false;
    }

    @Override
    public HeaderMenuComponentBase getHeaderMenuComponent() {
        return headerMenuComponent;
    }

    @Override
    public ProductListComponentBase getProductListComponent(){return productListComponent;}

}
