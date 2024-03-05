package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE , parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {


    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private ExtendedWebElement zipCodeField;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    private ExtendedWebElement continueBtn;

    protected CheckoutPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(zipCodeField);
    }

    @Override
    public void typeFirstName(String name) {
        nameField.type(name);
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
    public CheckoutOverviewPage clickContinueBtn() {
        continueBtn.click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(getDriver());
        return  checkoutOverviewPage;
    }


}
