package testsswaglabs;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.HomePageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.LoginPageBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.desktop.CartPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DesktopSampleTest implements IAbstractTest {


    @Test
    public void testFailureLogin(){
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.open();
        loginPageBase.failureLogin();
        assertEquals(loginPageBase.getErrorMessageLogin(), R.TESTDATA.get("error_message"), "Error! Message of error is not the expected");
    }
    @Test
    public void testLogin(){
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.open();
        loginPageBase.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login Page is not open");
        HomePageBase homePage = loginPageBase.login();
        Assert.assertTrue(homePage.isPageOpened(), "The Home Page was not open");
    }


    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductToCart(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.addProductToCart(2);
        CartPage cartPage =homePage.clickCartBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(cartPage.isPageOpened(), "The cart page is not open");
    }


}
