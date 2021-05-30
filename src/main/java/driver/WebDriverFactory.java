package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.maven.plugins.annotations.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static WebDriver driver;

//    public static WebDriver getDriver(BrowserEnum browser) {
//        if(driver == null) {
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
//
//            driver = initDriver(browser);
//        }
//        return driver;
//    }
//
//    private static WebDriver initDriver(BrowserEnum browser) {
//        switch (browser){
//            case CHROME: return new ChromeDriver();
//            case FIREFOX: return new FirefoxDriver();
//            default: throw new RuntimeException("Browser not supported: " + browser);
//        }
//    }
        public static WebDriver getDriver() {

        if(driver == null) {
            //TODO: create switch expression and connect with BrowserEnum
            switch ("") {
                case "FIREFOX": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }

        }
        return driver;
    }


}
