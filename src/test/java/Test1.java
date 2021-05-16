import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResultPage;
import page.SignInPage;
import util.WaiterWrapperClass;
import java.util.List;

public class Test1 extends BaseTest {

    public static HomePage homePage;
    public static ResultPage resultPage;
    public static SignInPage signInPage;

    String expectedHomePageTitle = "My Store";
    String expectedSignInPageTitle = "Login - My Store";
    String expectedSearchResultPageTitle = "Search - My Store";
    String newUserEmail = "test-test1234567890@gmail.com";
    String userEmail = "test1234567890@gmail.com";
    String userPassword = "12345678";

    @Test
    public void openHomePage() {
        homePage = new HomePage(driver);
        homePage.openPage();
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, expectedHomePageTitle);
    }

    @Test
    public void openSearchResult() {
        homePage = new HomePage(driver);
        homePage.openPage();
        String productName = "Dress";
        homePage.searchProductName(productName);
        String searchResultPageTitle = driver.getTitle();
        Assert.assertEquals(searchResultPageTitle, expectedSearchResultPageTitle);
    }

    @Test
    public void checkProductPrice() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openPage();
        String productName = "Dress";
        homePage.searchProductName(productName);

//        TODO: коли вейтер (сліп) перед пошуком веб-елементу, то все ок.
//         Але експліціт вейт має бути після оголошення веб-ел-ту. Як тут бути?

        Thread.sleep(1000);
        List<WebElement> foundItemPrices = driver
                .findElements(By.xpath("//*[@id='center_column']/ul/li//div[@itemprop='offers']"));
        String s = foundItemPrices.get(1).getText();
        System.out.println("text is" + s);
//        resultPage.getPriceFromFoundItem();
    }

    @Test
    public void openSignInPage() {
        homePage.signIn();
        String signInPageTitle = driver.getTitle();
        Assert.assertEquals(signInPageTitle, expectedSignInPageTitle);
    }

    @Test
    public void createNewUser() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.signIn();
//TODO: This works

        WebElement y = driver.findElement(By.xpath("//input[@id='email_create']"));
        WaiterWrapperClass.waitForElement(driver, y);
        y.click();
        y.sendKeys(newUserEmail);

//TODO: This does not work:

//        signInPage.inputNewUserEmail(newUserEmail);
    }

    @Test
    public void loginTest() throws InterruptedException{
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.signIn();

        System.out.println("login test starts");
        Thread.sleep(2000);

//TODO: This works

        WebElement loginField = driver.findElement(By.xpath("//input[@id='email']"));
        WaiterWrapperClass.waitForElement(driver, loginField);
        loginField.click();
        loginField.sendKeys(userEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='passwd']"));
        passwordField.click();
        passwordField.sendKeys(userPassword);
        passwordField.sendKeys(Keys.ENTER);

//TODO: This does not work:

//        signInPage.loginExistingUser(userEmail, userPassword);
    }


}
