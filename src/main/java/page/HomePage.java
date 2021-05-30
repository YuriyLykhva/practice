package page;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

@Slf4j
public class HomePage extends BasePage {

    private final String HOMEPAGE_URL = "http://automationpractice.com/index.php";

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement buttonSignIn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //TODO logger.error is put here
    @Override
    @Step("Open Home Page")
    public HomePage openPage() {
        log.info("Home page opens");
        log.error("Error");
        driver.get(HOMEPAGE_URL);
        return this;
    }

    //TODO: I want to see step name in allure
    @Step("Open Results Page with '{0}' products")
    public ResultPage searchProductName(String productName) {
        WaiterWrapperClass.waitForElement(driver, searchField);
        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);
        log.info("Result page opens");
        return new ResultPage(driver);
    }

    @Step("Open Sign-In Page")
    public SignInPage signIn() {
        WaiterWrapperClass.waitForElement(driver, buttonSignIn);
        buttonSignIn.click();
        log.info("Login page opens");
        return new SignInPage(driver);
    }


}