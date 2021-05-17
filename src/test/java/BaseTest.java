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
    protected static final String USER_EMAIL = "test1234567890@gmail.com";
    protected static final String USER_PASSWORD = "12345678";
    protected static final String PRODUCT_NAME = "Dress";


    protected WebDriver driver;


    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("CHROME") BrowserEnum browser) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yurii_Lykhva\\Downloads\\Yura\\chromedriver_win\\chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver",
//                "src/test/resources/drivers/macos/geckodriver");

        driver = WebDriverFactory.getDriver(browser);
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
        driver = null;
    }

}
