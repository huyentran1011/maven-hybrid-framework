package pageObjects.adminAccount.PIM.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class TerminationReasonPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public TerminationReasonPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
