package pageObjects.adminAccount.admin.job;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class WorkShiftsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public WorkShiftsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
