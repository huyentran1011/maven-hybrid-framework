package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class JobCategoriesPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public JobCategoriesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
