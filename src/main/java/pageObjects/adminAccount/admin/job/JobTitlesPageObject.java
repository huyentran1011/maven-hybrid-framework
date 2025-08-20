package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class JobTitlesPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public JobTitlesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
