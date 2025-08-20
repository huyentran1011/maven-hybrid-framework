package pageObjects.adminAccount.admin.organization;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddLocationPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddLocationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
