package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpPage extends BasePage {
    public final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    private final String SIGNUPPAGE_URL =
            "http://automationpractice.com/index.php?controller=authentication";

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Open Sign-Up Page")
    public SignUpPage openPage() {
        driver.get(SIGNUPPAGE_URL);
        logger.info("Signup page opens");
        return this;
    }

    @Step("Register button clicked")
    public ControlPage registerButtonClick() {
        WebElement registerButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//button[@id='submitAccount']")));
        jsClickElement(registerButton);
        logger.info("Register button clicked");
        return new ControlPage(driver);
    }

}
