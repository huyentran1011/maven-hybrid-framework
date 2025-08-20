package pageObjects.adminAccount.PIM.employee;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.SideBarAndTopBarObject;
import pageUIs.adminAccount.PIM.employee.EmployeeListPageUI;

public class EmployeeListPageObject extends SideBarAndTopBarObject {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Click on the Add button.")
    public AddEmployeePageObject clickOnAddButton() {
        waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
        clickOnElement(driver, EmployeeListPageUI.ADD_BUTTON);
        return PageGenerator.getAddEmployeePage(driver);
    }
}
