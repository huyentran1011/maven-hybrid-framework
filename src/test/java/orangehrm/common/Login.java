package orangehrm.common;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;

import java.util.Set;

public class Login extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private SideBarAndTopBarObject sideAndTopBar;
    private String browserName;
    public static Set<Cookie> orangeHRMCookies;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browserName){
        driver = getBrowserDriver(browserName);
        this.browserName = browserName.toUpperCase();

        // Login
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterValueIntoTextboxByNameAttribute(driver, "username", GlobalConstants.ADMIN_USERNAME);
        loginPage.enterValueIntoTextboxByNameAttribute(driver, "password", GlobalConstants.ADMIN_PASSWORD);
        loginPage.clickOnButtonByText(driver, "Login");

        // Verify login success
        sideAndTopBar = PageGenerator.getSideBarAndTopBar(driver);
        Assert.assertEquals(sideAndTopBar.getFullName(), GlobalConstants.ADMIN_FULLNAME);

        sideAndTopBar.sleepInSeconds(5);

        // Get all cookies
        orangeHRMCookies = sideAndTopBar.getAllCookies(driver);

        driver.quit();
    }
}
