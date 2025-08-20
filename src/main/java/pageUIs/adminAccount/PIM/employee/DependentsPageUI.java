package pageUIs.adminAccount.PIM.employee;

public class DependentsPageUI {
    public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()=\"%s\"]/../following-sibling::div/input";
    public static final String DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div//input";
    public static final String DYNAMIC_ADD_BUTTON_AT_CONTAINER = "xpath=//h6[text()='%s']/following-sibling::button[contains(.,'Add')]";
    public static final String DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER = "xpath=//h6[text()='%s']/following-sibling::form/div/button[contains(.,'%s')]";
    public static final String DYNAMIC_CELL_BY_COLUMN_INDEX = "xpath=//div[@class='%s']//div[@role='cell'][%s]";
    public static final String DYNAMIC_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div/div";
    public static final String CHILD_LIST_OF_DROPDOWN = "xpath=//div[@role='option']/span";
    public static final String DYNAMIC_TABLE = "xpath=//div[@class='%s']//div[@role='table']";
    public static final String DYNAMIC_COLUMN_HEADER = "xpath=//div[@class='%s']//div[@role='columnheader']";
    public static final String LOADING_ICON = "css=div.oxd-loading-spinner";
}
