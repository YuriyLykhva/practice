import driver.BrowserEnum;
import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected static final String EXPECTED_HOME_PAGE_TITLE = "My Store";
    protected static final String EXPECTED_SIGN_IN_PAGE_TITLE = "Login - My Store";
    protected static final String EXPECTED_SEARCH_RESULT_PAGE_TITLE = "Search - My Store";
    protected static final String NEW_USER_EMAIL = "test-test1234567890@gmail.com";

    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setup(BrowserEnum browser) {//@Optional("CHROME")

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        driver = WebDriverFactory.getDriver(browser);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }

}
