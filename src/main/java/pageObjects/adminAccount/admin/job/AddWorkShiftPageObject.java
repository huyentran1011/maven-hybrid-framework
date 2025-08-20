package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddWorkShiftPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddWorkShiftPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
