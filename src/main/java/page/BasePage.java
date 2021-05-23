package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    public final Logger logger = LogManager.getRootLogger();

    protected abstract BasePage openPage();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }


    protected void jsClickElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
