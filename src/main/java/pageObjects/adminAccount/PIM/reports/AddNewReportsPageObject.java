package pageObjects.adminAccount.PIM.reports;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class AddNewReportsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public AddNewReportsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
