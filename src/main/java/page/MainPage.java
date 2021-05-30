package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WaiterWrapperClass;

@Slf4j
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutButton;

    private final By linkLoggedInUserLocator = By.xpath("//div[@class='header_user_info']/a/span");

    @Override
    protected BasePage openPage() {
        return null;
    }

    public String getLoggedInUserName() {
        log.info("Logged in user name is getting");
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
        return linkLoggedInUser.getText();
    }

    public void logOut() {
        WaiterWrapperClass.waitForElement(driver, signOutButton);
        signOutButton.click();
    }

}
