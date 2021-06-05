import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;
import util.DataProviderClass;
import util.UserFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Feature("3 ways for login")
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
    @Test(enabled = true, description = "Test login with email and password from Data Provider",
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

    /**
     * Testing login with email and password received from CSV file
     //TODO: user number - how not to pass it if it's not needed?
     * @param userNumber - not needed here but exists in csv-file
     * @param email - user email from csv-file
     * @param password - user password from csv-file
     * @param userName - user name from csv-file
     */
    @Test(enabled = true, description = "Test login with email and password from CSV file",
            dataProvider = "csvCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithUserFromCsvFile(String userNumber, String email, String password, String userName) {
        String loggedInUserName =
                new SignInPage(driver)
                    .openPage()
                    .loginViaCredentials(email, password)
                    .getLoggedInUserName();

        Assert.assertEquals(userName, loggedInUserName);


    }

}
