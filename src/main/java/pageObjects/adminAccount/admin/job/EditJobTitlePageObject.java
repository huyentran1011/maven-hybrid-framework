package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditJobTitlePageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditJobTitlePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
