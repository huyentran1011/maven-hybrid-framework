package pageUIs;

public class BasePageUI {
    public static final String UPLOAD_FILE_FIELD = "css=input[type='file']";

    public static final String TEXTBOX_BY_LABEL = "xpath=//label[text()=\"%s\"]/../following-sibling::div/input";
    public static final String TEXTBOX_BY_NAME = "name=%s";
    public static final String TIME_PICKER_TEXTBOX_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div//input";

    public static final String RADIO_BUTTON_BY_LABEL = "xpath=//label[contains(.,'%s')]/span";

    public static final String BUTTON_BY_TEXT = "xpath=//button[contains(.,'%s')]";

    public static final String DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/../following-sibling::div/div";
    public static final String CHILD_LIST_OF_DROPDOWN = "xpath=//div[@role='option']/span";



}
