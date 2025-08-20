package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter username: {0}")
    public void enterToUsernameTextbox(String username){
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyIntoElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    @Step("Enter password: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyIntoElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click on the Login button.")
    public void clickOnLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickOnElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
    @Step("Verify that is the Login button displayed.")
    public boolean isLoginButtonDisplayed(){
        return isElementDisplayed(driver, LoginPageUI.LOGIN_BUTTON);
    }

    @Step("Login to system by username and password: {0} and {1}.")
    public SideBarAndTopBarObject loginToSystem(String username, String password){
        enterToUsernameTextbox(username);
        enterToPasswordTextbox(password);
        clickOnLoginButton();
        return PageGenerator.getSideBarAndTopBar(driver);
    }

}
