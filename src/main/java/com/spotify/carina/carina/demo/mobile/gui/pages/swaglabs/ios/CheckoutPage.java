package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutOverviewPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @ExtendedFindBy (iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-First Name'`]")
    private ExtendedWebElement nameField;

    @ExtendedFindBy (iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Last Name'`]")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Zip/Postal Code'`]")
    private ExtendedWebElement zipCodeField;


    @ExtendedFindBy (iosPredicate = "label == 'CONTINUE' AND name == 'test-CONTINUE'")
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
    public CheckoutOverviewPageBase clickContinueBtn() {
        continueBtn.click();
        return initPage(getDriver(), CheckoutOverviewPageBase.class);
    }
}
