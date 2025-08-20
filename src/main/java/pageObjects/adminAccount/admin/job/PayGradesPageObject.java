package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class PayGradesPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public PayGradesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
