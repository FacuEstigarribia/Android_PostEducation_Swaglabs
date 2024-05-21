package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.CheckoutCompletePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutCompletePageBase.class)
public class CheckoutCompletePage extends CheckoutCompletePageBase {


    @FindBy(xpath = "//div[@class='complete-text' and contains(text(), '%s')]")
    private ExtendedWebElement orderDispatchedTxt;

    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private ExtendedWebElement backToHomeBtn;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(orderDispatchedTxt);

    }

    @Override
    public String getOrderBeenDispatchedText(String text) {
        return orderDispatchedTxt.format(text).getText();
    }
}
