package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutOverviewPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @FindBy(xpath = "//input[@data-test='firstName']")
    private ExtendedWebElement firstNameFiled;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    private ExtendedWebElement zipCodeField;

    @FindBy(xpath = "//input[@data-test='continue']")
    private ExtendedWebElement continueBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeFirstName(String name) {
        firstNameFiled.type(name);
    }

    @Override
    public void typeLastName(String lastName) {
        lastNameField.type(lastName);
    }

    @Override
    public void typeZipCode(String zipCode) {
        zipCodeField.type(zipCode);
    }

    @Override
    public CheckoutOverviewPageBase clickContinueBtn() {
        continueBtn.click();
        return initPage(getDriver(), CheckoutOverviewPageBase.class);
    }
}
