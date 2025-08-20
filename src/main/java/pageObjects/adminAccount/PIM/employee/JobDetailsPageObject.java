package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.JobDetailsPageUI;
import pageUIs.adminAccount.PIM.employee.PersonalDetailsPageUI;

public class JobDetailsPageObject extends EmployeeSubMenuObject {

    private WebDriver driver;
    public JobDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter Joined Date: {0}.")
    public void enterJoinedDate(String joinedDate) {
        waitForElementVisible(driver, JobDetailsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, "Joined Date");
        sendKeyIntoElement(driver, JobDetailsPageUI.DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL, joinedDate, "Joined Date");
    }
    @Step("Select Job Title: {0}.")
    public void selectJobTitle(String jobTitle) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Job Title");
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, PersonalDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                jobTitle, "Job Title");
    }

    @Step("Select Job Category: {0}.")
    public void selectJobCategory(String jobCategory) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Job Category");
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, PersonalDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                jobCategory, "Job Category");
    }

    @Step("Select Location: {0}.")
    public void selectLocation(String location) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Location");
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, PersonalDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                location, "Location");
    }

    @Step("Select Employment Status: {0}.")
    public void selectEmploymentStatus(String employeeStatus) {
        waitForElementVisible(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Employment Status");
        selectItemInCustomDropdown(driver, PersonalDetailsPageUI.DYNAMIC_DROPDOWN_BY_LABEL, PersonalDetailsPageUI.CHILD_LIST_OF_DROPDOWN,
                employeeStatus, "Employment Status");
    }

    @Step("Click on Save button at Job Details.")
    public ToastMessageObject clickOnSaveButtonOfJobDetails() {
        waitForElementClickable(driver, PersonalDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Job Details", "Save");
        clickOnElement(driver, PersonalDetailsPageUI.DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER, "Job Details", "Save");
        return PageGenerator.getToastMessage(driver);
    }
}
