package commons;

import java.io.File;

public class GlobalConstants {

    // SYSTEM INFO
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    // App for user
    public static final String STAGING_USER_URL = "http://localhost:86/orangehrm5/";
    public static final String LIVE_USER_URL = "https://opensource-demo.orangehrmlive.com";

    // ADMIN ACCOUNT
    public static final String ADMIN_USERNAME = "automationfc";
    public static final String ADMIN_PASSWORD = "orangehrm5@X";
    public static final String ADMIN_FULLNAME = "Huyen Tran";

    // USER ACCOUNT
    public static final String USER_USERNAME = "anna1011";
    public static final String USER_PASSWORD = "Annatran1011@X";

    // DOWNLOAD & UPLOAD FILE
    public static final String DOWN_LOAD_FILE_PATH = PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String UP_LOAD_FILE_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

    // RETRY FAILED CASE
    public static final int RETRY_NUMBER = 3;

    // WAIT TIME
    public static final long LONG_TIME_OUT = 30;
    public static final long SHORT_TIME_OUT = 10;

    // HTML REPORT FOLDER
    public static final String REPORTING_PATH = PROJECT_PATH + File.separator + "htmlReportNG" + File.separator;
    public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "htmlExtent" + File.separator;
    public static final String ALLURE_PATH = PROJECT_PATH + File.separator + "htmlAllure" + File.separator;

    // DATA TEST
    public static final String DATA_TEST_PATH = PROJECT_PATH + File.separator + "dataTest" + File.separator;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + File.separator + "environmentConfig" + File.separator;

    // JIRA
    public static final String JIRA_SITE_URL = "https://selenium-testing-huyen.atlassian.net";
    public static final String JIRA_USERNAME = "huyentran1011@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0yVakyeAbFZPl8h7Du24CiMSQDNpyv0dtOZ0O2zIz2E2y2kjWs4A07bVxvxzwHYtQVMW69mCEFuWMEaHevWk3hAoAaD7XFcywlMu5RwbFOHBKej3Dcuo4vmeU4Hq0N1GgmQmJyJvjhTvJdW8kHu0lvdunxQ6EuovMHNvmqhkVevQ=671E2551";
    public static final String JIRA_PROJECT_KEY = "RNGHRM5";

}
