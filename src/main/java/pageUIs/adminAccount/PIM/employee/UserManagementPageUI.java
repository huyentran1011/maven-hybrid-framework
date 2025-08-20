package pageUIs.adminAccount.PIM.employee;

public class UserManagementPageUI {
    public static final String DYNAMIC_CELLS_BY_ROW_INDEX = "xpath=//div[contains(@class,'table-body')]/div[contains(@class,'table-card')][%s]//div[@role='cell']";
    public static final String DYNAMIC_ACTION_ICON = "xpath=//div[text()='%s']/parent::div/following-sibling::div//button/i[contains(@class,'%s')]";
    public static final String DYNAMIC_CHECKBOX_BY_USERNAME = "xpath=//div[text()='%s']/parent::div/preceding-sibling::div//span";

    public static final String USERNAME_TEXTBOX = "xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
    public static final String ROLE_DROPDOWN_MENU = "xpath=//label[text()='User Role']/parent::div/following-sibling::div//div[contains(@class,'input')]";
    public static final String CHILD_LIST_IN_DROPDOWN = "xpath=//div[@role='option']/span";
    public static final String EMPLOYEE_NAME_TEXTBOX = "xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";
    public static final String EMPLOYEE_NAME_LIST_BOX = "xpath=//div[@role='option']/span[normalize-space(text())='%s']";
    public static final String STATUS_DROPDOWN_MENU = "xpath=//label[text()='Status']/parent::div/following-sibling::div//div[contains(@class,'input')]";
    public static final String SEARCH_BUTTON = "xpath=//button[contains(.,'Search')]";
    public static final String RESET_BUTTON = "xpath=//button[contains(.,'Reset')]";
    public static final String NUMBER_RECORD_FOUND = "xpath=//span[contains(.,'Found')]";
    public static final String CONFIRM_DELETE_BUTTON = "xpath=//button[contains(.,'Yes, Delete')]";
    public static final String ALL_RECORDS_CHECKBOX = "xpath=//div[@role='columnheader']//span[contains(@class,'oxd-checkbox-input')]";
    public static final String DELETE_SELECTED_BUTTON = "xpath=//button[contains(., 'Delete Selected')]";
}
