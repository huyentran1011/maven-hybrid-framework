package commons;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUIs.BasePageUI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static BasePage getBasePage(){
        return new BasePage();
    }

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    private String castParameter(String locator, String...restParameter){
        return String.format(locator, (Object[]) restParameter);
    }
    private By getElementByLocator(String prefixLocator){
        By by = null;
        if(prefixLocator.toUpperCase().startsWith("ID")){
            by = By.id(prefixLocator.substring(3));
        }  else if(prefixLocator.toUpperCase().startsWith("CLASS")){
            by = By.className(prefixLocator.substring(6));
        } else if(prefixLocator.toUpperCase().startsWith("NAME")){
            by = By.name(prefixLocator.substring(5));
        } else if(prefixLocator.toUpperCase().startsWith("TAGNAME")){
            by = By.tagName(prefixLocator.substring(3));
        } else if(prefixLocator.toUpperCase().startsWith("XPATH")){
            by = By.xpath(prefixLocator.substring(6));
        } else if(prefixLocator.toUpperCase().startsWith("CSS")){
            by = By.cssSelector(prefixLocator.substring(4));
        } else {
            throw new RuntimeException("Locator type is not supported!");
        }
        return by;
    }

    private By getElementByXPath(String locator){
        return By.xpath(locator);
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.visibilityOfElementLocated(getElementByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.visibilityOfElementLocated(getElementByLocator(castParameter(locator, restParameter))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getElementByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.elementToBeClickable(getElementByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).
                until(ExpectedConditions.elementToBeClickable(getElementByLocator(castParameter(locator, restParameter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.invisibilityOfElementLocated(getElementByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.invisibilityOfElementLocated(getElementByLocator(castParameter(locator, restParameter))));
    }

    public void waitForListElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver,locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(getElementByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.presenceOfElementLocated(getElementByLocator(castParameter(locator, restParameter))));
    }

    public void waitForListElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getElementByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.elementToBeSelected(getElementByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.elementToBeSelected(getElementByLocator(castParameter(locator, restParameter))));
    }

    public void waitForTextToBePresentInElement(WebDriver driver, String locator, String expectedText){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.textToBePresentInElementLocated(getElementByLocator(locator), expectedText));
    }

    public void waitForTextToBePresentInElement(WebDriver driver, String locator, String expectedText, String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT)).until(ExpectedConditions.textToBePresentInElementLocated(getElementByLocator(castParameter(locator, restParameter)), expectedText));
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String keysToSend) {
        waitForAlertPresence(driver).sendKeys(keysToSend);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getElementByLocator(locator));
    }

    protected List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getElementByLocator(locator));
    }

    protected List<WebElement> getListElements(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getElementByLocator(castParameter(locator, restParameter)));
    }


    public void clickOnElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickOnElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).click();
    }

    public void sendKeyIntoElement(WebDriver driver, String locator, String keysToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void sendKeyIntoElement(WebDriver driver, String locator, String keysToSend, String... restParameter) {
        getElement(driver, castParameter(locator, restParameter)).clear();
        getElement(driver, castParameter(locator, restParameter)).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textToSelect) {
        new Select(getElement(driver, locator)).selectByVisibleText(textToSelect);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String textToSelect, String... restParameter) {
        new Select(getElement(driver, castParameter(locator, restParameter))).selectByVisibleText(textToSelect);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator, String... restParameter) {
        return new Select(getElement(driver, castParameter(locator, restParameter))).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator, String... restParameter) {
        return new Select(getElement(driver, castParameter(locator, restParameter))).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSeconds(2);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator.substring(6))));
        sleepInSeconds(2);

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem, String... restParameter) {
        getElement(driver, castParameter(parentLocator, restParameter)).click();
        sleepInSeconds(2);

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator.substring(6))));
        sleepInSeconds(2);

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getDomAttributeValue(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getDomAttribute(attributeName);
    }

    public String getDomAttributeValue(WebDriver driver, String locator, String attributeName, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getDomAttribute(attributeName);
    }

    public String getDomPropertyValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getDomProperty(propertyName);
    }

    public String getDomPropertyValue(WebDriver driver, String locator, String propertyName, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getDomProperty(propertyName);
    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getText();
    }

    public Dimension getElementSize(WebDriver driver, String locator){
        return getElement(driver, locator).getSize();
    }

    public String getCSSValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getCSSValue(WebDriver driver, String locator, String propertyName, String... restParameter) {
        return getElement(driver, castParameter(locator, restParameter)).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

//    public int getElementSize(WebDriver driver, String locator) {
//        return getListElements(driver, locator).size();
//    }

    public void checkTheCheckboxOrRadio(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckTheCheckbox(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        waitForElementVisible(driver, locator);
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParameter) {
        waitForElementVisible(driver, castParameter(locator, restParameter));
        return getElement(driver, castParameter(locator, restParameter)).isDisplayed();
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator){
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME_OUT);
        List<WebElement> elements = getListElements(driver, locator);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);
        
        if(elements.isEmpty()){
            // Element is not in DOM
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            // Element is in DOM but not displayed
            return true;
        } else{
            // Element is in DOM and displayed.
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator, String... restParameter){
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIME_OUT);
        List<WebElement> elements = getListElements(driver, locator, restParameter);
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIME_OUT);

        if(elements.isEmpty()){
            // Element is not in DOM
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            // Element is in DOM but not displayed
            return true;
        } else{
            // Element is in DOM and displayed.
            return false;
        }
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public void switchToIFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickElement(WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
        new Actions(driver).clickAndHold(getElement(driver, locator)).perform();
    }

    public void rightClickElement(WebDriver driver, String locator) {
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).build().perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void sendKeyboardToAnElement(WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getElement(driver, locator), key).perform();
    }

    public void releaseLeftMouse(WebDriver driver){
        new Actions(driver).release();
    }

    public void highlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getDomAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickOnElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendKeyIntoElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
    }

    @Step("Upload files: {1}")
    public void uploadMultipleFiles(WebDriver driver, String... fileNames){
        String uploadFileLocation = "";
        for(String file:fileNames){
            uploadFileLocation = uploadFileLocation + GlobalConstants.UP_LOAD_FILE_PATH + file + "\n";
        }
        uploadFileLocation = uploadFileLocation.trim();
        getElement(driver, BasePageUI.UPLOAD_FILE_FIELD).sendKeys(uploadFileLocation);
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Cookie> getAllCookies(WebDriver driver){
        return driver.manage().getCookies();
    }

    public void setCookie(WebDriver driver, Set<Cookie> cookies){
        for (Cookie cookie:cookies){
            driver.manage().addCookie(cookie);
        }
        sleepInSeconds(3);
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeout){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public int getColumnIndex(WebDriver driver, String headerLocators, String columnName, String tableName){
        int columnNum = 0;

        List<WebElement> headerElements = getListElements(driver, headerLocators, tableName);
        for(WebElement element:headerElements){
            columnNum++;
            if(element.getText().contains(columnName)) {
                break;
            }
        }
        return columnNum;
    }

    public List<String> getAllValueByColumnName(WebDriver driver, String headerLocators, String columnName, String cellLocatorsByColumIndex, String tableName){
        List<String> valuesByColumn = new ArrayList<>();
        String columnIndex = String.valueOf(getColumnIndex(driver, headerLocators, columnName, tableName));
        List<WebElement> cellElements = getListElements(driver, cellLocatorsByColumIndex, tableName, columnIndex);
        for(int i = 0; i < cellElements.size(); i++){
            valuesByColumn.add(cellElements.get(i).getText());
        }
        return valuesByColumn;
    }

    public List<String> getAllDataByRowIndex(WebDriver driver, String cellLocatorsByRowIndex, String rowNumber){
        waitForElementVisible(driver, cellLocatorsByRowIndex, rowNumber);
        List<WebElement> cellElements = getListElements(driver, cellLocatorsByRowIndex, rowNumber);
        List<String> allDataInRow = new ArrayList<>();
        for(int i = 1; i < cellElements.size(); i++){
            allDataInRow.add(cellElements.get(i).getText());
        }
        return allDataInRow;
    }

//    public void waitForLoadingSpinnerDisable(WebDriver driver){
//        waitForElementInvisible(driver, "div.oxd-loading-spinner");
//    }

    // These lines of code for Pattern Object
    @Step("Enter value into the '{1}' textbox: {2}")
    public void enterValueIntoTextboxByLabel(WebDriver driver, String elementLabel, String inputValue){
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_LABEL, elementLabel);
        sendKeyIntoElement(driver, BasePageUI.TEXTBOX_BY_LABEL, inputValue, elementLabel);
    }

    @Step("Enter value into the '{1}' textbox: {2}")
    public void enterValueIntoTextboxByNameAttribute(WebDriver driver, String nameAttributeValue, String inputValue){
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_NAME, nameAttributeValue);
        sendKeyIntoElement(driver, BasePageUI.TEXTBOX_BY_NAME, inputValue, nameAttributeValue);
    }

    @Step("Enter value into the '{1}' textbox: {2}")
    public void enterValueIntoDatePickerTextboxByLabel(WebDriver driver, String elementLabel, String inputValue){
        waitForElementVisible(driver, BasePageUI.TIME_PICKER_TEXTBOX_BY_LABEL, elementLabel);
        sendKeyIntoElement(driver, BasePageUI.TIME_PICKER_TEXTBOX_BY_LABEL, inputValue, elementLabel);
    }

    @Step("Click on the '{1}' button.")
    public void clickOnButtonByText(WebDriver driver, String textOnButton){
        waitForElementClickable(driver, BasePageUI.BUTTON_BY_TEXT, textOnButton);
        clickOnElement(driver, BasePageUI.BUTTON_BY_TEXT, textOnButton);
    }

    @Step("Click on the '{1}' radio button.")
    public  void clickOnRadioButtonByLabel(WebDriver driver, String elementLabel){
        waitForElementClickable(driver, BasePageUI.RADIO_BUTTON_BY_LABEL, elementLabel);
        clickOnElement(driver, BasePageUI.RADIO_BUTTON_BY_LABEL, elementLabel);
    }

    @Step("Get value of '{2}' property of the '{1}' textbox.")
    public String getDOMPropertyValueOfElementByName(WebDriver driver, String nameAttributeValue, String propertyName) {
        waitForElementVisible(driver, BasePageUI.TEXTBOX_BY_NAME, nameAttributeValue);
        return getDomPropertyValue(driver, BasePageUI.TEXTBOX_BY_NAME, propertyName, nameAttributeValue);
    }

    @Step("Select '{2}' value from the '{1}' dropdown menu.")
    public void selectValueFromDropdownMenuByLabel(WebDriver driver, String elementLabel, String selectValue) {
        waitForElementVisible(driver, BasePageUI.DROPDOWN_BY_LABEL, elementLabel);
        selectItemInCustomDropdown(driver, BasePageUI.DROPDOWN_BY_LABEL, BasePageUI.CHILD_LIST_OF_DROPDOWN,
                selectValue, elementLabel);
    }
}
