package orangehrm.adminAccount.demo;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.GlobalConstants;
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
import reportConfigs.ExtentManager;

public class ExtentReport_Admin_UserManagement extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPage;
    SideBarAndTopBarObject sidePanelAndTopMenu;
    UserManagementPageObject userManagementPage;
    EditUserPageObject editUserPage;
    ToastMessageObject toastMessage;
    String userName, userNameNotFound ,role, employeeName, status;
    String newUserName, newRole, newStatus, newPassword;


    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        userName = "Kat90520";
        userNameNotFound = "Owen1122";
        role = "ESS";
        employeeName = "Kat Blue";
        status = "Enabled";

        newUserName = "Kat90001";
        newRole = "Admin";
        newStatus = "Disabled";
        newPassword = "Qwerty123@X";
    }

    @Test
    public void TC01_SearchUser_RecordFound() {
        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 01: Open the Login page.");
        loginPage = new LoginPageObject(driver);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 02: Login to system by username is '" + GlobalConstants.ADMIN_USERNAME + "' and Password is '" + GlobalConstants.ADMIN_PASSWORD + "'.");
        sidePanelAndTopMenu = loginPage.loginToSystem(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 03: Click on the Admin menu.");
        sidePanelAndTopMenu.clickOnSideMenu("Admin");

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 04: Get the User Management page.");
        userManagementPage = PageGenerator.getUserManagementPage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 05: Enter Username with value is '" + userName + "'.");
        userManagementPage.enterUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 06: Select User Role from the dropdown menu with value is '" + role + "'.");
        userManagementPage.selectUserRole(role);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 07: Search and select Employee Name with value is '" + employeeName + "'.");
        userManagementPage.enterAndSelectToEmployeeName(employeeName);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 08: Select User Status from the dropdown menu with value is '" + status + "'.");
        userManagementPage.selectStatus(status);
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 09: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 10: Verify that the number of records found is 1.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 1);

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 11: Verify that the record found is correct with User Name is '" + userName
                + "', Role is '" + role + "', Employee Name is '" + employeeName + "' and Status is '" + status + "'.");
        verifyTrue(userManagementPage.isUserRecordDisplayedAtRowIndex("1", userName, role, employeeName, status));

        ExtentManager.getTest().log(Status.INFO, "TC01_SearchUser_RecordFound - STEP 12: Click on the 'Refresh' button.");
        userManagementPage.clickOnResetButton();
    }

    @Test
    public void TC02_SearchUser_NotFound() {

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 01: Enter Username with value is '" + userNameNotFound + "'.");
        userManagementPage.enterUsername(userNameNotFound);

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 02: Select User Role from the dropdown menu with value is '" + role + "'.");
        userManagementPage.selectUserRole(role);

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 03: elect User Status from the dropdown menu with value is '" + status + "'.");
        userManagementPage.selectStatus(status);
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 04: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 05: Verify that number of records found is 0.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 06: Get the Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 07: Verify that the title of Toast Message should be 'Info'.");
        verifyEquals(toastMessage.getMessageTitle(), "Info");

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 08: Verify that the content of Toast Message should be 'No Records Found'.");
        verifyEquals(toastMessage.getMessageContent(), "No Records Found");

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 09: Get the User Management Page Object.");
        userManagementPage = PageGenerator.getUserManagementPage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC02_SearchUser_NotFound - STEP 12: Click on the Refresh button.");
        userManagementPage.clickOnResetButton();
    }

    @Test
    public void TC03_EditRecord() {
        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 01: Enter to Username textbox by value '" + userName + "'.");
        userManagementPage.enterUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 02: Click on 'Search' button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 03: Click on 'Edit' icon on the record of '" + userName + "' user.");
        editUserPage = userManagementPage.clickToEditIconByUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 04: Select new Role with value is '" + newRole + "'.");
        editUserPage.selectUserRole(newRole);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 05: Select new Status with value is '" + newStatus + "'.");
        editUserPage.selectStatus(newStatus);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 06: Click to Change Password checkbox.");
        editUserPage.clickToChangePasswordCheckbox();

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 07: Input New Password with value is '" + newPassword + "'.");
        editUserPage.enterToPasswordTextbox(newPassword);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 08: Input New Confirm Password with value is '" + newPassword + "'.");
        editUserPage.enterToConfirmPasswordTextbox(newPassword);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 09: Click to Save button.");
        toastMessage = editUserPage.clickToSaveButton();

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 10: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 11: Verify that the content of Toast Message should be 'Successfully Updated'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Updated");


        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 12: Get User Management Page Object.");
        userManagementPage = PageGenerator.getUserManagementPage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 13: Click on Reset button.");
        userManagementPage.clickOnResetButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 14: Enter to Username textbox by value '" + userName + "'.");
        userManagementPage.enterUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 15: Click on Search button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 16: Verify that the number of records found is 1.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 1);

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 17: Verify that the found record is correct with User Name is '" + userName
                + "', Role is '" + newRole + "', Employee Name is '" + employeeName + "' and Status is '" + newStatus + "'.");
        verifyTrue(userManagementPage.isUserRecordDisplayedAtRowIndex("1", userName, newRole, employeeName, newStatus));

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 18: Click on the Reset button.");
        userManagementPage.clickOnResetButton();

    }

    @Test
    public void TC04_DeleteARecord() {
        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 01: Enter Username by value '" + userName + "'.");
        userManagementPage.enterUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 02: Click on the Search button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 03: Click on the Delete button of the record with Username is '" + userName + "'.");
        userManagementPage.clickOnDeleteIconByUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 04: Click on the Confirm button.");
        userManagementPage.clickToConfirmToDelete();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 05: Get the Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 06: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 07: Verify that the content of Toast Message should be 'Successfully Deleted'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Deleted");

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 08: Get the User Management Page Object.");
        userManagementPage = PageGenerator.getUserManagementPage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 09: Click on the Reset button.");
        userManagementPage.clickOnResetButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 10: Enter Username by value '" + userName + "'.");
        userManagementPage.enterUsername(userName);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 11: Click on the Search button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 12: Verify that the number of records found is 0.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 13: Get the Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 14: Verify that the title of Toast Message should be 'Info'.");
        verifyEquals(toastMessage.getMessageTitle(), "Info");

        ExtentManager.getTest().log(Status.INFO, "TC04_DeleteARecord - STEP 15: Verify that the content of Toast Message should be 'No Records Found'.");
        verifyEquals(toastMessage.getMessageContent(), "No Records Found");

        ExtentManager.getTest().log(Status.INFO, "TC03_EditRecord - STEP 18: Click on the Reset button.");
        userManagementPage.clickOnResetButton();
    }

    @Test
    public void TC05_DeleteMultipleRecords_BySelectAll() {

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 01: Select new Role with value is 'Admin'.");
        userManagementPage.selectUserRole("Admin");

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 02: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 03: Click on the All Records checkbox.");
        userManagementPage.clickOnAllRecordsCheckbox();

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 04: Click on the 'Delete Selected' button.");
        userManagementPage.clickOnDeleteSelectedButton();

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 05: Click on the 'Yes, Delete' button on dialog to confirm delete.");
        userManagementPage.clickToConfirmToDelete();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 06: Get the Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 07: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 08: Verify that the content of Toast Message should be 'Successfully Deleted'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Deleted");

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 09: Get User Management Page Object.");
        userManagementPage = PageGenerator.getUserManagementPage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 10: Click on the 'Reset' button.");
        userManagementPage.clickOnResetButton();

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 11: Select new Role with value is 'Admin'.");
        userManagementPage.selectUserRole("Admin");

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 12: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 13: Verify that the number of records found is 1.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 1);

        ExtentManager.getTest().log(Status.INFO, "TC05_DeleteMultipleRecords_BySelectAll - STEP 14: Click on the 'Reset' button.");
        userManagementPage.clickOnResetButton();
    }

    @Test
    public void TC06_DeleteMultipleRecords_BySelectRecords() {
        String userName1 = "Angela42109";
        String userName2 = "Gio32577";
        String userName3 = "Hannah92248";

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 01: Click on checkbox button of record with Username is '" + userName1 + "'.");
        userManagementPage.clickToCheckboxOfRecordByUsername(userName1);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 02: Click on checkbox button of record with Username is '" + userName2 + "'.");
        userManagementPage.clickToCheckboxOfRecordByUsername(userName2);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 03: Click on checkbox button of record with Username is '" + userName3 + "'.");
        userManagementPage.clickToCheckboxOfRecordByUsername(userName3);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 04: Click on 'Delete Selected' button.");
        userManagementPage.clickOnDeleteSelectedButton();

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 05: Click on the 'Yes, Delete' button on dialog to confirm delete.");
        userManagementPage.clickToConfirmToDelete();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 06: Get Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 07: Verify that the title of Toast Message should be 'Success'.");
        verifyEquals(toastMessage.getMessageTitle(), "Success");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 08: Verify that the content of Toast Message should be 'Successfully Deleted'.");
        verifyEquals(toastMessage.getMessageContent(), "Successfully Deleted");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 09: Get User Management Page Object.");
        userManagementPage = PageGenerator.getUserManagementPage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 10: Click on the 'Reset' button.");
        userManagementPage.clickOnResetButton();

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 11: Enter username with value is '" + userName1 + "'.");
        userManagementPage.enterUsername(userName1);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 12: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 13: Verify that the number of records found is 0.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 14: Get Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 15: Verify that the title of Toast Message should be 'Info'.");
        verifyEquals(toastMessage.getMessageTitle(), "Info");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 16: Verify that the content of Toast Message should be 'No Records Found'.");
        verifyEquals(toastMessage.getMessageContent(), "No Records Found");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 17: Click on the 'Reset' button.");
        userManagementPage.clickOnResetButton();

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 18: Enter username with value is '" + userName2 + "'.");
        userManagementPage.enterUsername(userName2);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 19: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 20: Verify that the number of records found is 0.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 21: Get Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 22: Verify that the title of Toast Message should be 'Info'.");
        verifyEquals(toastMessage.getMessageTitle(), "Info");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 23: Verify that the content of Toast Message should be 'No Records Found'.");
        verifyEquals(toastMessage.getMessageContent(), "No Records Found");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 24: Click on the 'Reset' button.");
        userManagementPage.clickOnResetButton();

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 25: Enter username with value is '" + userName2 + "'.");
        userManagementPage.enterUsername(userName2);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 26: Click on the 'Search' button.");
        userManagementPage.clickOnSearchButton();
        userManagementPage.sleepInSeconds(3);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 27: Verify that the number of records found is 0.");
        verifyEquals(userManagementPage.getNumberOfRecordsFound(), 0);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 28: Get Toast Message Object.");
        toastMessage = PageGenerator.getToastMessage(driver);

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 29: Verify that the title of Toast Message should be 'Info'.");
        verifyEquals(toastMessage.getMessageTitle(), "Info");

        ExtentManager.getTest().log(Status.INFO, "TC06_DeleteMultipleRecords_BySelectRecords - STEP 30: Verify that the content of Toast Message should be 'No Records Found'.");
        verifyEquals(toastMessage.getMessageContent(), "No Records Found");
    }

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
