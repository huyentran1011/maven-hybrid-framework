package pageObjects.adminAccount.admin.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditUserPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditUserPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
