package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public interface ILogin extends ICustomTypePageFactory {

    default HomePageBase login() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.login();
        return initPage(getDriver(), HomePageBase.class);
    }

    default LoginPageBase failureLogin(){
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.failureLogin();
        return initPage(getDriver(), LoginPageBase.class);
    }

}
