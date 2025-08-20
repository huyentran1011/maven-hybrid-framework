package pageObjects.adminAccount.dashboard;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class DashboardPageObject extends SideBarAndTopBarObject {
    private WebDriver driver;
    public DashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
