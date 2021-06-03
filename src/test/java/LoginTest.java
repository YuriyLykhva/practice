import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;
import util.DataProviderClass;
import util.UserFactory;


@Feature("2 ways for login")
public class LoginTest extends BaseTest {

    /**
     * Testing login via User Factory
     */
    @Step("Need something here")
    @Test(enabled = true, description = "Test login via User Factory")
    public void loginWithUserViaModel() {
        User testUser = UserFactory.createUser();
        String loggedInUserName = new SignInPage(driver)
                .openPage()
                .loginViaModel(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(testUser.getUserName(), loggedInUserName);
    }

    /**
     * Testing login with email and password received from Data Provider
     * @param email - existing user email
     * @param password - existing user password
     * @param userName - existing user name
     */
    @Test(enabled = true, description = "description - Test login with email and password from Data Provider",
            dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
    @Step("Need something there")
    public void loginWithUserFromDataProvider(String email, String password, String userName) {
        String loggedInUserName =
                new SignInPage(driver)
                .openPage()
                .loginViaCredentials(email, password)
                .getLoggedInUserName();

        Assert.assertEquals(userName, loggedInUserName);
    }

}
