package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {
    @ExtendedFindBy(iosPredicate = "label == 'Signature Pad demo'")
    private ExtendedWebElement signaturePad;

    @ExtendedFindBy(iosPredicate = "label == 'SAVE' AND name == 'test-SAVE'")
    private ExtendedWebElement saveBtn;

    @ExtendedFindBy(iosPredicate = "label == 'CLEAR' AND name == 'test-CLEAR'")
    private ExtendedWebElement clearBtn;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    public void clickClearBtn(){
        clearBtn.click();
    }
}
