import driver.BrowserEnum;
import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

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
    public void tearDown() throws InterruptedException {
//        driver.quit();
        driver = null;
    }

}
