package page;

import org.openqa.selenium.By;
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

    public void inputNewUserEmail(String email) throws InterruptedException {
        System.out.println("input email method started");
        Thread.sleep(3000);
//        WaiterWrapperClass.waitForElement(driver, emailField);
        WebElement yy = driver.findElement(By.xpath("//input[@id='email_create']"));
        Thread.sleep(3000);

        System.out.println("email field appears");
//        emailField.click();
//        emailField.sendKeys(email);
//        emailField.sendKeys(Keys.ENTER);
        yy.click();
        yy.sendKeys("here is my new email");
    }

    public void loginExistingUser(String login, String password) throws InterruptedException {
        System.out.println("Login started");
        Thread.sleep(2000);


        userEmailField.click();
        userEmailField.sendKeys(login);
        userPasswordField.click();
        userPasswordField.sendKeys(password);
        userPasswordField.sendKeys(Keys.ENTER);

    }
}
