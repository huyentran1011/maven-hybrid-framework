package pageObjects.adminAccount.PIM.configuration;

import org.openqa.selenium.WebDriver;
import pageObjects.SideBarAndTopBarObject;

public class DataImportPageObject extends SideBarAndTopBarObject {
    WebDriver driver;

    public DataImportPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
