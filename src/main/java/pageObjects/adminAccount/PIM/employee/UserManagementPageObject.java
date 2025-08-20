package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageUIs.adminAccount.PIM.employee.UserManagementPageUI;

import java.util.List;

public class UserManagementPageObject extends SideBarAndTopBarObject {
    WebDriver driver;
    public UserManagementPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter Username to search: {0}")
    public void enterUsername(String userName) {
        waitForElementVisible(driver, UserManagementPageUI.USERNAME_TEXTBOX);
        sendKeyIntoElement(driver, UserManagementPageUI.USERNAME_TEXTBOX, userName);
    }

    @Step("Enter User role: {0}")
    public void selectUserRole(String userRole) {
        waitForElementVisible(driver, UserManagementPageUI.ROLE_DROPDOWN_MENU);
        selectItemInCustomDropdown(driver, UserManagementPageUI.ROLE_DROPDOWN_MENU, UserManagementPageUI.CHILD_LIST_IN_DROPDOWN, userRole);
    }

    @Step("Enter and select Employee Name to search: {0}")
    public void enterAndSelectToEmployeeName(String employeeName) {
        waitForElementVisible(driver, UserManagementPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeyIntoElement(driver, UserManagementPageUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
        waitForElementClickable(driver, UserManagementPageUI.EMPLOYEE_NAME_LIST_BOX, employeeName);
        clickOnElement(driver, UserManagementPageUI.EMPLOYEE_NAME_LIST_BOX, employeeName);
    }

    @Step("Select Status to search: {0}")
    public void selectStatus(String status) {
        waitForElementVisible(driver, UserManagementPageUI.STATUS_DROPDOWN_MENU);
        selectItemInCustomDropdown(driver, UserManagementPageUI.STATUS_DROPDOWN_MENU, UserManagementPageUI.CHILD_LIST_IN_DROPDOWN, status);
    }

    @Step("Click on the 'Search' button.")
    public void clickOnSearchButton(){
        waitForElementClickable(driver, UserManagementPageUI.SEARCH_BUTTON);
        clickOnElement(driver, UserManagementPageUI.SEARCH_BUTTON);
    }

    @Step("Click on the 'Reset' button.")
    public void clickOnResetButton(){
        waitForElementClickable(driver, UserManagementPageUI.RESET_BUTTON);
        clickOnElement(driver, UserManagementPageUI.RESET_BUTTON);
    }

    @Step("Get number of Records found.")
    public int getNumberOfRecordsFound(){
        waitForElementVisible(driver, UserManagementPageUI.NUMBER_RECORD_FOUND);
        String recordString = getElementText(driver, UserManagementPageUI.NUMBER_RECORD_FOUND);
        if(recordString.equals("No Records Found")){
            return 0;
        }else {
            recordString = recordString.substring(1, recordString.indexOf(")"));
        }
        return Integer.parseInt(recordString);
    }


    @Step("Verify the User Record displayed at a row is correct: row is {0} - userName is {1} - employee Name is {2} - Status is {3}.")
    public boolean isUserRecordDisplayedAtRowIndex(String rowNumber, String userName, String role, String employeeName, String status){
        List<String> allDataInRow = getAllDataByRowIndex(driver, UserManagementPageUI.DYNAMIC_CELLS_BY_ROW_INDEX, rowNumber);
        if(allDataInRow.get(0).equals(userName)
                && allDataInRow.get(1).equals(role)
                && allDataInRow.get(2).equals(employeeName)
                && allDataInRow.get(3).equals(status)){
            return true;
        }
        return false;
    }

    @Step("Click on the 'Edit' icon of a row data by username: {0} .")
    public EditUserPageObject clickToEditIconByUsername(String userName) {
        waitForElementClickable(driver, UserManagementPageUI.DYNAMIC_ACTION_ICON, userName, "pencil");
        clickOnElement(driver, UserManagementPageUI.DYNAMIC_ACTION_ICON, userName, "pencil");
        return PageGenerator.getEditUserPage(driver);
    }

    @Step("Click on the 'Delete' icon of a row data by username: {0} .")
    public void clickOnDeleteIconByUsername(String userName) {
        waitForElementClickable(driver, UserManagementPageUI.DYNAMIC_ACTION_ICON, userName, "trash");
        clickOnElement(driver, UserManagementPageUI.DYNAMIC_ACTION_ICON, userName, "trash");
    }

    @Step("Click on the 'Yes, Delete' button on the Confirm dialog.")
    public void clickToConfirmToDelete() {
        waitForElementClickable(driver, UserManagementPageUI.CONFIRM_DELETE_BUTTON);
        clickOnElement(driver, UserManagementPageUI.CONFIRM_DELETE_BUTTON);
    }

    @Step("Click on the 'All Records' checkbox.")
    public void clickOnAllRecordsCheckbox(){
        waitForElementClickable(driver, UserManagementPageUI.ALL_RECORDS_CHECKBOX);
        clickOnElement(driver, UserManagementPageUI.ALL_RECORDS_CHECKBOX);
    }

    @Step("Click on the checkbox of a row data by username: {0}.")
    public void clickToCheckboxOfRecordByUsername(String username){
        waitForElementClickable(driver, UserManagementPageUI.DYNAMIC_CHECKBOX_BY_USERNAME, username);
        clickOnElement(driver, UserManagementPageUI.DYNAMIC_CHECKBOX_BY_USERNAME, username);
    }

    @Step("Click on the 'Delete Selected' button.")
    public void clickOnDeleteSelectedButton(){
        waitForElementClickable(driver, UserManagementPageUI.DELETE_SELECTED_BUTTON);
        clickOnElement(driver, UserManagementPageUI.DELETE_SELECTED_BUTTON);
    }
}
