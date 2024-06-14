package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductListComponentBase extends AbstractUIObject {
    public ProductListComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void addProductToCart(Integer index);
    public abstract void addProductsToCart(List<Integer> indices);
    public abstract String getPriceOfSelectedProduct(Integer index);
    public abstract String getTitleOfSelectedProduct(Integer index);
    public abstract void addProductsToCartStream();
    public abstract void addProductsToCart2(List<String> productName);
}
