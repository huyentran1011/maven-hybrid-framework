package pageObjects.adminAccount.PIM.reports;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class ReportDetailsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public ReportDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
