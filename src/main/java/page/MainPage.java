package page;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class MainPage extends BasePage {

    /**
     * Variables, constants
     */
    private final By linkLoggedInUserLocator =
            By.xpath("//div[@class='header_user_info']/a/span");


    /**
     * Receiving driver for the page
     * @param driver should be passed here
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */
    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutButton;

    /**
     * Implementation of BasePage method
     * @return null
     */
    @Override
    protected BasePage openPage() {
        return null;
    }

    /**
     * Getting logged in user name
     * @return logged in user name
     */
    @Step("Need something there")
    public String getLoggedInUserName() {
        log.info("Logged in user name is getting");
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
        return linkLoggedInUser.getText();
    }

}
