package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

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

    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public ResultPage searchProductName(String productName) {
        WaiterWrapperClass.waitForElement(driver, searchField);
        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }

    public SignInPage signIn() {
        WaiterWrapperClass.waitForElement(driver, buttonSignIn);
        buttonSignIn.click();
        return new SignInPage(driver);
    }


}