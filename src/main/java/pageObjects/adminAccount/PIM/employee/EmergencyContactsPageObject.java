package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.EmergencyContactsPageUI;

import java.util.List;

public class EmergencyContactsPageObject extends EmployeeSubMenuObject {

    private WebDriver driver;
    public EmergencyContactsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter Name of Emergency Contacts: {0}.")
    public void enterEmergencyContactName(String contactName){
        waitForElementVisible(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Name");
        sendKeyIntoElement(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, contactName, "Name");
    }

    @Step("Enter Relationship of Emergency Contacts: {0}.")
    public void enterRelationship(String relationship) {
        waitForElementVisible(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Relationship");
        sendKeyIntoElement(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, relationship, "Relationship");
    }

    @Step("Enter Home Telephone of Emergency Contacts: {0}.")
    public void enterHomeTelephone(String emergencyContactHomeTelephone) {
        waitForElementVisible(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Home Telephone");
        sendKeyIntoElement(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, emergencyContactHomeTelephone, "Home Telephone");
    }

    @Step("Enter Mobile Telephone of Emergency Contacts: {0}.")
    public void enterMobileTelephone(String emergencyContactMobileTelephone) {
        waitForElementVisible(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Mobile");
        sendKeyIntoElement(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, emergencyContactMobileTelephone, "Mobile");
    }

    @Step("Enter Work Telephone of Emergency Contacts: {0}.")
    public void enterWorkTelephone(String emergencyContactWorkTelephone) {
        waitForElementVisible(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Work Telephone");
        sendKeyIntoElement(driver, EmergencyContactsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, emergencyContactWorkTelephone, "Work Telephone");
    }

    @Step("Click on Add button at Assigned Emergency Contact.")
    public void clickOnAddButtonOfAssignedEmergencyContacts() {
        waitForElementClickable(driver, EmergencyContactsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Assigned Emergency Contacts");
        clickOnElement(driver, EmergencyContactsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Assigned Emergency Contacts");
    }

    @Step("Click on Add button at Attachments.")
    public void clickOnAddButtonAtAttachments() {
        waitForElementClickable(driver, EmergencyContactsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Attachments");
        clickOnElement(driver, EmergencyContactsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Attachments");
    }

    @Step("Verify that the uploaded file is displayed on the Attachments table.")
    public boolean isUploadedFileDisplayed(String fileName) {
        waitAllLoadingIconInvisible(driver);
        waitForElementVisible(driver, EmergencyContactsPageUI.DYNAMIC_TABLE, "orangehrm-attachment");
        List<String> uploadedFiles = getAllValueByColumnName(driver,EmergencyContactsPageUI.DYNAMIC_COLUMN_HEADER, "File Name", EmergencyContactsPageUI.DYNAMIC_CELL_BY_COLUMN_INDEX, "orangehrm-attachment");
        for(String file:uploadedFiles) {
            if (file.trim().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    @Step("Click on Save button at Attachments")
    public ToastMessageObject clickOnSaveButtonAtAttachments() {
        waitForElementClickable(driver, EmergencyContactsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Attachment", "Save");
        clickOnElement(driver, EmergencyContactsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Attachment", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Click on Save button at Assigned Emergency Contacts")
    public ToastMessageObject clickOnSaveButtonOfAssignedEmergencyContacts() {
        waitForElementClickable(driver, EmergencyContactsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Save Emergency Contact", "Save");
        clickOnElement(driver, EmergencyContactsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Save Emergency Contact", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    public void waitAllLoadingIconInvisible(WebDriver driver){
        waitForElementInvisible(driver, EmergencyContactsPageUI.LOADING_ICON);
    }

}
