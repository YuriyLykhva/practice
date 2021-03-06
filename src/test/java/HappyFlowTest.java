import io.qameta.allure.Epic;
import model.User;
import org.testng.annotations.Test;
import page.HomePage;
import page.OrderPage;
import util.UserFactory;

public class HappyFlowTest extends BaseTest{

    /**
     * Testing end-to-end flow
     */
    @Epic("E2E flow")
    @Test(description = "Testing end-to-end flow")
    public void addFirstPopularProductToCart() throws InterruptedException {
        User testUser = UserFactory.createUser();
        HomePage homePage = new HomePage(driver);
        homePage
                .openPage()
                .signIn()
                .loginViaModel(testUser);
        homePage
                .openPage()
                .addToCartFirstPopularProduct();
        homePage
                .checkoutButtonClick()
                .proceedToCheckout();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.proceedToCheckout2();
        orderPage.proceedToCheckout3();
        orderPage.payByBankWire();
        orderPage.confirmOrder();

    }
}
