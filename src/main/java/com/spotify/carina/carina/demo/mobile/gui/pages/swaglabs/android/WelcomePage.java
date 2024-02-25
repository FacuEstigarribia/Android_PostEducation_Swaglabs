package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase implements IMobileUtils {


    @FindBy(id = "email_address")
    private ExtendedWebElement emailField;

    @FindBy(id = "continue_email_bt")
    private ExtendedWebElement continueBtn;

    protected WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeEmail(String email) {
        emailField.type(email);
    }

    @Override
    public PasswordPage clickContinue() {
        continueBtn.click();
        return initPage(getDriver(), PasswordPage.class);
    }
}
