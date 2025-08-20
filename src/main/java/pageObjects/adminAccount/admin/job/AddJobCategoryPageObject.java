package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddJobCategoryPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddJobCategoryPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
