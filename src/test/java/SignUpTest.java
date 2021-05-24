import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SignUpPage;
import util.StringUtil;

public class SignUpTest extends BaseTest{

    private static final int EMAIL_LENGTH = 12;
    public static String newUserEmail = StringUtil.getRandomGmail(EMAIL_LENGTH);

    @Test
    public void createNewUser() {
        String s = new HomePage(driver)
                .openPage()
                .signIn()
                .inputNewUserEmail(newUserEmail).getAlertHeader();
//                .registerButtonClick();
        System.out.println("Alert header is " + s);
//        Assert.assertEquals();
    }
}
