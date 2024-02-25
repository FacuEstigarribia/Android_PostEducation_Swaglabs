package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.AddFullNamePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddFullNamePageBase.class)
public class AddFullNamePage extends AddFullNamePageBase {
    protected AddFullNamePage(WebDriver driver) {
        super(driver);
    }
}
