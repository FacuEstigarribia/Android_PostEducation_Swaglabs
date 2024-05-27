package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListComponent extends ProductListComponentBase {

    private static final Log LOGGER = LogFactory.getLog(ProductListComponent.class);
    private static final String MAIN_LOCATOR = "(//div[@data-test='inventory-list'])";
    @FindBy(xpath = MAIN_LOCATOR)
    private ExtendedWebElement productsList;
    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item'][%s]//button[contains(@class, btn)]")
    private ExtendedWebElement addToCartBtnOfSelectedProduct;

    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item'][%s]//div[@data-test='inventory-item-price']")
    private ExtendedWebElement priceOfSelectedProduct;

    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item'][%s]//div[@data-test='inventory-item-name']")
    private ExtendedWebElement titleOfSelectedProduct;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void addProductToCart(Integer index) {
        addToCartBtnOfSelectedProduct.format(index).click();
    }

    @Override
    public String getPriceOfSelectedProduct(Integer index) {
        String price = priceOfSelectedProduct.format(index).getText();
        LOGGER.info("Price: " + price);
        return price;
    }

    @Override
    public String getTitleOfSelectedProduct(Integer index) {
        String title = titleOfSelectedProduct.format(index).getText();
        LOGGER.info("Title: " + title);
        return title;
    }
}
