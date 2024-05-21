package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.desktop.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageHeaderComponent extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='header_label']")
    private ExtendedWebElement headerLabelComponent;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private ExtendedWebElement cartIcon;

    public HomePageHeaderComponent(WebDriver driver, SearchContext searchContext) {

        super(driver, searchContext);
    }

}
