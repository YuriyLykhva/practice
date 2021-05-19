import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;
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
}
