package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditWorkShiftPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditWorkShiftPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
