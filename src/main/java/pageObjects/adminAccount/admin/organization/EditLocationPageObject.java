package pageObjects.adminAccount.admin.organization;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditLocationPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditLocationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
