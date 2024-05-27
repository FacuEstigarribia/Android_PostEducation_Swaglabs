package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListComponentBase extends AbstractUIObject {
    public ProductListComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void addProductToCart(Integer index);

    public abstract String getPriceOfSelectedProduct(Integer index);
    public abstract String getTitleOfSelectedProduct(Integer index);
}
