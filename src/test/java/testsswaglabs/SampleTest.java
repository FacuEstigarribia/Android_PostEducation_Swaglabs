package testsswaglabs;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.HomePage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.LoginPage;
import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.android.MenuPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import static org.testng.Assert.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SampleTest implements IAbstractTest, IMobileUtils, IAbstractDataProvider {
    @Test(groups = "login")
    @Parameters({"username", "password"})
    //@CsvDataSourceParameters(path = "src/test/resources/testdata_login.csv", dsUid = "id", dsArgs = "username,password")
    public void testLogin(String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        HomePage homePage = loginPage.clickLoginBtn();
        homePage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(homePage.isPageOpened(), "The home page is not opened");
    }

    @Test
    @Parameters({"username", "password", "message"})
    public void testIncorrectUsernameLogin(String username, String password, String message){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLoginBtn();
        assertEquals(loginPage.getErrorMessageLogin(), message, "Error! Message of error is not the same");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testLogout(){
        HomePage homePage = new HomePage(getDriver());
        MenuPage menuPage = homePage.clickMenuBtn();
        LoginPage loginPage = menuPage.clickLogoutBtn();
        loginPage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        assertTrue(loginPage.isPageOpened(), "Log in page is not opened");
    }
}
