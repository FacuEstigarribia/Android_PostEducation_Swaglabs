package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {


    @FindBy(xpath = "//button[@data-test='checkout']")
    private ExtendedWebElement checkoutBtn;
    public CartPage(WebDriver driver) {

        super(driver);
        setUiLoadedMarker(checkoutBtn);
    }

    @Override
    public void clickRemoveBtn() {

    }

    @Override
    public CheckoutPageBase clickCheckoutBtn() {
        checkoutBtn.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }
}
