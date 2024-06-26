package testsswaglabs;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.HeaderMenuComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.ios.HeaderMenuComponent;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.*;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.ios.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class iOSTest implements IAbstractTest {

    @Test
    public void testFailureLogin(){
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.failureLogin();
        assertEquals(loginPageBase.getErrorMessageLogin(), R.TESTDATA.get("error_message"), "Error! Message of error is not the expected");
    }
    @Test
    public void testLogin(){
            LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
            HomePageBase homePage = loginPageBase.login();
            Assert.assertTrue(homePage.isPageOpened(), "The Home Page was not open");
    }


    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductToCart(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductToCart(2);
        HeaderMenuComponentBase headerMenuComponent =homePage.getHeaderMenuComponent();
        CartPageBase cartPage = headerMenuComponent.clickOnCartBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(cartPage.isPageOpened(), "The cart page is not open");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testCheckoutProcess(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductToCart(2);
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        CartPageBase cartPage = headerMenuComponent.clickOnCartBtn();
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.typeFirstName(R.TESTDATA.get("checkout_name"));
        checkoutPage.typeLastName(R.TESTDATA.get("checkout_lastname"));
        checkoutPage.typeZipCode(R.TESTDATA.get("checkout_zipcode"));
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutPage.clickContinueBtn();
        checkoutOverviewPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout Overview page is not opened");

    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout(){
        HomePageBase homePage = new HomePage(getDriver());
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        MenuPageBase menuPage = headerMenuComponent.clickOnMenuBtn();
        LoginPageBase loginPage = menuPage.clickLogoutBtn();
        loginPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(loginPage.isPageOpened(), "Log in page is not opened");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testRemoveProductFromCart() {
        HomePage homePage = new HomePage(getDriver());
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductToCart(2);
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        CartPageBase cartPage = headerMenuComponent.clickOnCartBtn();
        cartPage.clickRemoveBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertFalse(cartPage.isUIObjectPresent(), "The cart is not empty");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testGoToSiteWithEmptyUrl(){
        HomePageBase homePage = new HomePage(getDriver());
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        MenuPageBase menuPage = headerMenuComponent.clickOnMenuBtn();
        WebviewPageBase webviewPage = menuPage.clickWebviewBtn();
        webviewPage.clickGoToSiteBtn();
        assertEquals(webviewPage.getErrorMessage(), R.TESTDATA.get("webview_error_message"), "The message was not the expected");
    }


    @Test(dependsOnMethods = {"testLogin"})
    public void testDrawPicture(){
        HomePageBase homePage = new HomePage(getDriver());
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        MenuPageBase menuPage = headerMenuComponent.clickOnMenuBtn();
        DrawingPageBase drawingPageBase = menuPage.clickDrawingBtn();
        drawingPageBase.drawPicture();
    }
}
