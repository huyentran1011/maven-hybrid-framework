package pageUIs.adminAccount.PIM.employee;

public class AddEmployeePageUI {
    public static final String FIRSTNAME_TEXTBOX = "name=firstName";
    public static final String LASTNAME_TEXTBOX = "name=lastName";
    public static final String TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div/input";
    public static final String CREATE_LOGIN_DETAILS_BUTTON = "xpath=//input[@type='checkbox']/following-sibling::span";
    public static final String RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/span";
    public static final String BUTTON_BY_NAME_AND_CONTAINER = "xpath=//h6[text()='%s']/following-sibling::form/div/button[contains(.,'%s')]";
}
