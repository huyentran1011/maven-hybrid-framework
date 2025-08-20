package orangehrm.adminAccount.PIM;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Dimension;
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
import pageObjects.adminAccount.PIM.employee.*;

public class PIM_01_Employee extends BaseTest {

    private WebDriver driver;
    private String browserName;
    private LoginPageObject loginPage;
    private EmployeeListPageObject employeeListPage;
    private SideBarAndTopBarObject sideAndTopBar;
    private ToastMessageObject toastMessage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private ChangeProfilePicturePageObject changeProfilePicturePage;
    private ContactDetailsPageObject contactDetailsPage;
    private EmergencyContactsPageObject emergencyContactsPage;
    private EmployeeSubMenuObject employeeSubMenu;
    private DependentsPageObject dependentsPage;
    private JobDetailsPageObject jobDetailsPage;
    private SalaryPageObject salaryPage;

    private String firstName, middleName, lastName, fullName, employeeID, employeeUsername, employeePassword, driverLicenseNum, licenseExpiredDate,
            nationality, maritalStatus, dateOfBirth, bloodType, profileImage;
    private String street1, street2, city, stateOrProvince, zipCodeOrPostalCode, country, mobileTelephone, workEmail, otherEmail, contactDetailsAttachment;
    private String contactName, relationship, emergencyContactHomeTelephone, emergencyContactMobileTelephone, emergencyContactWorkTelephone, emergencyContactAttachment;
    private String dependentName, dependentRelationship, dependentDOB, dependentsAttachment;

    private String joinedDate, jobTitle, jobCategory, location, employeeStatus;

    private String salaryComponent, payFrequency, currency, salaryAmount, comments, accountNumber, accountType, routingNumber;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        this.browserName = browserName.toUpperCase();

        firstName = "Julian";
        lastName = "Anderson";
        fullName = firstName + " " + lastName;
        employeeUsername = firstName + Integer.toString(generateRandomNumber());
        employeePassword = "Julian12345678@X";
        driverLicenseNum = "TX908934632564";
        licenseExpiredDate = "2028-09-18";
        nationality = "American";
        maritalStatus = "Married";
        dateOfBirth = "1991-11-02";
        profileImage = "profile_03.jpg";

        street1 = "343 B street";
        street2 = "K203";
        city = "Pensacola";
        stateOrProvince = "Florida";
        zipCodeOrPostalCode = "32503";
        country = "United States";
        mobileTelephone = "(665) 897 7575";
        workEmail = "Julian" + Integer.toString(generateRandomNumber()) + "@tma.com.vn";
        otherEmail = "Julian" + Integer.toString(generateRandomNumber()) + "@gmail.com";
        contactDetailsAttachment = "EmployeeContacts.rtf";

        contactName = "Santiago";
        relationship = "Husband";
        emergencyContactHomeTelephone = "(556) 907 2525";
        emergencyContactMobileTelephone = "(556) 907 2525";
        emergencyContactWorkTelephone = "(556) 907 2525";
        emergencyContactAttachment = "EmergencyContacts.rtf";

        dependentName ="Joseph";
        dependentRelationship = "Child";
        dependentDOB = "2018-10-05";
        dependentsAttachment = "Dependents.rtf";

        joinedDate = "2025-05-19";
        jobTitle = "Automation Tester";
        jobCategory = "Technicians";
        location = "Dallas Branch";
        employeeStatus = "Active";

        salaryComponent = "Gross Salary";
        payFrequency = "Monthly";
        currency = "United States Dollar";
        salaryAmount = "7000";
        comments = "This is a monthly salary.";
        accountNumber = "1234532323";
        accountType = "Checking";
        routingNumber = "021000021";

        loginPage = PageGenerator.getLoginPage(driver);

