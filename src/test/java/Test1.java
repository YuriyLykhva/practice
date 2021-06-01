import com.opencsv.bean.CsvToBeanBuilder;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.User;
import model.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.OrderPage;
import util.UserFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Feature("New feature")
public class Test1 extends BaseTest {

    protected static final String PRODUCT_NAME = "Dress";
    protected static final int MIN_PRICE = 16;
    protected static final int MAX_PRICE = 51;

    /**
     *
     */
    @Story("My story")
    @Test(description = "Home page title test")
    public void openHomePage() {
        new HomePage(driver).openPage();
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, EXPECTED_HOME_PAGE_TITLE);
    }

    /**
     *
     */
    @Story("My story")
    @Test(description = "Search result title test")
    public void openSearchResult() {
        new HomePage(driver)
                .openPage()
                .searchProductName(PRODUCT_NAME);
        String searchResultPageTitle = driver.getTitle();
        Assert.assertEquals(searchResultPageTitle, EXPECTED_SEARCH_RESULT_PAGE_TITLE);
    }

    /**
     *
     */
    @Epic("Check prices")
    @Test(description = "Test whether prices are in expected range")
    public void checkProductPrice() {
        List<Double> prices = new HomePage(driver)
                .openPage()
                .searchProductName(PRODUCT_NAME)
                .getPriceFromFoundItem();
        for (Double price : prices) {
            Assert.assertTrue((price > MIN_PRICE && price < MAX_PRICE),
                    "some price is not in allowed range");
        }
    }

    /**
     *
     */
    @Story("Another story")
    @Test(description = "Sign-in page title test")
    public void openSignInPage() {
        new HomePage(driver)
                .openPage()
                .signIn();
        String signInPageTitle = driver.getTitle();
        Assert.assertEquals(signInPageTitle, EXPECTED_SIGN_IN_PAGE_TITLE);
    }

    /**
     * CSV importer solution
     *
     * @throws IOException
     */
    @Test(enabled = false)
    public void csvFileImportTest() throws IOException {
        List<UserDTO> users = new CsvToBeanBuilder(new FileReader("src/main/resources/File.csv"))
                .withType(UserDTO.class).build().parse();
        users.forEach(System.out::println);

    }

}
