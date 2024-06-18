package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListComponent extends ProductListComponentBase {

    @FindBy(xpath = "//*[@content-desc='test-PRODUCTS']/..")
    private ExtendedWebElement productsList;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[%s]")
    private ExtendedWebElement productByIndex;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void addProductToCart(Integer index){
        productByIndex.format(index).click();
    }
}
