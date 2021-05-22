package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

public class User {

    private String userEmail;
    private String password;
    private String userName;

    public User(String userEmail, String password, String userName) {
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
    }

    public User(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userEmail.equals(user.userEmail) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, password);
    }
}
