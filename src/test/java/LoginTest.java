import model.User;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import page.MainPage;
import page.SignInPage;
import util.DataProviderClass;
import util.UserFactory;

public class LoginTest extends BaseTest {

    @Test(enabled = false)
    public void oneCanLogin() {
        User testUser = UserFactory.createUser();
        String loggedInUserName = new SignInPage(driver)
                .openPage()
                .loginViaModel(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(testUser.getUserName(), loggedInUserName);
    }

    //TODO: How to run tests from data provider after 1st set of data?
    @Test(dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
    public void loginWithUserFromDataProvider(String email, String password, String userName) {
        String loggedInUserName =
                new SignInPage(driver)
                .openPage()
                .loginViaCredentials(email, password)
                .getLoggedInUserName();
//        new MainPage(driver).logOut();

        Assert.assertEquals(userName, loggedInUserName);
    }
}
