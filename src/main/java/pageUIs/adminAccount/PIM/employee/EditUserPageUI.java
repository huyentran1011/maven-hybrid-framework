package pageUIs.adminAccount.PIM.employee;

public class EditUserPageUI {
    public static final String DYNAMIC_DROPDOWN_BY_LABEL = "xpath://label[contains(.,'%s')]/../following-sibling::div/div";
    public static final String CHILD_LIST_OF_DROPDOWN = "xpath=//div[@role='option']/span";
    public static final String DYNAMIC_TEXTBOX = "xpath=//label[contains(.,'%s')]/parent::div/following-sibling::div//input[contains(@class,'input')]";
    public static final String CHANGE_PASSWORD_CHECKBOX = "xpath=//label[contains(.,'Change Password ?')]/parent::div/following-sibling::div//span";
    public static final String SAVE_BUTTON = "xpath=//button[contains(.,'Save')]";

}
