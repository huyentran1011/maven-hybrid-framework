package pageObjects.adminAccount.myInfo;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.adminAccount.myInfo.MyInfoPageUI;

public class MyInfoPageObject extends BasePage {
    WebDriver driver;
    public MyInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the Profile Image.")
    public void clickOnProfileImage() {
        waitForElementClickable(driver, MyInfoPageUI.PROFILE_IMAGE);
        clickOnElement(driver, MyInfoPageUI.PROFILE_IMAGE);
    }

    @Step("Click on the Save button")
    public void clickOnSaveButton() {
        waitForElementClickable(driver, MyInfoPageUI.SAVE_BUTTON);
        clickOnElement(driver, MyInfoPageUI.SAVE_BUTTON);
    }
}
