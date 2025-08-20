package pageObjects.adminAccount.admin.organization;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class LocationsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public LocationsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
