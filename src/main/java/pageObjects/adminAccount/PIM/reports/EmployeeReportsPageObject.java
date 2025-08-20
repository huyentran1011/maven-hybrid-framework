package pageObjects.adminAccount.PIM.reports;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EmployeeReportsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EmployeeReportsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
