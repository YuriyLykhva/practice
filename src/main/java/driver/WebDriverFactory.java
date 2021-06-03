package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static WebDriver driver;
    //TODO: Implement passing browser via parameter
    private static final BrowserEnum browser = BrowserEnum.CHROME;

        public static WebDriver getDriver() {

        if(driver == null) {
            switch (browser) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    throw new RuntimeException("Browser not supported: " + browser);
                }
            }

        }
        return driver;
    }


}
