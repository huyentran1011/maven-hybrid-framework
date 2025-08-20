package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.adminAccount.dashboard.DashboardPageObject;
import pageObjects.adminAccount.myInfo.MyInfoPageObject;
import pageObjects.adminAccount.PIM.employee.*;

public class PageGenerator {
    @Step("Get Add Employee Page Object.")
    public static AddEmployeePageObject getAddEmployeePage(WebDriver driver){
        return new AddEmployeePageObject(driver);
    }

    @Step("Get Dashboard Page Object.")
    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }

    @Step("Get Login Employee List Page Object.")
    public static EmployeeListPageObject getEmployeeListPage(WebDriver driver){
        return new EmployeeListPageObject(driver);
    }

    @Step("Get Login Page Object.")
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    @Step("Get Personal Details Page Object.")
    public static PersonalDetailsPageObject getPersonalDetailsPage(WebDriver driver){
        return new PersonalDetailsPageObject(driver);
    }

    @Step("Get Contact Details Page Object.")
    public static ContactDetailsPageObject getContactDetailsPage(WebDriver driver){
        return new ContactDetailsPageObject(driver);
    }

    @Step("Get Emergency Contacts Page Object.")
    public static EmergencyContactsPageObject getEmergencyContactsPage(WebDriver driver){
        return new EmergencyContactsPageObject(driver);
    }

    @Step("Get Dependents Page Object.")
    public static DependentsPageObject getDependentsPage(WebDriver driver){
        return new DependentsPageObject(driver);
    }

    @Step("Get Job Details Object.")
    public static JobDetailsPageObject getJobDetailsPage(WebDriver driver){
        return new JobDetailsPageObject(driver);
    }

    @Step("Get Salary Object.")
    public static SalaryPageObject getSalaryPage(WebDriver driver){
        return new SalaryPageObject(driver);
    }

    @Step("Get Side Bar and Top Bar Object.")
    public static SideBarAndTopBarObject getSideBarAndTopBar(WebDriver driver){
        return new SideBarAndTopBarObject(driver);
    }

    @Step("Get Toast Message Object.")
    public static ToastMessageObject getToastMessage(WebDriver driver){
        return new ToastMessageObject(driver);
    }

    public static UserManagementPageObject getUserManagementPage(WebDriver driver){
        return new UserManagementPageObject(driver);
    }

    @Step("Get Edit USer Page Object.")
    public static EditUserPageObject getEditUserPage(WebDriver driver){
        return new EditUserPageObject(driver);
    }

    @Step("Get My Info Page Object.")
    public static MyInfoPageObject getMyInfoPage(WebDriver driver){
        return new MyInfoPageObject(driver);
    }

    @Step("Get Change Profile Image Page Object.")
    public static ChangeProfilePicturePageObject getChangeProfileImagePage(WebDriver driver){
        return new ChangeProfilePicturePageObject(driver);
    }

    @Step("Get Employee Submenu Object.")
    public static EmployeeSubMenuObject getEmployeeSubmenu(WebDriver driver){
        return new EmployeeSubMenuObject(driver);
    }
}
