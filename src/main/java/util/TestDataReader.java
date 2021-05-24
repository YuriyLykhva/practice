package util;

import java.util.ResourceBundle;
//TODO: to read
public class TestDataReader {
    private static ResourceBundle resourceBundle =
            ResourceBundle.getBundle(System.getProperty("role"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
