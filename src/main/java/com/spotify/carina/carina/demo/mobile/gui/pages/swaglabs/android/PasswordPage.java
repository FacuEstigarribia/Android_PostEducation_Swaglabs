package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android;


import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.PasswordPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PasswordPageBase.class)
public class PasswordPage extends PasswordPageBase {


    @FindBy(id = "edit_text")
    private ExtendedWebElement passwordField;

    @FindBy(id = "fragment_signup_step_button")
    private ExtendedWebElement nextBtn;
    protected PasswordPage(WebDriver driver) {
        super(driver);
    }

    public void typePassword(String password){
        passwordField.type(password);
    }

    public AddFullNamePage clickNextBtn(){
        nextBtn.click();
        return initPage(getDriver(), AddFullNamePage.class);
    }
}
