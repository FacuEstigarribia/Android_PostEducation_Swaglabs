package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.desktop;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.HomePage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.HomePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{


    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@data-test='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@data-test='login-button']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginBtn);
    }

    @Override
    public HomePageBase login() {
        usernameField.type(R.TESTDATA.get("username"));
        passwordField.type(R.TESTDATA.get("password"));
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public LoginPageBase failureLogin() {
        usernameField.type(R.TESTDATA.get("username"));
        passwordField.type(R.TESTDATA.get("bad_password"));
        loginBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
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
    public String getErrorMessageLogin() {
        return  errorMessage.getText();
    }
}
