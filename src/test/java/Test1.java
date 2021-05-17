import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test1 extends BaseTest {

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
    public void checkProductPrice() throws InterruptedException, ParseException {
        new HomePage(driver)
                .openPage()
                .searchProductName(PRODUCT_NAME);

        Thread.sleep(1000);
        List<WebElement> foundItems = driver
                .findElements(By.xpath("//*[@id='center_column']/ul/li//div[@itemprop='offers']"));
        List<String> foundItemPrices = new ArrayList<>();
        List<String> foundItemPricesOnlyNumbers = new ArrayList<>();
        for (WebElement webElement : foundItems) {
            foundItemPrices.add(webElement.getText());
        }
        int j = 0;
        List<Double> prices = new ArrayList<>();
        for (int i = 1; i < foundItemPrices.size(); i=i+2) {
            foundItemPricesOnlyNumbers.add(foundItemPrices.get(i).split(" ")[0]);
            prices.add((Double) NumberFormat.getCurrencyInstance().parse(foundItemPrices.get(i).split(" ")[0]));
            System.out.println("price is " + prices.get(j));
            Assert.assertFalse((prices.get(j) > 16 && prices.get(j) > 51),
                    "some price is not between $16...51");
            j++;
        }

//        resultPage.getPriceFromFoundItem();
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

    @Test
    public void loginTest() {
        new HomePage(driver)
                .openPage()
                .signIn()
                .loginExistingUser(USER_EMAIL, USER_PASSWORD);
    }


}
