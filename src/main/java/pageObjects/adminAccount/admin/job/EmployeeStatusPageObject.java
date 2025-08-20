package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EmployeeStatusPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EmployeeStatusPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
