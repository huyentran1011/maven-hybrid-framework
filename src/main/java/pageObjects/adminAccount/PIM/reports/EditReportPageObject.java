package pageObjects.adminAccount.PIM.reports;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class EditReportPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public EditReportPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
