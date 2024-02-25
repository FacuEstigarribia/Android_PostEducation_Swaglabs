package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;


import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    private static final Log LOGGER = LogFactory.getLog(LoginPage.class);
    @FindBy(xpath= "//android.widget.EditText[@content-desc='test-Username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath= "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath =  "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath= "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private ExtendedWebElement errorLoginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginBtn);
    }

    @Override
    public void typeUsername(String username) {
        usernameField.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public HomePage clickLoginBtn() {
        loginBtn.click();
        HomePage homePage = new HomePage(getDriver());
        return homePage;
    }

    @Override
    public String getErrorMessageLogin(){
        String txt = errorLoginMessage.getText();
        LOGGER.info("Error text: " + txt);
        return txt;
    }
}
