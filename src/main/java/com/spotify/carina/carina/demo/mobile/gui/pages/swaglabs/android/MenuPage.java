package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.MenuPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends MenuPageBase {


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGOUT']")
    private ExtendedWebElement logoutBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-WEBVIEW']")
    private ExtendedWebElement webviewBtn;

    public MenuPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logoutBtn);
    }

    @Override
    public LoginPage clickLogoutBtn() {
        logoutBtn.click();
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    @Override
    public WebviewPage clickWebviewBtn() {
        webviewBtn.click();
        WebviewPage webviewPage = new WebviewPage(getDriver());
        return  webviewPage;
    }


}
