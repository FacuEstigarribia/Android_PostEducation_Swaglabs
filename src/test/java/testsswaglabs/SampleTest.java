package testsswaglabs;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.*;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SampleTest implements IAbstractTest, IMobileUtils, ILogin {

    @Test
    public void testFailureLogin(){
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.failureLogin();
        assertEquals(loginPageBase.getErrorMessageLogin(), R.TESTDATA.get("error_message"), "Error! Message of error is not the expected");
    }

    @Test/*(dependsOnMethods = {"testFailureLogin"})*/
    public void testLogin() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        HomePageBase homePage = loginPageBase.login();
        Assert.assertTrue(homePage.isPageOpened(), "The Home Page was not open");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductToCart(){

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.addProductToCart(2);
        CartPageBase cartPage = homePage.clickCartBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(cartPage.isPageOpened(), "The cart page is not open");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testCheckoutProcess(){

        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.addProductToCart(2);
        CartPageBase cartPage = homePage.clickCartBtn();
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.typeFirstName(R.TESTDATA.get("checkout_name"));
        checkoutPage.typeLastName(R.TESTDATA.get("checkout_lastname"));
        checkoutPage.typeZipCode(R.TESTDATA.get("checkout_zipcode"));
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutPage.clickContinueBtn();
        checkoutOverviewPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout Overview page is not opened");

    }

    @Test(dependsOnMethods = {"testLogin", "testAddProductToCart"})
    public void testRemoveProductFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.addProductToCart(2);
        CartPage cartPage = homePage.clickCartBtn();
        cartPage.clickRemoveBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertFalse(cartPage.isUIObjectPresent(), "The cart is not empty");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout(){
        HomePage homePage = new HomePage(getDriver());
        MenuPageBase menuPage = homePage.clickMenuBtn();
        LoginPageBase loginPage = menuPage.clickLogoutBtn();
        loginPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(loginPage.isPageOpened(), "Log in page is not opened");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testGoToSiteWithEmptyUrl(){
        HomePage homePage = new HomePage(getDriver());
        MenuPageBase menuPage = homePage.clickMenuBtn();
        WebviewPageBase webviewPage = menuPage.clickWebviewBtn();
        webviewPage.clickGoToSiteBtn();
        assertEquals(webviewPage.getErrorMessage(), R.TESTDATA.get("webview_error_message"), "The message was not the expected");
    }



}
