import com.opencsv.bean.CsvToBeanBuilder;
import io.qameta.allure.Feature;
import model.User;
import model.UserDTO;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import page.SignInPage;
import util.DataProviderClass;
import util.UserFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Feature("2 ways for login")
public class LoginTest extends BaseTest {
    /**
     *
     */
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
     *
     * @param email
     * @param password
     * @param userName
     */
    @Test(enabled = false, description = "Test login with email and password from Data Provider",
            dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
    public void loginWithUserFromDataProvider(String email, String password, String userName) {
        String loggedInUserName =
                new SignInPage(driver)
                .openPage()
                .loginViaCredentials(email, password)
                .getLoggedInUserName();

        Assert.assertEquals(userName, loggedInUserName);
    }

    /**
     *
     * @param username
     * @param password
     */
    @Test(enabled = false, description = "Test for output data",
            dataProvider = "testData", dataProviderClass = DataProviderClass.class)
    public void test(String username, String password) {
        Reporter.log(String.format("Test executed for username %s, password %s",
                username, password), true);

        Assert.assertTrue(true, "This is not true");
    }

    /**
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
