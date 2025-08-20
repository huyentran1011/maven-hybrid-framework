package orangehrm.adminAccount.demo;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageObjects.ToastMessageObject;
import pageObjects.adminAccount.PIM.employee.EditUserPageObject;
import pageObjects.adminAccount.PIM.employee.UserManagementPageObject;

public class Admin_UserManagement extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    SideBarAndTopBarObject sidePanelAndTopMenu;
    UserManagementPageObject userManagementPage;
    EditUserPageObject editUserPage;
    ToastMessageObject toastMessage;
    String userName, userNameNotFound ,role, employeeName, status;
    String newUserName, newRole, newStatus, newPassword;
    String userNameUseToDelete_1, userNameUseToDelete_2, userNameUseToDelete_3;


    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userName = "Harry85411";
        userNameNotFound = "Owen1122";
        role = "ESS";
        employeeName = "Harry Hikes";
        status = "Enabled";

        newUserName = "Harry93001";
        newRole = "Admin";
        newStatus = "Disabled";
        newPassword = "Qwerty123@X";

        userNameUseToDelete_1 = "Cameron38875";
        userNameUseToDelete_2 = "Jackson52065";
        userNameUseToDelete_3 = "Daniel81835";
    }

    @Description("Search user which has record found.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC01_SearchUser_RecordFound() {
        loginPage = PageGenerator.getLoginPage(driver);

        sidePanelAndTopMenu = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        sidePanelAndTopMenu.clickOnSideMenu("Admin");

        userManagementPage = PageGenerator.getUserManagementPage(driver);

        userManagementPage.enterUsername(userName);

        userManagementPage.selectUserRole(role);

        userManagementPage.enterAndSelectToEmployeeName(employeeName);

        userManagementPage.selectStatus(status);

        userManagementPage.sleepInSeconds(3);

        userManagementPage.clickOnSearchButton();

        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 1);

        verifyTrue(userManagementPage.isUserRecordDisplayedAtRowIndex("1", userName, role, employeeName, status));

        userManagementPage.clickOnResetButton();
    }


    @Description("Search user which has no record found.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC02_SearchUser_NotFound() {

        userManagementPage.enterUsername(userNameNotFound);

        userManagementPage.selectUserRole(role);

        userManagementPage.selectStatus(status);
        userManagementPage.sleepInSeconds(3);

        userManagementPage.clickOnSearchButton();

        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        toastMessage = PageGenerator.getToastMessage(driver);

        verifyEquals(toastMessage.getMessageTitle(), "Info");

        verifyEquals(toastMessage.getMessageContent(), "No Records Found");

        userManagementPage = PageGenerator.getUserManagementPage(driver);

        userManagementPage.clickOnResetButton();
    }

    @Description("Edit a record.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC03_EditRecord() {
        userManagementPage.enterUsername(userName);

        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        editUserPage = userManagementPage.clickToEditIconByUsername(userName);

        editUserPage.selectUserRole(newRole);

        editUserPage.selectStatus(newStatus);

        editUserPage.clickToChangePasswordCheckbox();

        editUserPage.enterToPasswordTextbox(newPassword);

        editUserPage.enterToConfirmPasswordTextbox(newPassword);

        toastMessage = editUserPage.clickToSaveButton();

        verifyEquals(toastMessage.getMessageTitle(), "Success");

        verifyEquals(toastMessage.getMessageContent(), "Successfully Updated");


        userManagementPage = PageGenerator.getUserManagementPage(driver);

        userManagementPage.clickOnResetButton();
        userManagementPage.sleepInSeconds(3);

        userManagementPage.enterUsername(userName);

        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 1);

        verifyTrue(userManagementPage.isUserRecordDisplayedAtRowIndex("1", userName, newRole, employeeName, newStatus));

        userManagementPage.clickOnResetButton();

    }


    @Description("Delete a record.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC04_DeleteARecord() {
        userManagementPage.enterUsername(userName);

        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        userManagementPage.clickOnDeleteIconByUsername(userName);

        userManagementPage.clickToConfirmToDelete();
        userManagementPage.sleepInSeconds(3);

        toastMessage = PageGenerator.getToastMessage(driver);
        ;
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        verifyEquals(toastMessage.getMessageContent(), "Successfully Deleted");

        userManagementPage = PageGenerator.getUserManagementPage(driver);

        userManagementPage.clickOnResetButton();
        userManagementPage.sleepInSeconds(3);

        verifyARecordHasBeenDeleted(userName);

    }


    @Description("Delete multiple records by select all displayed records.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC05_DeleteMultipleRecords_BySelectAll() {

        userManagementPage.selectUserRole("Admin");

        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        userManagementPage.clickOnAllRecordsCheckbox();

        userManagementPage.clickOnDeleteSelectedButton();

        userManagementPage.clickToConfirmToDelete();
        userManagementPage.sleepInSeconds(3);

        toastMessage = PageGenerator.getToastMessage(driver);

        verifyEquals(toastMessage.getMessageTitle(), "Success");

        verifyEquals(toastMessage.getMessageContent(), "Successfully Deleted");

        userManagementPage = PageGenerator.getUserManagementPage(driver);

        userManagementPage.clickOnResetButton();

        userManagementPage.selectUserRole("Admin");

        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 1);

        userManagementPage.clickOnResetButton();
    }


    @Description("Delete multiple records by select some records.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC06_DeleteMultipleRecords_BySelectRecords() {

        userManagementPage.clickToCheckboxOfRecordByUsername(userNameUseToDelete_1);

        userManagementPage.clickToCheckboxOfRecordByUsername(userNameUseToDelete_2);

        userManagementPage.clickToCheckboxOfRecordByUsername(userNameUseToDelete_3);

        userManagementPage.clickOnDeleteSelectedButton();

        userManagementPage.clickToConfirmToDelete();
        userManagementPage.sleepInSeconds(3);

        toastMessage = PageGenerator.getToastMessage(driver);

        verifyEquals(toastMessage.getMessageTitle(), "Success");

        verifyEquals(toastMessage.getMessageContent(), "Successfully Deleted");

        userManagementPage = PageGenerator.getUserManagementPage(driver);

        userManagementPage.clickOnResetButton();

        verifyARecordHasBeenDeleted(userNameUseToDelete_1);

        verifyARecordHasBeenDeleted(userNameUseToDelete_2);

        verifyARecordHasBeenDeleted(userNameUseToDelete_3);
    }

    private void verifyARecordHasBeenDeleted(String userName) {
        userManagementPage.enterUsername(userName);

        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        toastMessage = PageGenerator.getToastMessage(driver);

        verifyEquals(toastMessage.getMessageTitle(), "Info");

        verifyEquals(toastMessage.getMessageContent(), "No Records Found");

        userManagementPage.clickOnResetButton();
    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
