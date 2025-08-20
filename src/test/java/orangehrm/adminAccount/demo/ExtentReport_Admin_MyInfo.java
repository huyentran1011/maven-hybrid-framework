package orangehrm.adminAccount.demo;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
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
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;

public class ExtentReport_Admin_MyInfo extends BaseTest {
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
        profileImage = "profile_03.jpg";
        driver = getBrowserDriver(browserName);
        this.browserName = browserName.toUpperCase();
    }

    @Test
    public void TC01_UploadProfileImage(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName,   "TC01_UploadProfileImage");

        ExtentManager.getTest().log(Status.INFO, "TC01_UploadProfileImage - STEP 01: Open the Login page.");
        loginPage = PageGenerator.getLoginPage(driver);

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 02: Login to system by username is '" + GlobalConstants.ADMIN_USERNAME + "' and Password is '" + GlobalConstants.ADMIN_PASSWORD  + "'.");
        sidePanelAndTopMenu = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 03: Click on 'My Info' menu.");
        sidePanelAndTopMenu.clickOnSideMenu("My Info");

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 04: Get My Info page object.");
        myInfoPage = PageGenerator.getMyInfoPage(driver);

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 05: Click on Profile Image.");
        myInfoPage.clickOnProfileImage();

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 06: Upload new profile image '" + profileImage + "'.");
        myInfoPage.uploadMultipleFiles(driver, profileImage);

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 06: Click on the Save button.");
        myInfoPage.clickOnSaveButton();

        // Verify toast message
        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 07: Get Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 08: Verify that the title of Toast Message should be 'Success'.");
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO,"TC01_UploadProfileImage - STEP 09: Verify that the content of Toast Message should be 'Successfully Updated'.");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");
    }


    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

}
