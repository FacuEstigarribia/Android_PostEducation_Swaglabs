package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.DrawingPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.LoginPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.MenuPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.WebviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
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
    public LoginPageBase clickLogoutBtn() {
        logoutBtn.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public WebviewPageBase clickWebviewBtn() {
        webviewBtn.click();
        return initPage(getDriver(), WebviewPageBase.class);
    }

    @Override
    public DrawingPageBase clickDrawingBtn() {
        return null;
    }


}
