package model;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<UserDTO> users = new CsvToBeanBuilder(new FileReader("src/main/resources/File.csv"))
                .withType(UserDTO.class).build().parse();
        users.forEach(System.out::println);
    }
}
