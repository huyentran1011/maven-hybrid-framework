package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.io.File;

public class BaseTest {
    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    protected final Logger log;
    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid!");
        }
        driver.get(GlobalConstants.LIVE_USER_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.SHORT_TIME_OUT));
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid!");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.SHORT_TIME_OUT));
        return driver;
    }

    protected boolean verifyTrue(boolean condition){
        boolean passStatus = true;
        try {
            Assert.assertTrue(condition);
            log.info("-------------------------PASSED-------------------------");
        } catch (Throwable e) {
            passStatus = false;
            log.info("-------------------------FAILED-------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return passStatus;
    }

    protected boolean verifyFalse(boolean condition){
        boolean passStatus = true;
        try {
            Assert.assertFalse(condition);
            log.info("-------------------------PASSED-------------------------");
        } catch (Throwable e) {
            passStatus = false;
            log.info("-------------------------FAILED-------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return passStatus;
    }


    protected boolean verifyEquals(Object actual, Object expected){
        boolean passStatus = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("-------------------------PASSED-------------------------");
        } catch (Throwable e) {
            passStatus = false;
            log.info("-------------------------FAILED-------------------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return passStatus;
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(99999);
    }

    @BeforeSuite
    public void deleteFileInReport() {
        deleteAllFileInFolder("allure-results");
        deleteAllFileInFolder("allure-report");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
