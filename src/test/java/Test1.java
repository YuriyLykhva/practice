import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.ResultPage;

public class Test1 extends BaseTest {

    public static HomePage homePage;
    public static ResultPage resultPage;

    String expectedHomePageTitle = "My Store";
    String expectedSignInPageTitle = "Login - My Store";
    String expectedSearchResultPageTitle = "Search - My Store";

    @Test
    public void openHomePage() {
        homePage = new HomePage(driver);
        homePage.openPage();
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, expectedHomePageTitle);
    }

    @Test(enabled = true)
    public void openSearchResult() {
        homePage = new HomePage(driver);
        homePage.openPage();
        String productName = "Dress";
        homePage.searchProductName(productName);
        String searchResultPageTitle = driver.getTitle();
        Assert.assertEquals(searchResultPageTitle, expectedSearchResultPageTitle);
    }

    @Test(enabled = true)
    public void checkProductPrice() {
        homePage = new HomePage(driver);
        homePage.openPage();
        String productName = "Dress";
        homePage.searchProductName(productName);
        resultPage.getPriceFromFoundItem();
    }

    @Test(enabled = true)
    public void openSignInPage() {
        homePage.signIn();
        String signInPageTitle = driver.getTitle();
        Assert.assertEquals(signInPageTitle, expectedSignInPageTitle);
    }

}
