import driver.WebDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;

@Slf4j
@Listeners(TestListener.class)
public class BaseTest {

    /**
     * Variables, constants
     */
    protected static final String EXPECTED_HOME_PAGE_TITLE = "My Store";
    protected static final String EXPECTED_SIGN_IN_PAGE_TITLE = "Login - My Store";
    protected static final String EXPECTED_SEARCH_RESULT_PAGE_TITLE = "Search - My Store";

    protected WebDriver driver;

    /**
     * Setting driver up
     */
    @BeforeClass
//TODO    @Parameters("browser")
    public void setup() {//@Optional("CHROME") BrowserEnum browser) {//@Optional("CHROME")
        driver = WebDriverFactory.getDriver();
        log.info("Tests are starting!");
    }

    /**
     * Clearing cookies after each test method
     */
    @AfterMethod
    public void clearCookie() {
        driver.manage().deleteAllCookies();
    }

    /**
     * Closing driver
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
        log.info("Tests are finishing!");
    }

}
