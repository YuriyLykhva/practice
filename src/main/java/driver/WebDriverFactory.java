package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.Config;

import java.util.concurrent.TimeUnit;

import static util.Config.getProperty;


public class WebDriverFactory {
    private static WebDriver driver = null;

    private WebDriverFactory() {
        String browser = getProperty(Config.DRIVER);
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new WebDriverFactory();
        }
        return driver;
    }
}
