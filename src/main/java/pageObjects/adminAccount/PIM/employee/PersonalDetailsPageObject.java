package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends EmployeeSubMenuObject {

    private WebDriver driver;
    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter License Expired Date: {0}.")
    public void enterLicenseExpiredDate(String expiryDate) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, "License Expiry Date");
        sendKeyIntoElement(driver, PersonalDetailsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, expiryDate, "License Expiry Date");
    }

    @Step("Enter Driver License Number: {0}.")
    public void enterDriverLicenseNumber(String driverLicenseNum) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Driver's License Number");
        sendKeyIntoElement(driver, PersonalDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, driverLicenseNum, "Driver's License Number");
    }

    @Step("Select Nationality: {0}.")
    public void selectNationality(String nationality) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Nationality");
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, PersonalDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                nationality, "Nationality");
    }

    @Step("Select Martial Status: {0}.")
    public void selectMaritalStatus(String maritalStatus) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Marital Status");
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, PersonalDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                maritalStatus, "Marital Status");
    }

    @Step("Enter date of birth: {0}.")
    public void enterDateOfBirth(String dateOfBirth) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, "Date of Birth");
        sendKeyIntoElement(driver, PersonalDetailsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, dateOfBirth, "Date of Birth");
    }

    @Step("Click on the 'Female' radio button.")
    public void selectFemaleRadioButton() {
        waitForElementClickable(driver, PersonalDetailsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, "Female");
        clickOnElement(driver, PersonalDetailsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, "Female");
    }

    @Step("Click on the 'Save' button of Personal Details")
    public ToastMessageObject clickOnSaveButtonOfPersonalDetails() {
        waitForElementClickable(driver, PersonalDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Personal Details", "Save");
        clickOnElement(driver, PersonalDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Personal Details", "Save");
        return PageGenerator.getToastMessage(driver);
    }

    @Step("Get employee Firstname.")
    public String getFirstName() {
        waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
        return getDomPropertyValue(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    @Step("Get employee Lastname.")
    public String getLastName() {
        waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX);
        return getDomPropertyValue(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX, "value");
    }

    @Step("Get Employee ID.")
    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "Employee Id");
        return getDomPropertyValue(driver, PersonalDetailsPageUI.DYNAMIC_TEXTBOX_BY_LABEL, "value", "Employee Id");
    }


    @Step("Get employee Fullname.")
    public String getFullName(String fullName){
        waitForTextToBePresentInElement(driver, PersonalDetailsPageUI.EMPLOYEE_FULL_NAME_TEXT, fullName);
        return getElementText(driver, PersonalDetailsPageUI.EMPLOYEE_FULL_NAME_TEXT);
    }


    @Step("Click on the Profile Image.")
    public ChangeProfilePicturePageObject clickOnProfileImage() {
        waitForElementClickable(driver, PersonalDetailsPageUI.PROFILE_IMAGE);
        clickOnElement(driver, PersonalDetailsPageUI.PROFILE_IMAGE);
        return PageGenerator.getChangeProfileImagePage(driver);
    }

}
