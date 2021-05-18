import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;
import util.UserFabric;

import static util.UserFabric.USER_NAME;

public class LoginTest extends BaseTest {
    @Test
    public void oneCanLogin() {
        User testUser = UserFabric.createUser();
        String loggedInUserName = new SignInPage(driver)
                .openPage()
                .loginViaModel(testUser)
                .getLoggedInUserName();
        Assert.assertEquals(USER_NAME, loggedInUserName);
    }
}
