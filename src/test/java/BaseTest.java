import driver.BrowserEnum;
import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected static final String EXPECTED_HOME_PAGE_TITLE = "My Store";
    protected static final String EXPECTED_SIGN_IN_PAGE_TITLE = "Login - My Store";
    protected static final String EXPECTED_SEARCH_RESULT_PAGE_TITLE = "Search - My Store";
    protected static final String NEW_USER_EMAIL = "test-test1234567890@gmail.com";

    protected WebDriver driver;

    @BeforeClass
//TODO    @Parameters("browser")
    public void setup() {//@Optional("CHROME") BrowserEnum browser) {//@Optional("CHROME")
        driver = WebDriverFactory.getDriver();
    }

    /**
     *
     */
    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
