import Base.TestUtil;
import org.testng.annotations.Test;
import page.objects.*;


public class TestParallel extends TestUtil {


    @Test
    public void successufulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("123d", "d321");

    }

}
