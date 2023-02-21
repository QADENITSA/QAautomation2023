package course.work;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.UnccessufulLoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UnccessufulLogin extends TestUtil {

    @Test (dataProvider = "wrongUsers")
    public void UnsuccessufulLogin(String userName, String password){
        UnccessufulLoginPage unccessufulLoginPage = new UnccessufulLoginPage(driver);
        unccessufulLoginPage.login(userName,password);

      WebElement errorMessage = driver.findElement (By.id("signin2"));
        Assert.assertEquals(errorMessage.getText(),
             "Sign up");
 }
    @DataProvider(name = "wrongUsers")
    public Object[][] readUsersFromCvs() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/java/resources/wrongUsers.csv"));
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