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


public class PatternObject_Admin_AddNewEmployee extends BaseTest {
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
        firstName = "Malisa";
        lastName = "Brown";
        fullName = firstName + " " + lastName;
        employeeUsername = firstName + Integer.toString(generateRandomNumber());
        employeePassword = "Malisa23@X";
        driverLicenseNum = "TX92345082011";
        licenseExpiredDate = "2028-10-29";
        nationality = "American";
        maritalStatus = "Married";
        dateOfBirth = "1991-02-18";
        this.browserName = browserName.toUpperCase();
    }

    @Description("Add New Employee success.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC01_AddNewEmployee() {
        loginPage = PageGenerator.getLoginPage(driver);

        loginPage.enterValueIntoTextboxByNameAttribute(driver, "username", GlobalConstants.ADMIN_USERNAME);
        loginPage.enterValueIntoTextboxByNameAttribute(driver, "password", GlobalConstants.ADMIN_PASSWORD);
        loginPage.clickOnButtonByText(driver, "Login");

        sideAndTopBar = PageGenerator.getSideBarAndTopBar(driver);
        sideAndTopBar.clickOnSideMenu("PIM");

        admin_EmployeeListPage = PageGenerator.getEmployeeListPage(driver);
        admin_EmployeeListPage.clickOnButtonByText(driver,"Add");

        admin_addEmployeePage = PageGenerator.getAddEmployeePage(driver);
        admin_addEmployeePage.enterValueIntoTextboxByNameAttribute(driver, "firstName", firstName);
        admin_addEmployeePage.enterValueIntoTextboxByNameAttribute(driver, "lastName", lastName);

        admin_addEmployeePage.clickToCreateLoginDetails();

        admin_addEmployeePage.enterValueIntoTextboxByLabel(driver, "Username", employeeUsername);
        admin_addEmployeePage.clickOnRadioButtonByLabel(driver,"Enabled");

        admin_addEmployeePage.enterValueIntoTextboxByLabel(driver, "Password", employeePassword);
        admin_addEmployeePage.enterValueIntoTextboxByLabel(driver, "Confirm Password", employeePassword);
        admin_addEmployeePage.clickOnButtonByText(driver, "Save");

        toastMessage = PageGenerator.getToastMessage(driver);
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

        admin_personalDetails = PageGenerator.getPersonalDetailsPage(driver);
        admin_personalDetails.sleepInSeconds(2);

        Assert.assertEquals(admin_personalDetails.getFullName(fullName), fullName);
        Assert.assertEquals(admin_personalDetails.getDOMPropertyValueOfElementByName(driver, "firstName", "value"), firstName);
        Assert.assertEquals(admin_personalDetails.getDOMPropertyValueOfElementByName(driver, "lastName", "value"), lastName);

    }

    @Test
    public void TC02_UpdatePersonalDetails(Method method){
        admin_personalDetails.enterValueIntoTextboxByLabel(driver, "Driver's License Number", driverLicenseNum);
        admin_personalDetails.enterValueIntoDatePickerTextboxByLabel(driver, "License Expiry Date", licenseExpiredDate);
        admin_personalDetails.selectValueFromDropdownMenuByLabel(driver, "Nationality", nationality);
        admin_personalDetails.selectValueFromDropdownMenuByLabel(driver, "Marital Status", maritalStatus);
        admin_personalDetails.enterValueIntoDatePickerTextboxByLabel(driver, "Date of Birth", dateOfBirth);
        admin_personalDetails.clickOnRadioButtonByLabel(driver, "Male");
        admin_personalDetails.clickOnButtonByText(driver, "Save");

        toastMessage = PageGenerator.getToastMessage(driver);
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

        loginPage.enterValueIntoTextboxByNameAttribute(driver, "username", employeeUsername);
        loginPage.enterValueIntoTextboxByNameAttribute(driver, "password", employeePassword);
        loginPage.clickOnButtonByText(driver, "Login");

        Assert.assertEquals(sideAndTopBar.getFullName(), firstName + " " + lastName);

    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
