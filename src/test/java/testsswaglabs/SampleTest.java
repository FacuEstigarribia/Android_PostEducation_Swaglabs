package testsswaglabs;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.*;
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


public class SampleTest implements IAbstractTest, IMobileUtils, IAbstractDataProvider {


    @Test()
    public void testLogin(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(R.TESTDATA.get("username"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        HomePage homePage = loginPage.clickLoginBtn();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(homePage.isPageOpened(), "The home page is not opened");
    }

    @Test
    public void testIncorrectUsernameLogin(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(R.TESTDATA.get("username"));
        loginPage.typePassword(R.TESTDATA.get("bad_password"));
        loginPage.clickLoginBtn();
        assertEquals(loginPage.getErrorMessageLogin(), R.TESTDATA.get("error_message"), "Error! Message of error is not the same");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout(){
        HomePage homePage = new HomePage(getDriver());
        MenuPage menuPage = homePage.clickMenuBtn();
        LoginPage loginPage = menuPage.clickLogoutBtn();
        loginPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(loginPage.isPageOpened(), "Log in page is not opened");
    }



    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductToCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.addProductToCart(2);
        CartPage cartPage = homePage.clickCartBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(cartPage.isPageOpened(), "The cart page is not open");
    }


    @Test(dependsOnMethods = {"testLogin"})
    public void testRemoveProductFromCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.addProductToCart(2);
        CartPage cartPage = homePage.clickCartBtn();
        cartPage.clickRemoveBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertFalse(cartPage.isUIObjectPresent(), "The cart is not empty");
    }


    @Test(dependsOnMethods = {"testLogin"})
    public void testCheckoutProcess(){
        HomePage homePage = new HomePage(getDriver());
        homePage.addProductToCart(2);
        CartPage cartPage = homePage.clickCartBtn();
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(checkoutPage.isPageOpened(), "CheckoutPage is not opened");
        checkoutPage.typeFirstName(R.TESTDATA.get("checkout_name"));
        checkoutPage.typeLastName(R.TESTDATA.get("checkout_lastname"));
        checkoutPage.typeZipCode(R.TESTDATA.get("checkout_zipcode"));
        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.clickContinueBtn();
        checkoutOverviewPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout Overview page is not opened");
    }

}
