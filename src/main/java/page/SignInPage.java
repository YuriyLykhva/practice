package page;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

@Slf4j
public class SignInPage extends BasePage {

    private final String SIGNINPAGE_URL =
            "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement newUserEmailField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement userPasswordField;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage openPage() {
        driver.get(SIGNINPAGE_URL);
        return this;
    }

    public SignUpPage inputNewUserEmail(String email) {
        log.info("Sign Up started");
        WaiterWrapperClass.waitForElement(driver, newUserEmailField);
        newUserEmailField.sendKeys(email);
        newUserEmailField.sendKeys(Keys.ENTER);
        return new SignUpPage(driver);
    }

    public MainPage loginViaModel(User user) {
        log.info("Login via model started");
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(user.getUserEmail());
        userPasswordField.sendKeys(user.getPassword());
        userPasswordField.sendKeys(Keys.ENTER);
        log.info("Login via model finished");
        return new MainPage(driver);
    }

    public MainPage loginViaCredentials(String email, String password) {
        log.info("Login via credentials started");
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(email);
        userPasswordField.sendKeys(password);
        userPasswordField.sendKeys(Keys.ENTER);
        log.info("Login via credentials finished");
        return new MainPage(driver);
    }
}
