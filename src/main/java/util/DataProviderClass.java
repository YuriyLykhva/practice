package util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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

    /**
     * Provides users email, password and name form CSV file
     * @return data
     */
    @DataProvider(name = "csvCredentials")
    public Object[][] csvCredentials() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/File.csv"));
        List<String[]> users = csvReader.readAll();
        //todo: magic number

        String[][] csvDataObject = new String[users.size()][4];
        for (int i = 0; i < users.size(); i++) {
            csvDataObject[i] = users.get(i);
        }
        return csvDataObject;
    }
}
