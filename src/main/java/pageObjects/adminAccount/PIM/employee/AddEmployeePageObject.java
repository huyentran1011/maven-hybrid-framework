package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.AddEmployeePageUI;

public class AddEmployeePageObject extends SideBarAndTopBarObject {
    private  WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter First name: {0}")
    public void enterFirstName(String firstName) {
        waitForElementVisible(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX);
        sendKeyIntoElement(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter Last name: {0}")
    public void enterLastName(String lastName) {
        waitForElementVisible(driver, AddEmployeePageUI.LASTNAME_TEXTBOX);
        sendKeyIntoElement(driver, AddEmployeePageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter Employee ID: {0}")
    public void enterToEmployeeID(String employeeID) {
        waitForElementVisible(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, "Employee Id");
        sendKeyIntoElement(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, employeeID, "Employee Id");
    }

    @Step("Click on the 'Create Login Details' toggle to turn it ON.")
    public void clickToCreateLoginDetails() {
        waitForElementClickable(driver, AddEmployeePageUI.CREATE_LOGIN_DETAILS_BUTTON);
        clickOnElement(driver, AddEmployeePageUI.CREATE_LOGIN_DETAILS_BUTTON);
    }

    @Step("Enter Username: {0}")
    public void enterUsername(String employeeUsername) {
        waitForElementVisible(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, "Username");
        sendKeyIntoElement(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, employeeUsername, "Username");
    }

    @Step("Click on the 'Enabled' radio button.")
    public void clickOnEnabledRadioButton() {
        waitForElementClickable(driver, AddEmployeePageUI.RADIO_BUTTON_BY_LABEL, "Enabled");
        clickOnElement(driver, AddEmployeePageUI.RADIO_BUTTON_BY_LABEL, "Enabled");
    }

    @Step("Enter Password: {0}")
    public void enterPassword(String employeePassword) {
        waitForElementVisible(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, "Password");
        sendKeyIntoElement(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, employeePassword, "Password");
    }

    @Step("Enter Confirm Password: {0}")
    public void enterConfirmPassword(String employeePassword) {
        waitForElementVisible(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL,"Confirm Password");
        sendKeyIntoElement(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, employeePassword, "Confirm Password");
    }

    @Step("Click on the 'Save' button.")
    public ToastMessageObject clickOnSaveButton() {
        waitForElementClickable(driver, AddEmployeePageUI.BUTTON_BY_NAME_AND_CONTAINER, "Add Employee", "Save");
        clickOnElement(driver, AddEmployeePageUI.BUTTON_BY_NAME_AND_CONTAINER,"Add Employee", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Get employee ID.")
    public String getEmployeeID() {
        waitForElementVisible(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, "Employee Id");
        return getDomPropertyValue(driver, AddEmployeePageUI.TEXTBOX_BY_LABEL, "value", "Employee Id");
    }
}
