import model.User;
import org.testng.Assert;
import org.testng.Reporter;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.SignInPage;
import util.DataProviderClass;
import util.UserFactory;

public class LoginTest extends BaseTest {
    @Test
    public void oneCanLogin() {
        User testUser = UserFactory.createUser();
        String loggedInUserName = new SignInPage(driver)
                .openPage()
                .loginViaModel(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(testUser.getUserName(), loggedInUserName);
    }

    //TODO: to use better data
    @Test(dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
    public void test(String username, String password) {
        Reporter.log(String.format("Test executed for username %s, password %s",
                username, password), true);

        Assert.assertTrue(true, "This is not true");
    }

}
