package orangehrm.adminAccount.demo;

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
import pageObjects.ToastMessageObject;
import pageObjects.adminAccount.myInfo.MyInfoPageObject;

public class Admin_MyInfo extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private SideBarAndTopBarObject sidePanelAndTopMenu;
    private MyInfoPageObject myInfoPage;
    private ToastMessageObject toastMessage;
    private String profileImage;
    private String browserName;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName){
        profileImage = "profile_02.jpeg";
        driver = getBrowserDriver(browserName);
        this.browserName = browserName.toUpperCase();
    }

    @Description("Upload User Profile Image.")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC01_UploadProfileImage(){
        loginPage = PageGenerator.getLoginPage(driver);

        sidePanelAndTopMenu = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        sidePanelAndTopMenu.clickOnSideMenu("My Info");

        myInfoPage = PageGenerator.getMyInfoPage(driver);

        myInfoPage.clickOnProfileImage();

        myInfoPage.uploadMultipleFiles(driver, profileImage);

        myInfoPage.clickOnSaveButton();

        toastMessage = PageGenerator.getToastMessage(driver);

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");

        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated.");
    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

}