        sideAndTopBar = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }

    @Description("Add New Employee success.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void Employee_01_AddNewEmployee(){

        sideAndTopBar.clickOnSideMenu("PIM");
        employeeListPage = PageGenerator.getEmployeeListPage(driver);
        addEmployeePage = employeeListPage.clickOnAddButton();
        addEmployeePage.enterFirstName(firstName);
        addEmployeePage.enterLastName(lastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToCreateLoginDetails();
        addEmployeePage.enterUsername(employeeUsername);
        addEmployeePage.clickOnEnabledRadioButton();
        addEmployeePage.enterPassword(employeePassword);
        addEmployeePage.enterConfirmPassword(employeePassword);
        toastMessage = addEmployeePage.clickOnSaveButton();
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");
        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        Assert.assertEquals(personalDetailsPage.getFullName(fullName), fullName);
        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
    }

    @Test
    public void Employee_02_PersonalDetails(){

        personalDetailsPage.enterDriverLicenseNumber(driverLicenseNum);
        personalDetailsPage.enterLicenseExpiredDate(licenseExpiredDate);
        personalDetailsPage.selectNationality(nationality);
        personalDetailsPage.selectMaritalStatus(maritalStatus);
        personalDetailsPage.enterDateOfBirth(dateOfBirth);
        personalDetailsPage.selectFemaleRadioButton();
        toastMessage = personalDetailsPage.clickOnSaveButtonOfPersonalDetails();
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");

    }

    @Test
    public void Employee_03_UploadProfilePicture(){

        changeProfilePicturePage = personalDetailsPage.clickOnProfileImage();
        Dimension profileImageSize_beforeUpload = changeProfilePicturePage.getProfilePictureSize();
        changeProfilePicturePage.uploadMultipleFiles(driver, profileImage);
        changeProfilePicturePage.clickOnSaveButton();
        toastMessage = PageGenerator.getToastMessage(driver);
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");
        changeProfilePicturePage = PageGenerator.getChangeProfileImagePage(driver);
        changeProfilePicturePage.isProfilePictureUpdateSuccess(profileImageSize_beforeUpload);

    }

    @Test
    public void Employee_04_ContactDetails(){
        employeeSubMenu = PageGenerator.getEmployeeSubmenu(driver);
        employeeSubMenu.clickOnEmployeeSubMenu("Contact Details");
        employeeSubMenu.sleepInSeconds(3);

        contactDetailsPage = PageGenerator.getContactDetailsPage(driver);
        contactDetailsPage.enterStreet1(street1);
        contactDetailsPage.enterStreet2(street2);
        contactDetailsPage.enterCity(city);
        contactDetailsPage.enterStateOrProvince(stateOrProvince);
        contactDetailsPage.enterZipOrPostalCode(zipCodeOrPostalCode);
        contactDetailsPage.selectCountry(country);
        contactDetailsPage.enterMobileTelephone(mobileTelephone);
        contactDetailsPage.enterWorkEmail(workEmail);
        contactDetailsPage.enterOtherEmail(otherEmail);
        contactDetailsPage.sleepInSeconds(3);
        toastMessage = contactDetailsPage.clickOnSaveButtonAtContactDetails();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");

        contactDetailsPage = PageGenerator.getContactDetailsPage(driver);
        contactDetailsPage.sleepInSeconds(3);
        contactDetailsPage.clickOnAddButtonAtAttachments();
        contactDetailsPage.uploadMultipleFiles(driver, contactDetailsAttachment);
        toastMessage = contactDetailsPage.clickOnSaveButtonAtAttachments();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

        contactDetailsPage = PageGenerator.getContactDetailsPage(driver);
        Assert.assertTrue(contactDetailsPage.isUploadedFileDisplayed(contactDetailsAttachment));
    }

    @Test
    public void Employee_05_EmergencyDetails(){
        employeeSubMenu = PageGenerator.getEmployeeSubmenu(driver);
        employeeSubMenu.clickOnEmployeeSubMenu("Emergency Contacts");
        employeeSubMenu.sleepInSeconds(3);
        emergencyContactsPage = PageGenerator.getEmergencyContactsPage(driver);
        emergencyContactsPage.clickOnAddButtonOfAssignedEmergencyContacts();
        emergencyContactsPage.enterEmergencyContactName(contactName);
        emergencyContactsPage.enterRelationship(relationship);
        emergencyContactsPage.enterHomeTelephone(emergencyContactHomeTelephone);
        emergencyContactsPage.enterMobileTelephone(emergencyContactMobileTelephone);
        emergencyContactsPage.enterWorkTelephone(emergencyContactWorkTelephone);
        emergencyContactsPage.sleepInSeconds(3);
        toastMessage = emergencyContactsPage.clickOnSaveButtonOfAssignedEmergencyContacts();
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");


        emergencyContactsPage = PageGenerator.getEmergencyContactsPage(driver);
        emergencyContactsPage.sleepInSeconds(3);
        emergencyContactsPage.clickOnAddButtonAtAttachments();
        emergencyContactsPage.uploadMultipleFiles(driver, emergencyContactAttachment);
        toastMessage = emergencyContactsPage.clickOnSaveButtonAtAttachments();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

        emergencyContactsPage = PageGenerator.getEmergencyContactsPage(driver);
        Assert.assertTrue(emergencyContactsPage.isUploadedFileDisplayed(emergencyContactAttachment));

    }

    @Test
    public void Employee_06_AssignedDependents(){
        employeeSubMenu = PageGenerator.getEmployeeSubmenu(driver);
        employeeSubMenu.clickOnEmployeeSubMenu("Dependents");
        employeeSubMenu.sleepInSeconds(3);
        dependentsPage = PageGenerator.getDependentsPage(driver);
        dependentsPage.clickOnAddButtonAtAssignedDependents();
        dependentsPage.enterDependentName(dependentName);
        dependentsPage.selectRelationship(dependentRelationship);
        dependentsPage.enterDateOfBirth(dependentDOB);
        toastMessage = dependentsPage.clickOnSaveButtonOfAddDependent();
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

        dependentsPage = PageGenerator.getDependentsPage(driver);
        dependentsPage.sleepInSeconds(3);
        dependentsPage.clickOnAddButtonAtAttachments();
        dependentsPage.uploadMultipleFiles(driver, dependentsAttachment);
        toastMessage = dependentsPage.clickOnSaveButtonAtAttachments();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

        dependentsPage = PageGenerator.getDependentsPage(driver);
        Assert.assertTrue(dependentsPage.isUploadedFileDisplayed(dependentsAttachment));


    }

    @Test
    public void Employee_07_EditViewJob(){

        employeeSubMenu = PageGenerator.getEmployeeSubmenu(driver);
        employeeSubMenu.clickOnEmployeeSubMenu("Job");
        employeeSubMenu.sleepInSeconds(3);

        jobDetailsPage = PageGenerator.getJobDetailsPage(driver);
        jobDetailsPage.enterJoinedDate(joinedDate);
        jobDetailsPage.selectJobTitle(jobTitle);
        jobDetailsPage.selectJobCategory(jobCategory);
        jobDetailsPage.selectLocation(location);
        jobDetailsPage.selectEmploymentStatus(employeeStatus);
        toastMessage = jobDetailsPage.clickOnSaveButtonOfJobDetails();

        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Updated");
    }

    @Test
    public void Employee_08_EditViewSalary(){
        employeeSubMenu = PageGenerator.getEmployeeSubmenu(driver);
        employeeSubMenu.clickOnEmployeeSubMenu("Salary");
        employeeSubMenu.sleepInSeconds(3);

        salaryPage = PageGenerator.getSalaryPage(driver);
        salaryPage.clickOnAddButtonAtAssignedSalaryComponents();
        salaryPage.enterSalaryComponent(salaryComponent);
        salaryPage.selectPayFrequency(payFrequency);
        salaryPage.selectCurrency(currency);
        salaryPage.enterAmount(salaryAmount);
        salaryPage.enterComments(comments);
        salaryPage.turnOnDirectDepositDetails();
        salaryPage.enterAccountNumber(accountNumber);
        salaryPage.selectAccountType(accountType);
        salaryPage.enterRoutingNumber(routingNumber);
        salaryPage.enterDirectDepositAmount(salaryAmount);
        toastMessage = salaryPage.clickOnSaveButtonAtAddSalaryComponents();
        Assert.assertEquals(toastMessage.getMessageTitle(), "Success");
        Assert.assertEquals(toastMessage.getMessageContent(), "Successfully Saved");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
