package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.LoginPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.WebviewPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.DrawingPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.MenuPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.WebviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == 'LOGOUT'`]")
    private ExtendedWebElement logoutBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == 'WEBVIEW'`]")
    private ExtendedWebElement webviewBtn;

    @ExtendedFindBy(iosPredicate = "label == 'DRAWING' AND name == 'test-DRAWING'")
    private ExtendedWebElement drawingBtn;

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
        drawingBtn.click();
        return initPage(getDriver(), DrawingPageBase.class);
    }
}
