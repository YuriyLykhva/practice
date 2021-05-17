import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import java.text.ParseException;

public class Test1 extends BaseTest {

    protected static final String PRODUCT_NAME = "Dress";
    protected static final int MIN_PRICE = 16;
    protected static final int MAX_PRICE = 51;

    @Test
    public void openHomePage() {
        new HomePage(driver).openPage();
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, EXPECTED_HOME_PAGE_TITLE);
    }

    @Test
    public void openSearchResult() {
        new HomePage(driver)
                .openPage()
                .searchProductName(PRODUCT_NAME);
        String searchResultPageTitle = driver.getTitle();
        Assert.assertEquals(searchResultPageTitle, EXPECTED_SEARCH_RESULT_PAGE_TITLE);
    }

    @Test
    public void checkProductPrice() throws ParseException {
        new HomePage(driver)
                .openPage()
                .searchProductName(PRODUCT_NAME)
                .getPriceFromFoundItem();
//        Assert.assertTrue((prices.get(j) > MIN_PRICE && prices.get(j) < MAX_PRICE),
//        "some price is not in allowed range");
    }

    @Test
    public void openSignInPage() {
        new HomePage(driver)
                .openPage()
                .signIn();
        String signInPageTitle = driver.getTitle();
        Assert.assertEquals(signInPageTitle, EXPECTED_SIGN_IN_PAGE_TITLE);
    }

    @Test
    public void createNewUser() {
        new HomePage(driver)
                .openPage()
                .signIn()
                .inputNewUserEmail(NEW_USER_EMAIL);
    }

    //TODO: to check user is logged in
    @Test
    public void loginTest() {
        new HomePage(driver)
                .openPage()
                .signIn()
                .loginExistingUser(USER_EMAIL, USER_PASSWORD);

//        Assert.assertTrue()
    }

}
