package util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new String[][]{
                {"Jack", "123"},
                {"John", "321"},
                {"Pavlo", "12345"}
        };
    }
}
