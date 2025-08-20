package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;
import pageUIs.adminAccount.PIM.employee.ChangeProfilePicturePageUI;

public class ChangeProfilePicturePageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public ChangeProfilePicturePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click on the Profile Image.")
    public void clickOnProfileImage() {
        waitForElementClickable(driver, ChangeProfilePicturePageUI.PROFILE_IMAGE);
        clickOnElement(driver, ChangeProfilePicturePageUI.PROFILE_IMAGE);
    }

    @Step("Click on the Save button")
    public void clickOnSaveButton() {
        waitForElementClickable(driver, ChangeProfilePicturePageUI.BUTTON_BY_NAME_AND_CONTAINER, "Change Profile Picture", "Save");
        clickOnElement(driver, ChangeProfilePicturePageUI.BUTTON_BY_NAME_AND_CONTAINER, "Change Profile Picture", "Save");
    }

    @Step("Get Profile Image size.")
    public Dimension getProfilePictureSize() {
        return getElementSize(driver, ChangeProfilePicturePageUI.PROFILE_IMAGE);
    }

    public boolean isProfilePictureUpdateSuccess(Dimension sizeBeforeUpload) {
        Dimension sizeAfterUpload = getProfilePictureSize();
        return !sizeBeforeUpload.equals(sizeAfterUpload);
    }
}