package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WaiterWrapperClass;

public class SignUpPage extends BasePage {
    public final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    private final String SIGNUPPAGE_URL =
            "http://automationpractice.com/index.php?controller=authentication";

    @FindBy(xpath = "//button[@id='submitAccount']")
    private WebElement buttonRegister;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private WebElement alertMessageHeader;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignUpPage openPage() {
        driver.get(SIGNUPPAGE_URL);
        return this;
    }

    public void registerButtonClick() {
        buttonRegister.click();
    }

    public String getAlertHeader() {
//TODO        return alertMessageHeader.getText();
        WebElement alertHeaderText = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='alert alert-danger']/p")));
        return alertHeaderText.getText();
    }
}
