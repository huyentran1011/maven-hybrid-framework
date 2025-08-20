package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.SalaryPageUI;

import java.util.List;

public class SalaryPageObject extends EmployeeSubMenuObject {

    private WebDriver driver;
    public SalaryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Verify that the uploaded file is displayed on the Attachments table.")
    public boolean isUploadedFileDisplayed(String fileName){
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_TABLE, "orangehrm-attachment");
        List<String> uploadedFiles = getAllValueByColumnName(driver,SalaryPageUI.DYNAMIC_COLUMN_HEADER, "File Name", SalaryPageUI.DYNAMIC_CELL_BY_COLUMN_INDEX, "orangehrm-attachment");
        System.out.println("Size of uploadedFiles: " + uploadedFiles.size());
        for(String file:uploadedFiles) {
            System.out.println("cell: " + file);
            if (file.trim().equals(fileName)) {
                System.out.println("found!!");
                return true;
            }
        }
        return false;
    }

    @Step("Click on Save button at Assigned Salary Component.")
    public void clickOnAddButtonAtAssignedSalaryComponents() {
        waitForElementClickable(driver, SalaryPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Assigned Salary Components");
        clickOnElement(driver, SalaryPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Assigned Salary Components");
    }

    @Step("Click on Save button at Assigned Salary Component.")
    public ToastMessageObject clickOnSaveButtonAtAddSalaryComponents() {
        waitForElementClickable(driver, SalaryPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER," Add Salary Component ", "Save");
        clickOnElement(driver, SalaryPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER," Add Salary Component ", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Enter Salary Component: {0}")
    public void enterSalaryComponent(String salaryComponent) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Salary Component");
        sendKeyIntoElement(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, salaryComponent, "Salary Component");
    }

    @Step("Select Pay Grade: {0}")
    public void selectPayGrade(String payGrade) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Pay Grade");
        selectItemInCustomDropdown(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, SalaryPageUI.CHILD_LIST_OF_DROPDOWN,
                payGrade, "Pay Grade");
    }

    @Step("Select Pay Frequency: {0}")
    public void selectPayFrequency(String payFrequency) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Pay Frequency");
        selectItemInCustomDropdown(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, SalaryPageUI.CHILD_LIST_OF_DROPDOWN,
                payFrequency, "Pay Frequency");
    }

    @Step("Select Currency: {0}")
    public void selectCurrency(String currency) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Currency");
        selectItemInCustomDropdown(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, SalaryPageUI.CHILD_LIST_OF_DROPDOWN,
                currency, "Currency");
    }

    @Step("Enter Salary Amount: {0}")
    public void enterAmount(String salaryAmount) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Amount");
        sendKeyIntoElement(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, salaryAmount, "Amount");
    }


    @Step("Enter Comment: {0}")
    public void enterComments(String comments) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_TEXTAREA_BY_LABEL, "Comments");
        sendKeyIntoElement(driver, SalaryPageUI.DYNAMIC_TEXTAREA_BY_LABEL, comments, "Comments");
    }

    @Step("Turn on 'Include Direct Deposit Details' button.")
    public void turnOnDirectDepositDetails() {
        waitForElementClickable(driver, SalaryPageUI.INCLUDE_DIRECT_DEPOSIT_DETAILS_BUTTON);
        clickOnElement(driver, SalaryPageUI.INCLUDE_DIRECT_DEPOSIT_DETAILS_BUTTON);
    }

    @Step("Enter Account Number: {0}")
    public void enterAccountNumber(String accountNumber) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Account Number");
        sendKeyIntoElement(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, accountNumber, "Account Number");
    }

    @Step("Select Account Type : {0}")
    public void selectAccountType(String accountType) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Account Type");
        selectItemInCustomDropdown(driver, SalaryPageUI.DYNAMIC_DROPDOWN_BY_LABEL, SalaryPageUI.CHILD_LIST_OF_DROPDOWN,
                accountType, "Account Type");
    }

    @Step("Enter Routing Number: {0}")
    public void enterRoutingNumber(String routingNumber) {
        waitForElementVisible(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Routing Number");
        sendKeyIntoElement(driver, SalaryPageUI.DYNAMIC_TEXTBOX_BY_LABEL, routingNumber, "Routing Number");
    }


    @Step("Enter Direct Deposit Salary Amount: {0}")
    public void enterDirectDepositAmount(String salaryAmount) {
        waitForElementVisible(driver, SalaryPageUI.AMOUNT_TEXTBOX_AFTER_DIRECT_DEPOSIT_DETAILS);
        sendKeyIntoElement(driver, SalaryPageUI.AMOUNT_TEXTBOX_AFTER_DIRECT_DEPOSIT_DETAILS, salaryAmount);
    }
}
