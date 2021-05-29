import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import util.StringUtil;

@Feature("SignUp Negative Test")
public class SignUpErrorTest extends BaseTest{

    private static final int EMAIL_LENGTH = 12;
    public static String newUserEmail = StringUtil.getRandomGmail(EMAIL_LENGTH);
    public String expectedErrorMessageHeader = "There are 8 errors";

    @Test(description = "Check error message header")
    public void createNewUserWithAllEmptyFields() {
        String alertHeader =
                new HomePage(driver)
                .openPage()
                .signIn()
                .inputNewUserEmail(newUserEmail)
                .registerButtonClick()
                .getAlertHeader();
        Assert.assertEquals(alertHeader, expectedErrorMessageHeader);
    }
}
