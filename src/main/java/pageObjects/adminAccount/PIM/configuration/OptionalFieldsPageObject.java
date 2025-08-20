package pageObjects.adminAccount.PIM.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class OptionalFieldsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public OptionalFieldsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
