package page;

import io.qameta.allure.Step;
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

    /**
     * Variables, constants
     */
    private final String SIGNINPAGE_URL =
            "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    /**
     * Web Elements
     */
    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement newUserEmailField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement userPasswordField;

    /**
     * Receiving driver for the page
     * @param driver should be passed here
     */
    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opening SignIn page
     * @return SignIn Page open
     */
    @Step("Need something there")
    public SignInPage openPage() {
        driver.get(SIGNINPAGE_URL);
        return this;
    }

    /**
     * Entering new user email
     * @param email of new user should be passed here
     * @return new SignUp Page
     */
    public SignUpPage inputNewUserEmail(String email) {
        log.info("Sign Up started");
        WaiterWrapperClass.waitForElement(driver, newUserEmailField);
        newUserEmailField.sendKeys(email);
        newUserEmailField.sendKeys(Keys.ENTER);
        return new SignUpPage(driver);
    }


    /**
     * Login with received user
     * @param user should be created and received
     * @return new Main Page with logged in user
     */
    public MainPage loginViaModel(User user) {
        log.info("Login via model started");
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(user.getUserEmail());
        userPasswordField.sendKeys(user.getPassword());
        userPasswordField.sendKeys(Keys.ENTER);
        log.info("Login via model finished");
        return new MainPage(driver);
    }

    /**
     * Login with received user's credentials
     * @param email - registered user email
     * @param password - registered user password
     * @return new Main Page with logged in user
     */
    @Step("Need something there")
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
