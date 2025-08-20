package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditJobCategoryPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditJobCategoryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
