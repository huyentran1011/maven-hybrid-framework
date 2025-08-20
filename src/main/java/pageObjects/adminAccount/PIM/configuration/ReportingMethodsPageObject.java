package pageObjects.adminAccount.PIM.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class ReportingMethodsPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public ReportingMethodsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
