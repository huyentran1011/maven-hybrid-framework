package pageObjects.adminAccount.admin.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class SystemUsersPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public SystemUsersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
