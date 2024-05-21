package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.MenuPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.HeaderMenuComponentBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends HeaderMenuComponentBase implements ICustomTypePageFactory {

    @FindBy(xpath = "//*[@content-desc='test-Menu']/..")
    private ExtendedWebElement header;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement iconCart;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement menuBtn;

    public HeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase clickOnCartBtn() {
        iconCart.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickOnMenuBtn() {
        menuBtn.click();
        return initPage(getDriver(), MenuPageBase.class);
    }
}
