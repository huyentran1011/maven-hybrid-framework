package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.DependentsPageUI;

import java.util.List;

public class DependentsPageObject extends EmployeeSubMenuObject {

    private WebDriver driver;
    public DependentsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click on Add button at Attachments.")
    public void clickOnAddButtonAtAttachments() {
        waitForElementClickable(driver, DependentsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Attachments");
        clickOnElement(driver, DependentsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Attachments");
    }


    @Step("Click on Save button at Attachments")
    public ToastMessageObject clickOnSaveButtonAtAttachments() {
        waitForElementClickable(driver, DependentsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Attachment", "Save");
        clickOnElement(driver, DependentsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Attachment", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Verify that the uploaded file is displayed on the Attachments table.")
    public boolean isUploadedFileDisplayed(String fileName) {
        waitAllLoadingIconInvisible(driver);
        waitForElementVisible(driver, DependentsPageUI.DYNAMIC_TABLE, "orangehrm-attachment");
        List<String> uploadedFiles = getAllValueByColumnName(driver,DependentsPageUI.DYNAMIC_COLUMN_HEADER, "File Name", DependentsPageUI.DYNAMIC_CELL_BY_COLUMN_INDEX, "orangehrm-attachment");
        for(String file:uploadedFiles) {
            if (file.trim().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    @Step("Click on Add button at Assigned Dependents.")
    public void clickOnAddButtonAtAssignedDependents() {
        waitForElementClickable(driver, DependentsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Assigned Dependents");
        clickOnElement(driver, DependentsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Assigned Dependents");
    }

    @Step("Enter Dependent's Name: {0}.")
    public void enterDependentName(String dependentName) {
        waitForElementVisible(driver, DependentsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Name");
        sendKeyIntoElement(driver, DependentsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, dependentName, "Name");
    }

    @Step("Select Relationship: {0}")
    public void selectRelationship(String dependentRelationship) {
        waitForElementVisible(driver, DependentsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Relationship");
        selectItemInCustomDropdown(driver, DependentsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, DependentsPageUI.CHILD_LIST_OF_DROPDOWN,
                dependentRelationship, "Relationship");
    }

    @Step("Enter dependent's date of birth: {0}")
    public void enterDateOfBirth(String dependentDOB) {
        waitForElementVisible(driver, DependentsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, "Date of Birth");
        sendKeyIntoElement(driver, DependentsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, dependentDOB, "Date of Birth");
    }

    @Step("Click on Save button at Add Dependent")
    public ToastMessageObject clickOnSaveButtonOfAddDependent() {
        waitForElementClickable(driver, DependentsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Dependent", "Save");
        clickOnElement(driver, DependentsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Dependent", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    public void waitAllLoadingIconInvisible(WebDriver driver) {
        waitForElementInvisible(driver, DependentsPageUI.LOADING_ICON);
    }
}
