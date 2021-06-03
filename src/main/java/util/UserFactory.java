package util;

import model.User;

public class UserFactory {

    /**
     * Variables, constants
     */
    protected static final String TEST_DATA_USER_EMAIL = "testdata.user.email";
    protected static final String TEST_DATA_USER_PASSWORD = "testdata.user.password";
    public static final String TEST_DATA_USER_NAME = "testdata.user.name";

    /**
     * Creating new user with desired parameters
     * @return new user with email, password and name read from file
     */
    public static User createUser() {
        return new User(TestDataReader.getTestData(TEST_DATA_USER_EMAIL),
                TestDataReader.getTestData(TEST_DATA_USER_PASSWORD),
                TestDataReader.getTestData(TEST_DATA_USER_NAME));
    }

}
