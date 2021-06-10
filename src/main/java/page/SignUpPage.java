package page;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class SignUpPage extends BasePage {

    /**
     * Variables, constants
     */
    private final String SIGNUPPAGE_URL =
            "http://automationpractice.com/index.php?controller=authentication";

    /**
     * Receiving driver for the page
     * @param driver should be passed here
     */
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opening sign-up page
     * @return SignUp Page open
     */
    @Step("Open Sign-Up Page")
    public SignUpPage openPage() {
        driver.get(SIGNUPPAGE_URL);
        log.info("Signup page opens");
        return this;
    }

    /**
     * Registering a new user
     * @return new Control Page
     */
    @Step("Register button clicked")
    public ControlPage registerButtonClick() {
        WebElement registerButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//button[@id='submitAccount']")));
        jsClickElement(registerButton);
        log.info("Register button clicked");
        return new ControlPage(driver);
    }

}
