package orangehrm.adminAccount.demo;

import commons.BaseTest;
import commons.GlobalConstants;
import jiraConfigs.JiraCreateIssue;
import org.openqa.selenium.WebDriver;
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


public class Jira_Admin_AddNewEmployee extends BaseTest {
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
        firstName = "Andrew";
        lastName = "Anderson";
        fullName = firstName + " " + lastName;
        employeeUsername = firstName + Integer.toString(generateRandomNumber());
        employeePassword = "Andrew23@X";
        driverLicenseNum = "TX995552323";
        licenseExpiredDate = "2028-03-15";
        nationality = "American";
        maritalStatus = "Single";
        dateOfBirth = "1990-01-12";
        this.browserName = browserName.toUpperCase();
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC01_AddNewEmployee() {

        loginPage = PageGenerator.getLoginPage(driver);

        log.info("TC01_AddNewEmployee - STEP 02: Login to the system by username is '" + GlobalConstants.ADMIN_USERNAME + "' and Password is '" + GlobalConstants.ADMIN_PASSWORD  + "'.");
        sidePanelAndTopMenu = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        log.info("TC01_AddNewEmployee - STEP 03: Click on the 'PIM' menu.");
        sidePanelAndTopMenu.clickOnSideMenu("PIM");

        log.info("TC01_AddNewEmployee - STEP 04: Open the Employee List page.");
        admin_EmployeeListPage = PageGenerator.getEmployeeListPage(driver);

        log.info("TC01_AddNewEmployee - STEP 05: Click on the 'Add' button.");
        admin_addEmployeePage = admin_EmployeeListPage.clickOnAddButton();

        log.info("TC01_AddNewEmployee - STEP 06: Enter Firstname with value is '" + firstName + "'.");
        admin_addEmployeePage.enterFirstName(firstName);

        log.info("TC01_AddNewEmployee - STEP 07: Enter Lastname with value is '" + lastName + "'.");
        admin_addEmployeePage.enterLastName(lastName);

        log.info("TC01_AddNewEmployee - STEP 08: Click on the 'Create Login Details' toggle button to turn it ON.");
        admin_addEmployeePage.clickToCreateLoginDetails();

        log.info("TC01_AddNewEmployee - STEP 09: Enter Username with value is '" + employeeUsername + "'.");
        admin_addEmployeePage.enterUsername(employeeUsername);

        log.info("TC01_AddNewEmployee - STEP 10: Click on the 'Enabled' radio button.");
        admin_addEmployeePage.clickOnEnabledRadioButton();

        log.info("TC01_AddNewEmployee - STEP 11: Enter Password with value is '" + employeePassword + "'.");
        admin_addEmployeePage.enterPassword(employeePassword);

        log.info("TC01_AddNewEmployee - STEP 12: Enter Confirm Password with value is '" + employeePassword + "'.");
        admin_addEmployeePage.enterConfirmPassword(employeePassword);

        log.info("TC01_AddNewEmployee - STEP 13: Click on the 'Save' button.");
        toastMessage = admin_addEmployeePage.clickOnSaveButton();

        log.info("TC01_AddNewEmployee - STEP 14: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        log.info("TC01_AddNewEmployee - STEP 15: Verify that the content of Toast Message should be 'Successfully Saved'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Saved");

        log.info("TC01_AddNewEmployee - STEP 16: Get the Personal Details page object.");
        admin_personalDetails = PageGenerator.getPersonalDetailsPage(driver);

        log.info("TC01_AddNewEmployee - STEP 17: Verify that Full Name should be '" + fullName + "'.");
        verifyEquals(admin_personalDetails.getFullName(fullName), fullName);

        log.info("TC01_AddNewEmployee - STEP 18: Verify that First Name should be '" + firstName + "'.");
        verifyEquals(admin_personalDetails.getFirstName(), firstName);

        log.info("TC01_AddNewEmployee - STEP 19: Verify that Last Name should be '" + lastName + "'.");
        verifyEquals(admin_personalDetails.getLastName(), lastName);

    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC02_UpdatePersonalDetails(){

        log.info("TC02_UpdatePersonalDetails - STEP 01: Enter Driver License Number with value is '" + driverLicenseNum + "'.");
        admin_personalDetails.enterDriverLicenseNumber(driverLicenseNum);

        log.info("TC02_UpdatePersonalDetails - STEP 02: Enter License Expire Date with value is '" + licenseExpiredDate + "'.");
        admin_personalDetails.enterLicenseExpiredDate(licenseExpiredDate);

        log.info("TC02_UpdatePersonalDetails - STEP 03: Select Nationality from dropdown list with value is '" + nationality + "'.");
        admin_personalDetails.selectNationality(nationality);

        log.info("TC02_UpdatePersonalDetails - STEP 04: Select Marital Status from dropdown list with value is '" + maritalStatus + "'.");
        admin_personalDetails.selectMaritalStatus(maritalStatus);

        log.info("TC02_UpdatePersonalDetails - STEP 05: Enter Date of Birth with value is '" + dateOfBirth + "'.");
        admin_personalDetails.enterDateOfBirth(dateOfBirth);

        log.info("TC02_UpdatePersonalDetails - STEP 06: Click on Female radio button.");
        admin_personalDetails.selectFemaleRadioButton();

        log.info("TC02_UpdatePersonalDetails - STEP 07: Click on the 'Save' button.");
        toastMessage = admin_personalDetails.clickOnSaveButtonOfPersonalDetails();

        log.info("TC02_UpdatePersonalDetails - STEP 08: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        log.info("TC02_UpdatePersonalDetails - STEP 09: Verify that the content of Toast Message should be 'Successfully Updated'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Updated");

        log.info("TC02_UpdatePersonalDetails - STEP 10: Get the Side Panel and Top Bar object.");
        sidePanelAndTopMenu = PageGenerator.getSideBarAndTopBar(driver);

        log.info("TC02_UpdatePersonalDetails - STEP 11: Click on Top Bar menu and click on 'Logout' menu.");
        loginPage = sidePanelAndTopMenu.logout();

        log.info("TC02_UpdatePersonalDetails - STEP 12: Verify that user logout success by checking the 'Login' button is displayed.");
        verifyTrue(loginPage.isLoginButtonDisplayed());
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC03_LoginByNewEmployee(){

        log.info("TC03_LoginByNewEmployee - STEP 01: Login to system by username is '" + employeeUsername + "' and password is '" + employeePassword + "'.");
        loginPage.loginToSystem(employeeUsername, employeePassword);

        log.info("TC03_LoginByNewEmployee - STEP 02: Verify that the user log in success by displaying the USer Name is '" + firstName + " " + lastName  + "'.");
        verifyEquals(sidePanelAndTopMenu.getFullName(), firstName + " + abc " + lastName);

    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
