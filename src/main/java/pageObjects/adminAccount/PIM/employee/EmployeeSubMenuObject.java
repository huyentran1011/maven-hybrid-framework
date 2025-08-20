package pageObjects.adminAccount.PIM.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.adminAccount.PIM.employee.EmployeeSubMenuUI;

public class EmployeeSubMenuObject extends BasePage {

    private WebDriver driver;

    public EmployeeSubMenuObject(WebDriver driver) {
        this.driver = driver;

    }

    @Step("Click on the {0} menu.")
    public void clickOnEmployeeSubMenu(String menuName) {
        waitForElementClickable(driver, EmployeeSubMenuUI.DYNAMIC_MENU_BY_TEXT, menuName);
        clickOnElement(driver, EmployeeSubMenuUI.DYNAMIC_MENU_BY_TEXT, menuName);
    }
}
