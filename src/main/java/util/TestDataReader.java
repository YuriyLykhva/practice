package util;

import java.util.ResourceBundle;

public class TestDataReader {

    //todo
    /**
     * Reader of property - user role
     */
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(System.getProperty("role"));

    /**
     *
     * @param key - user parameter, one of: email, password, name
     * @return value of certain user parameter read from the file *.properties
     */
    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
