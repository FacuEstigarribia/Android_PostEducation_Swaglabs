package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListComponent extends ProductListComponentBase {

    @FindBy(xpath = "//div[@data-test='inventory-list']")
    private ExtendedWebElement productsList;
    @FindBy(xpath = "//div[@class='inventory_item'][%s]//button[contains(@class, btn)]")
    private ExtendedWebElement addToCartBtnOfSelectedProduct;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void addProductToCart(Integer index) {
        addToCartBtnOfSelectedProduct.format(index).click();
    }
}
