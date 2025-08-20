package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditPayGradePageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditPayGradePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
