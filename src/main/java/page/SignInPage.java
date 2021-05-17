package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

public class SignInPage extends BasePage {

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
        return this;
    }

    public void inputNewUserEmail(String email) {
        WaiterWrapperClass.waitForElement(driver, newUserEmailField);
        newUserEmailField.sendKeys(email);
        newUserEmailField.sendKeys(Keys.ENTER);

    }

    public void loginExistingUser(String login, String password) {
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.sendKeys(login);
        userPasswordField.sendKeys(password);
        userPasswordField.sendKeys(Keys.ENTER);

    }
}
