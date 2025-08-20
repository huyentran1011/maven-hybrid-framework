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
import pageObjects.adminAccount.PIM.employee.AddEmployeePageObject;
import pageObjects.adminAccount.PIM.employee.EmployeeListPageObject;
import pageObjects.adminAccount.PIM.employee.PersonalDetailsPageObject;
import reportConfigs.ExtentManager;

import java.lang.reflect.Method;


public class ExtentReport_Admin_AddNewEmployee extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private SideBarAndTopBarObject sidePanelAndTopMenu;
    private EmployeeListPageObject admin_EmployeeListPage;
    private AddEmployeePageObject admin_addEmployeePage;
    private PersonalDetailsPageObject admin_personalDetails;
    private ToastMessageObject toastMessage;
    private String firstName, middleName, lastName, fullName, employeeUsername, employeePassword, driverLicenseNum, licenseExpiredDate,
            nationality, maritalStatus, dateOfBirth, bloodType;
    private String browserName;


    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        firstName = "Daniel";
        lastName = "Gill";
        fullName = firstName + " " + lastName;
        employeeUsername = firstName + Integer.toString(generateRandomNumber());
        employeePassword = "Daniel123@X";
        driverLicenseNum = "TX997326029";
        licenseExpiredDate = "2027-04-15";
        nationality = "American";
        maritalStatus = "Single";
        dateOfBirth = "1995-04-10";
        this.browserName = browserName.toUpperCase();
    }

    @Test
    public void TC01_AddNewEmployee(Method method) {
        ExtentManager.startTest(method.getClass() + method.getName() + " - " + browserName,   "TC01_AddNewEmployee");

        loginPage = PageGenerator.getLoginPage(driver);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 02: Login to the system by username is '" + GlobalConstants.ADMIN_USERNAME + "' and Password is '" + GlobalConstants.ADMIN_PASSWORD  + "'.");
        sidePanelAndTopMenu = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 03: Click on the 'PIM' menu.");
        sidePanelAndTopMenu.clickOnSideMenu("PIM");

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 04: Open the Employee List page.");
        admin_EmployeeListPage = PageGenerator.getEmployeeListPage(driver);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 05: Click on the 'Add' button.");
        admin_addEmployeePage = admin_EmployeeListPage.clickOnAddButton();

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 06: Enter Firstname with value is '" + firstName + "'.");
        admin_addEmployeePage.enterFirstName(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 07: Enter Lastname with value is '" + lastName + "'.");
        admin_addEmployeePage.enterLastName(lastName);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 08: Click on the 'Create Login Details' toggle button to turn it ON.");
        admin_addEmployeePage.clickToCreateLoginDetails();

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 09: Enter Username with value is '" + employeeUsername + "'.");
        admin_addEmployeePage.enterUsername(employeeUsername);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 10: Click on the 'Enabled' radio button.");
        admin_addEmployeePage.clickOnEnabledRadioButton();

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 11: Enter Password with value is '" + employeePassword + "'.");
        admin_addEmployeePage.enterPassword(employeePassword);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 12: Enter Confirm Password with value is '" + employeePassword + "'.");
        admin_addEmployeePage.enterConfirmPassword(employeePassword);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 13: Click on the 'Save' button.");
        toastMessage = admin_addEmployeePage.clickOnSaveButton();

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 14: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 15: Verify that the content of Toast Message should be 'Successfully Saved'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Saved");

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 16: Get the Personal Details page object.");
        admin_personalDetails = PageGenerator.getPersonalDetailsPage(driver);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 17: Verify that Full Name should be '" + fullName + "'.");
        Assert.assertEquals(admin_personalDetails.getFullName(fullName), fullName);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 18: Verify that First Name should be '" + firstName + "'.");
        Assert.assertEquals(admin_personalDetails.getFirstName(), firstName);

        ExtentManager.getTest().log(Status.INFO,"TC01_AddNewEmployee - STEP 19: Verify that Last Name should be '" + lastName + "'.");
        Assert.assertEquals(admin_personalDetails.getLastName(), lastName);

    }

    @Test
    public void TC02_UpdatePersonalDetails(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName,   "TC02_UpdatePersonalDetails");

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 01: Enter Driver License Number with value is '" + driverLicenseNum + "'.");
        admin_personalDetails.enterDriverLicenseNumber(driverLicenseNum);

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 02: Enter License Expire Date with value is '" + licenseExpiredDate + "'.");
        admin_personalDetails.enterLicenseExpiredDate(licenseExpiredDate);

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 03: Select Nationality from dropdown list with value is '" + nationality + "'.");
        admin_personalDetails.selectNationality(nationality);

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 04: Select Marital Status from dropdown list with value is '" + maritalStatus + "'.");
        admin_personalDetails.selectMaritalStatus(maritalStatus);

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 05: Enter Date of Birth with value is '" + dateOfBirth + "'.");
        admin_personalDetails.enterDateOfBirth(dateOfBirth);

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 06: Click on Female radio button.");
        admin_personalDetails.selectFemaleRadioButton();

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 07: Click on the 'Save' button.");
        toastMessage = admin_personalDetails.clickOnSaveButtonOfPersonalDetails();

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 08: Verify that the title of Toast Message should be 'Success'.");
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 09: Verify that the content of Toast Message should be 'Successfully Updated'.");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 10: Get the Side Panel and Top Bar object.");
        sidePanelAndTopMenu = PageGenerator.getSideBarAndTopBar(driver);

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 11: Click on Top Bar menu and click on 'Logout' menu.");
        loginPage = sidePanelAndTopMenu.logout();

        ExtentManager.getTest().log(Status.INFO,"TC02_UpdatePersonalDetails - STEP 12: Verify that user logout success by checking the 'Login' button is displayed.");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    public void TC03_LoginByNewEmployee(Method method){
        ExtentManager.startTest(method.getName() + " - " + browserName,   "TC03_LoginByNewEmployee");

        ExtentManager.getTest().log(Status.INFO,"TC03_LoginByNewEmployee - STEP 01: Login to system by username is '" + employeeUsername + "' and password is '" + employeePassword + "'.");
        loginPage.loginToSystem(employeeUsername, employeePassword);

        ExtentManager.getTest().log(Status.INFO,"TC03_LoginByNewEmployee - STEP 02: Verify that the user log in success by displaying the USer Name is '" + firstName + " " + lastName  + "'.");
        Assert.assertEquals(sidePanelAndTopMenu.getFullName(), firstName + " + " + lastName);

    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
