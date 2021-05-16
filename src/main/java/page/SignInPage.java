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

    //TODO:this method does not work at all
    public void inputNewUserEmail(String email) throws InterruptedException {

//        Thread.sleep(3000);
//        WebElement yy = driver.findElement(By.xpath("//input[@id='email_create']"));
//        yy.click();
//        yy.sendKeys("here is my new email");

        WaiterWrapperClass.waitForElement(driver, newUserEmailField);
        newUserEmailField.click();
        newUserEmailField.sendKeys(email);
        newUserEmailField.sendKeys(Keys.ENTER);

    }

    //TODO:this method does not work at all
    public void loginExistingUser(String login, String password) throws InterruptedException {
        WaiterWrapperClass.waitForElement(driver, userEmailField);
        userEmailField.click();
        userEmailField.sendKeys(login);

        userPasswordField.click();
        userPasswordField.sendKeys(password);
        userPasswordField.sendKeys(Keys.ENTER);

    }
}
