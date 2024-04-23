package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.WebviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebviewPageBase.class)
public class WebviewPage extends WebviewPageBase {

    @ExtendedFindBy(iosPredicate = "label == 'GO TO SITE' AND name == 'test-GO TO SITE'")
    private ExtendedWebElement goToSiteBtn;

    @ExtendedFindBy(iosPredicate = "label == 'Please provide a correct https url' AND name == 'test-Error message'")
    private ExtendedWebElement errorMessage;

    public WebviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickGoToSiteBtn() {
        goToSiteBtn.click();
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
