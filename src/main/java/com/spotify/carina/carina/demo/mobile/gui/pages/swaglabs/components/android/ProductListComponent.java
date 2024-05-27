package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListComponent extends ProductListComponentBase {

    private static final Log LOGGER = LogFactory.getLog(ProductListComponent.class);
    private static final String MAIN_LOCATOR = "//*[@content-desc='test-PRODUCTS']/..";
    @FindBy(xpath = MAIN_LOCATOR)
    private ExtendedWebElement productsList;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[%s]")
    private ExtendedWebElement productByIndex;
    @FindBy(xpath = "(//android.widget.TextView[@content-desc='test-Item title'])[%s]")
    private ExtendedWebElement titleOfProduct;

    @FindBy(xpath = "(//android.widget.TextView[@content-desc='test-Price'])[%s]")
    private ExtendedWebElement priceOfProduct;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void addProductToCart(Integer index){
        productByIndex.format(index).click();
    }

    @Override
    public String getPriceOfSelectedProduct(Integer index) {
        String price = priceOfProduct.format(index).getText();
        LOGGER.info("Price: " + price);
        return price;
    }

    @Override
    public String getTitleOfSelectedProduct(Integer index) {
        String title = titleOfProduct.format(index).getText();
        LOGGER.info("Title: " + title);
        return title;
    }
}
