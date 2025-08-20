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
import pageObjects.adminAccount.PIM.employee.AddEmployeePageObject;
import pageObjects.adminAccount.PIM.employee.EmployeeListPageObject;
import pageObjects.adminAccount.PIM.employee.PersonalDetailsPageObject;

import java.lang.reflect.Method;


public class Admin_AddNewEmployee extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private SideBarAndTopBarObject sideAndTopBar;
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
        firstName = "Alisa";
        lastName = "Bieber";
        fullName = firstName + " " + lastName;
        employeeUsername = firstName + Integer.toString(generateRandomNumber());
        employeePassword = "Alisa23@X";
        driverLicenseNum = "TX90929082029";
        licenseExpiredDate = "2028-12-19";
        nationality = "American";
        maritalStatus = "Married";
        dateOfBirth = "1990-02-15";
        this.browserName = browserName.toUpperCase();
    }

    @Description("Add New Employee success.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC01_AddNewEmployee() {
        loginPage = PageGenerator.getLoginPage(driver);

        sideAndTopBar = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        sideAndTopBar.clickOnSideMenu("PIM");

        admin_EmployeeListPage = PageGenerator.getEmployeeListPage(driver);

        admin_addEmployeePage = admin_EmployeeListPage.clickOnAddButton();

        admin_addEmployeePage.enterFirstName(firstName);

        admin_addEmployeePage.enterLastName(lastName);

        admin_addEmployeePage.clickToCreateLoginDetails();

        admin_addEmployeePage.enterUsername(employeeUsername);

        admin_addEmployeePage.clickOnEnabledRadioButton();

        admin_addEmployeePage.enterPassword(employeePassword);

        admin_addEmployeePage.enterConfirmPassword(employeePassword);

        toastMessage = admin_addEmployeePage.clickOnSaveButton();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");

        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

        admin_personalDetails = PageGenerator.getPersonalDetailsPage(driver);

        Assert.assertEquals(admin_personalDetails.getFullName(fullName), fullName);

        Assert.assertEquals(admin_personalDetails.getFirstName(), firstName);

        Assert.assertEquals(admin_personalDetails.getLastName(), lastName);

    }

    @Test
    public void TC02_UpdatePersonalDetails(Method method){
        admin_personalDetails.enterDriverLicenseNumber(driverLicenseNum);

        admin_personalDetails.enterLicenseExpiredDate(licenseExpiredDate);

        admin_personalDetails.selectNationality(nationality);

        admin_personalDetails.selectMaritalStatus(maritalStatus);

        admin_personalDetails.enterDateOfBirth(dateOfBirth);

        admin_personalDetails.selectFemaleRadioButton();

        toastMessage = admin_personalDetails.clickOnSaveButtonOfPersonalDetails();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");

        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");

        sideAndTopBar = PageGenerator.getSideBarAndTopBar(driver);

        loginPage = sideAndTopBar.logout();

        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Description("Login by created user success.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC03_LoginByNewEmployee(){

        loginPage.loginToSystem(employeeUsername, employeePassword);

        sideAndTopBar = PageGenerator.getSideBarAndTopBar(driver);
        Assert.assertEquals(sideAndTopBar.getFullName(), firstName + " " + lastName);

    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
