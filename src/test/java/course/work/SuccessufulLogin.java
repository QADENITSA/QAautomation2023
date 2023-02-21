package course.work;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SuccessufulLogin extends TestUtil {

    @Test(dataProvider = "correctUsers")

    public void successufulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);

    }

    @DataProvider(name = "correctUsers")
    public Object[][] readUsersFromCvs() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/java/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];
            for (int i = 0; i< csvData.size(); i ++){
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;

        } catch (IOException e) {
            System.out.println("Not found!");
            return null;
        } catch (CsvException e) {
            return null;

        }
    }
}


