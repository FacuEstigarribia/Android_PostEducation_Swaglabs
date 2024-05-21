package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.HeaderMenuComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CartPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends HeaderMenuComponentBase implements ICustomTypePageFactory {

    @FindBy(xpath = "//div[@data-test='primary-header']")
    private ExtendedWebElement header;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private ExtendedWebElement menuBtn;

    public HeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase clickOnCartBtn() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public MenuPageBase clickOnMenuBtn() {
        menuBtn.click();
        return initPage(getDriver(), MenuPageBase.class);
    }
}
