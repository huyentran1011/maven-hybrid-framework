package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.SidePanelAndTopBarUI;

public class SideBarAndTopBarObject extends BasePage {
    private WebDriver driver;

    public SideBarAndTopBarObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the '{0}' menu.")
    public void clickOnSideMenu(String menuName){
        waitForElementClickable(driver, SidePanelAndTopBarUI.DYNAMIC_MENU_BY_PAGE_NAME, menuName);
        clickOnElement(driver, SidePanelAndTopBarUI.DYNAMIC_MENU_BY_PAGE_NAME, menuName);
    }

    @Step("Verify a menu is displayed: {0}")
    public boolean isMenuDisplayed(String menuName){
        return isElementDisplayed(driver, SidePanelAndTopBarUI.DYNAMIC_MENU_BY_PAGE_NAME, menuName);
    }

    @Step("Verify a menu is undisplayed: {0}")
    public boolean isMenuUndisplayed(String menuName){
        return isElementUndisplayed(driver, SidePanelAndTopBarUI.DYNAMIC_MENU_BY_PAGE_NAME, menuName);
    }

    @Step("Click on the Profile picture.")
    public void clickOnProfilePicture(){
        waitForElementClickable(driver, SidePanelAndTopBarUI.PROFILE_PICTURE);
        clickOnElement(driver, SidePanelAndTopBarUI.PROFILE_PICTURE);
    }

    @Step("Log out.")
    public LoginPageObject logout() {
        clickOnProfilePicture();
        waitForElementClickable(driver, SidePanelAndTopBarUI.LOGOUT_MENU_ITEM);
        clickOnElement(driver, SidePanelAndTopBarUI.LOGOUT_MENU_ITEM);
        return PageGenerator.getLoginPage(driver);
    }

    @Step("Get full name of logged in user.")
    public String getFullName() {
        waitForElementVisible(driver, SidePanelAndTopBarUI.PROFILE_FULL_NAME);
        return getElementText(driver, SidePanelAndTopBarUI.PROFILE_FULL_NAME);
    }
}
