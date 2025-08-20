package pageUIs.adminAccount.PIM.employee;

public class PersonalDetailsPageUI {

    public static final String DYNAMIC_TEXTBOX_BY_LABEL = "xpath=//label[text()=\"%s\"]/../following-sibling::div/input";
    public static final String DYNAMIC_DATE_TIME_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div//input";
    public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/span";
    public static final String DYNAMIC_BUTTON_BY_NAME_AND_CONTAINER = "xpath=//h6[text()='%s']/following-sibling::form/div/button[contains(.,'%s')]";
    public static final String DYNAMIC_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div/div";
    public static final String CHILD_LIST_OF_DROPDOWN = "xpath=//div[@role='option']/span";
    public static final String EMPLOYEE_FULL_NAME_TEXT = "xpath=//div[@class='orangehrm-edit-employee-name']/h6";
    public static final String FIRSTNAME_TEXTBOX = "name=firstName";
    public static final String LASTNAME_TEXTBOX = "name=lastName";
    public static final String PROFILE_IMAGE = "css=img.employee-image";
}
