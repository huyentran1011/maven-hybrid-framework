package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddPayGradePageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddPayGradePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
