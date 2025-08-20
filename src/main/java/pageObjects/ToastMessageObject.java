package pageObjects;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.ToastMessageUI;

public class ToastMessageObject extends BasePage {
    private WebDriver driver;

    public ToastMessageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get content of Toast Message to verify.")
    public String getMessageContent() {
        waitForElementVisible(driver, ToastMessageUI.MESSAGE_CONTENT);
        return getElementText(driver, ToastMessageUI.MESSAGE_CONTENT);
    }

    @Step("Get title of Toast Message to verify.")
    public String getMessageTitle() {
        waitForElementVisible(driver, ToastMessageUI.MESSAGE_TITLE);
        return getElementText(driver, ToastMessageUI.MESSAGE_TITLE);
    }
}
