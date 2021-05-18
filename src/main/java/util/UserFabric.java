package util;

import model.User;

public class UserFabric {

    protected static final String USER_EMAIL = "test1234567890@gmail.com";
    protected static final String USER_PASSWORD = "12345678";
    public static final String USER_NAME = "John Doe";

    protected static final String ADMIN_EMAIL = "admin000@gmail.com";
    protected static final String ADMIN_PASSWORD = "12345678";

    public static User createUser() {
        return new User(USER_EMAIL, USER_PASSWORD);
    }

    public static User createAdmin() {
        return new User(ADMIN_EMAIL, ADMIN_PASSWORD);
    }
}
