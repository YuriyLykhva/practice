package page;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WaiterWrapperClass;

@Slf4j
public class HomePage extends BasePage {

    /**
     * Variables, constants
     */
    private final String HOMEPAGE_URL = "http://automationpractice.com/index.php";
    private final String popularProductAddToCartButtonPath =
            "//*[@id='homefeatured']/li//div[@class='right-block']/div[@class='button-container']" +
                    "//span[text()='Add to cart']";

    /**
     * Web Elements
     */
    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement buttonSignIn;

    /**
     * Receiving driver for the page
     * @param driver should be passed here
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opening Home Page
     * @return Home Page opens
     */
    @Override
    @Step("Open Home Page")
    public HomePage openPage() {
        log.info("Home page opens");
        log.error("Error");
        driver.get(HOMEPAGE_URL);
        return this;
    }

    /**
     * Open Results Page with searching product
     * @param productName - name of product we want to find
     * @return Result Page with all found products
     */
    //TODO: I want to see step name in allure
    @Step("Open Results Page with '{0}' product")
    public ResultPage searchProductName(String productName) {
        WaiterWrapperClass.waitForElement(driver, searchField);
        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);
        log.info("Result page opens");
        return new ResultPage(driver);
    }

    /**
     * Opening SignIn Page
     * @return SignIn page
     */
    @Step("Open SignIn Page")
    public SignInPage signIn() {
        WaiterWrapperClass.waitForElement(driver, buttonSignIn);
        buttonSignIn.click();
        log.info("SignIn page opens");
        return new SignInPage(driver);
    }


    /**
     * Adding to cart the first popular product and skipping pop-up window
     * @throws InterruptedException - waiter sleep
     */
    public void addToCartFirstPopularProduct() throws InterruptedException {
        WebElement addToCartFirstPopularProductButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath(popularProductAddToCartButtonPath)));
        jsClickElement(addToCartFirstPopularProductButton);

        Thread.sleep(10000);
        WebElement closePopUp = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@id='layer_cart']//span[@class='cross']")));
        closePopUp.click();

        log.info("Add-to-Cart button clicked");
    }

    /**
     * Starting checkout when there is product in the cart
     * @return Order Page
     * @throws InterruptedException - waiter sleep
     */
    //TODO: optimize sleeps
    public OrderPage checkoutButtonClick() throws InterruptedException {
        Actions hover = new Actions(driver);
        WebElement cartButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@title='View my shopping cart']")));
        Thread.sleep(5000);
        hover.moveToElement(cartButton);
        hover.perform();
        Thread.sleep(5000);
        WebElement checkout = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@id='button_order_cart']")));
        Thread.sleep(5000);
        hover.moveToElement(checkout);
        hover.perform();
        checkout.click();
        return new OrderPage(driver);
    }


}