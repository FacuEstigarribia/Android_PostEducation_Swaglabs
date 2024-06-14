package testsswaglabs;


import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.HeaderMenuComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.components.common.ProductListComponentBase;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.pages.common.*;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.utils.ProductsDataProvider;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DesktopSampleTest implements IAbstractTest {


    @Test
    public void testFailureLogin(){
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.open();
        loginPageBase.failureLogin();
        assertEquals(loginPageBase.getErrorMessageLogin(), R.TESTDATA.get("error_message_desktop"), "Error! Message of error is not the expected");
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
    public void testCheckTitleOfProducts(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        for(int i = 1; i <= 6; i ++){
            String aux = productListComponent.getTitleOfSelectedProduct(i);
            assertEquals(aux, productListComponent.getTitleOfSelectedProduct(i), "The title is not the same that is expected");
        }
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductToCart(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductToCart(2);
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        CartPageBase cartPage = headerMenuComponent.clickOnCartBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(cartPage.isPageOpened(), "The cart page is not open");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductsToCart(){
        List<Integer> indexList = Arrays.asList(1,3,4);
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductsToCart(indexList);
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        CartPageBase cartPage = headerMenuComponent.clickOnCartBtn();
        cartPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        Assert.assertTrue(cartPage.isPageOpened(), "The cart page is not open");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testCheckoutProcess(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductToCart(2);
        productListComponent.addProductToCart(4);
        HeaderMenuComponentBase headerMenuComponent = homePage.getHeaderMenuComponent();
        CartPageBase cartPage = headerMenuComponent.clickOnCartBtn();
        CheckoutPageBase checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.typeFirstName(R.TESTDATA.get("checkout_name"));
        checkoutPage.typeLastName(R.TESTDATA.get("checkout_lastname"));
        checkoutPage.typeZipCode(R.TESTDATA.get("checkout_zipcode"));
        CheckoutOverviewPageBase checkoutOverviewPage = checkoutPage.clickContinueBtn();
        checkoutOverviewPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout Overview page is not opened");
        CheckoutCompletePageBase checkoutCompletePage = checkoutOverviewPage.clickFinishBtn();
        checkoutCompletePage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        String orderDispatcehTxt = checkoutCompletePage.getOrderBeenDispatchedText(R.TESTDATA.get("checkout_complete_text_order_dispatched"));
        assertEquals(orderDispatcehTxt, orderDispatcehTxt, "The text doesn't match with the expected");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAddProductToCartDemoWithStreams(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductsToCartStream();
    }
    @Test(dependsOnMethods = {"testLogin"}, dataProvider = "productNames", dataProviderClass = ProductsDataProvider.class)
    public void testAddMultipleProductsToCart(List<String> productNames){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        ProductListComponentBase productListComponent = homePage.getProductListComponent();
        productListComponent.addProductsToCart2(productNames);
    }
}
