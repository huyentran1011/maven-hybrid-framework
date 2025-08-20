package pageObjects.adminAccount.PIM.employee;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageObjects.ToastMessageObject;
import pageUIs.adminAccount.PIM.employee.EditUserPageUI;

public class EditUserPageObject extends SideBarAndTopBarObject {
    WebDriver driver;
    public EditUserPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectUserRole(String role) {
        waitForElementVisible(driver, EditUserPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "User Role");
        selectItemInCustomDropdown(driver, EditUserPageUI.DYNAMIC_DROPDOWN_BY_LABEL, EditUserPageUI.CHILD_LIST_OF_DROPDOWN,
                role, "User Role");
    }

    public void selectStatus(String status) {
        waitForElementVisible(driver, EditUserPageUI.DYNAMIC_DROPDOWN_BY_LABEL, "Status");
        selectItemInCustomDropdown(driver, EditUserPageUI.DYNAMIC_DROPDOWN_BY_LABEL, EditUserPageUI.CHILD_LIST_OF_DROPDOWN,
                status, "Status");
    }

    public void enterToUsernameTextbox(String username) {
        waitForElementVisible(driver, EditUserPageUI.DYNAMIC_TEXTBOX, "Username");
        sendKeyIntoElement(driver, EditUserPageUI.DYNAMIC_TEXTBOX, username, "Username");
    }

    public void clickToChangePasswordCheckbox(){
        waitForElementClickable(driver, EditUserPageUI.CHANGE_PASSWORD_CHECKBOX);
        clickOnElement(driver, EditUserPageUI.CHANGE_PASSWORD_CHECKBOX);
    }

    public void enterToPasswordTextbox(String password){
        waitForElementVisible(driver, EditUserPageUI.DYNAMIC_TEXTBOX, "Password");
        sendKeyIntoElement(driver, EditUserPageUI.DYNAMIC_TEXTBOX, password, "Password");
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword){
        waitForElementVisible(driver, EditUserPageUI.DYNAMIC_TEXTBOX, "Confirm Password");
        sendKeyIntoElement(driver, EditUserPageUI.DYNAMIC_TEXTBOX, confirmPassword, "Confirm Password");
    }

    public ToastMessageObject clickToSaveButton() {
        waitForElementClickable(driver, EditUserPageUI.SAVE_BUTTON);
        clickOnElement(driver, EditUserPageUI.SAVE_BUTTON);
        return PageGenerator.getToastMessage(driver);
    }
}
