package util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new String[][]{
                {"Jack", "123"},
                {"John", "321"},
                {"Pavlo", "12345"}
        };
    }

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new String[][]{
                {"admin000@gmail.com", "12345678", "Admin Admin"},
                {"test1234567890@gmail.com", "12345678", "John Doe"},
        };
    }
}
