package pageObjects.adminAccount.PIM.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class CustomFieldsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public CustomFieldsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
