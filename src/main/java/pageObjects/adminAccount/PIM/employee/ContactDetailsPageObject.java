package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.ContactDetailsPageUI;

import java.util.List;

public class ContactDetailsPageObject extends EmployeeSubMenuObject {

    private WebDriver driver;
    public ContactDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter Street 1: {0}.")
    public void enterStreet1(String street1) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Street 1");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, street1, "Street 1");
    }

    @Step("Enter Street 2: {0}.")
    public void enterStreet2(String street2) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Street 2");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, street2, "Street 2");
    }

    @Step("Enter City: {0}.")
    public void enterCity(String city) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "City");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, city, "City");
    }

    @Step("Enter State/Province: {0}.")
    public void enterStateOrProvince(String stateOrProvince) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "State/Province");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, stateOrProvince, "State/Province");
    }

    @Step("Enter Zip/Postal Code: {0}.")
    public void enterZipOrPostalCode(String ZipOrPostalCode) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Zip/Postal Code");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, ZipOrPostalCode, "Zip/Postal Code");
    }

    @Step("Select Country: {0}.")
    public void selectCountry(String country) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Country");
        selectItemInCustomDropdown(driver, ContactDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, ContactDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                country, "Country");
    }

    @Step("Enter Home Telephone: {0}.")
    public void enterHomeTelephone(String homeTelephone) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Home");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, homeTelephone, "Home");
    }

    @Step("Enter Mobile Telephone: {0}.")
    public void enterMobileTelephone(String mobileTelephone) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Mobile");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, mobileTelephone, "Mobile");
    }

    @Step("Enter Work Telephone: {0}.")
    public void enterWorkTelephone(String workTelephone) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Work");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, workTelephone, "Work");
    }

    @Step("Enter Work Email: {0}.")
    public void enterWorkEmail(String workEmail) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Work Email");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, workEmail, "Work Email");
    }

    @Step("Enter Other Email: {0}.")
    public void enterOtherEmail(String otherEmail) {
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Other Email");
        sendKeyIntoElement(driver, ContactDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, otherEmail, "Other Email");
    }

    @Step("Click on Add button at Attachments")
    public void clickOnAddButtonAtAttachments() {
        waitForElementClickable(driver, ContactDetailsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Attachments");
        clickOnElement(driver, ContactDetailsPageUI.DYNAMIC_ADD_BUTTON_AT_CONTAINER, "Attachments");
    }

    @Step("Click on Save button at Attachments")
    public ToastMessageObject clickOnSaveButtonAtAttachments() {
        waitForElementClickable(driver, ContactDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Attachment", "Save");
        clickOnElement(driver, ContactDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Add Attachment", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Click on Save button at Contact Details")
    public ToastMessageObject clickOnSaveButtonAtContactDetails() {
        waitForElementClickable(driver, ContactDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Contact Details", "Save");
        clickOnElement(driver, ContactDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Contact Details", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Verify that the uploaded file is displayed on the Attachments table.")
    public boolean isUploadedFileDisplayed(String fileName){
        waitAllLoadingIconInvisible(driver);
        waitForElementVisible(driver, ContactDetailsPageUI.DYNAMIC_TABLE, "orangehrm-attachment");
        List<String> uploadedFiles = getAllValueByColumnName(driver,ContactDetailsPageUI.DYNAMIC_COLUMN_HEADER, "File Name", ContactDetailsPageUI.DYNAMIC_CELL_BY_COLUMN_INDEX, "orangehrm-attachment");
        for(String file:uploadedFiles) {
            if (file.trim().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public void waitAllLoadingIconInvisible(WebDriver driver) {
        waitForElementInvisible(driver, ContactDetailsPageUI.LOADING_ICON);
    }
}
