package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.LoginPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.WebviewPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == 'LOGOUT'`]")
    private ExtendedWebElement logoutBtn;
    public MenuPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logoutBtn);
    }

    @Override
    public LoginPage clickLogoutBtn() {
        logoutBtn.click();
        return initPage(getDriver(), LoginPage.class);
    }

    @Override
    public WebviewPage clickWebviewBtn() {
        return null;
    }
}
