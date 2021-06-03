package util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    /**
     * Provides users email, password and name
     * @return data
     */
    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new String[][]{
                {"admin000@gmail.com", "12345678", "Admin Admin"},
                {"test1234567890@gmail.com", "12345678", "John Doe"},
        };
    }
}
