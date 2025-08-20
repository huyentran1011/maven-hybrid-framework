package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddEmployeeStatusPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddEmployeeStatusPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
