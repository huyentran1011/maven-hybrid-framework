package pageObjects.adminAccount.admin.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddUserPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddUserPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
