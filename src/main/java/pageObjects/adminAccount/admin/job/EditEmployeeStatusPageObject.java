package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditEmployeeStatusPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditEmployeeStatusPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
