package model;

import com.opencsv.bean.CsvBindByName;

public class UserDTO {

    @CsvBindByName
    public int userNumber;

    @CsvBindByName
    public String userEmail;

    @CsvBindByName
    public String userPassword;

    @CsvBindByName
    public String userName;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userNumber=" + userNumber +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
