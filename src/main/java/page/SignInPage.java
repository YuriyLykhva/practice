package page;

import model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

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
        logger.info("Sign Up started");
        WaiterWrapperClass.waitForElement(driver, newUserEmailField);
        newUserEmailField.sendKeys(email);
        newUserEmailField.sendKeys(Keys.ENTER);
        return new SignUpPage(driver);
    }

    public MainPage loginViaModel(User user) {
        logger.info("Login started");
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(user.getUserEmail());
        userPasswordField.sendKeys(user.getPassword());
        userPasswordField.sendKeys(Keys.ENTER);
        return new MainPage(driver);
    }
}
