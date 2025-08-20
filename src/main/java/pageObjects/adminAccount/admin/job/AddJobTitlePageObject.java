package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddJobTitlePageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddJobTitlePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
