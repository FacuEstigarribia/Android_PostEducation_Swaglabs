package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListComponent extends ProductListComponentBase {

    private static final Log LOGGER = LogFactory.getLog(ProductListComponent.class);
    private static final String MAIN_LOCATOR = "(//div[@data-test='inventory-list'])";
    @FindBy(xpath = MAIN_LOCATOR)
    private ExtendedWebElement productsList;
    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item'][%s]//button[contains(@class, btn)]")
    private ExtendedWebElement addToCartBtnOfSelectedProduct;

    @FindBy(xpath = "//button[contains(@class,btn_primary)]")
    private ExtendedWebElement addProductBtn;
    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item'][%s]//div[@data-test='inventory-item-price']")
    private ExtendedWebElement priceOfSelectedProduct;

    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item'][%s]//div[@data-test='inventory-item-name']")
    private ExtendedWebElement titleOfSelectedProduct;

    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item']")
    private List<ExtendedWebElement> products;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    private List<ExtendedWebElement> nameProducts;

    public ProductListComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void addProductToCart(Integer index) {
        addToCartBtnOfSelectedProduct.format(index).click();
    }

    @Override
    public void addProductsToCart(List<Integer> indices) {
        for(Integer integer : indices){
            addProductToCart(integer);
        }
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

    @Override
    public void addProductsToCartStream() {
        String productName = "Sauce Labs Bike Light";

        // Find the product element by name
        ExtendedWebElement productElement = products.stream()
                .filter(p -> {
                    ExtendedWebElement nameElement = p.findExtendedWebElement(By.xpath(".//div[@data-test='inventory-item-name']"));
                    return nameElement != null && nameElement.getText().equals(productName);
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

        // Find the 'Add to Cart' button within the product element and click it
        ExtendedWebElement addToCartButton = productElement.findExtendedWebElement(By.xpath(".//button[contains(@class, 'btn')]"));
        addToCartButton.click();
    }

    @Override
    public void addProductsToCart2(List<String> productNames) {
        productNames.forEach(productName -> {
            ExtendedWebElement productElement = products.stream()
                    .filter(p -> {
                        ExtendedWebElement nameElement = p.findExtendedWebElement(By.xpath(".//div[@data-test='inventory-item-name']"));
                        return nameElement != null && nameElement.getText().equals(productName);
                    })
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

            ExtendedWebElement addToCartButton = productElement.findExtendedWebElement(By.xpath(".//button[contains(@class, 'btn')]"));
            addToCartButton.click();
        });
    }



}
