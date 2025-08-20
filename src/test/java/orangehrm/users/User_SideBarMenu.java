package orangehrm.users;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;

public class User_SideBarMenu extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private LoginPageObject loginPage;
    private SideBarAndTopBarObject sideAndTopBar;



    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        this.browserName = browserName.toUpperCase();
    }


    @Description("Verify the left side menu is displayed correctly when logging in by user.")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC01_VerifySidebarMenu(){

        loginPage = PageGenerator.getLoginPage(driver);

        sideAndTopBar = loginPage.loginToSystem(GlobalConstants.USER_USERNAME, GlobalConstants.USER_PASSWORD);

        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("Leave"));
        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("Time"));
        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("My Info"));
        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("Performance"));
        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("Dashboard"));
        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("Directory"));
        Assert.assertTrue(sideAndTopBar.isMenuDisplayed("Buzz"));

        Assert.assertTrue(sideAndTopBar.isMenuUndisplayed("Admin"));
        Assert.assertTrue(sideAndTopBar.isMenuUndisplayed("PIM"));
        Assert.assertTrue(sideAndTopBar.isMenuUndisplayed("Recruitment"));
        Assert.assertTrue(sideAndTopBar.isMenuUndisplayed("Maintenance"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
