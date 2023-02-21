package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil {
    public WebDriver driver;
    public String applicationURL;
    private String browser;
    public int implicitWait;

    @BeforeTest
    public void setUp(){
        readConfig("src/test/java/resources/config.properties");
        setupBrowserDriver(getBrowser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
//        String applicationUrl = new String();
        loadTestUrl(applicationURL);

    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }
    private void setupBrowserDriver(String browser) {

        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFirefoxDriver();
                break;
        }
    }
    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver setupFirefoxDriver(){
       WebDriverManager.firefoxdriver().setup();
        return  new FirefoxDriver();
    }
    private void readConfig(String filePath){
        try {
            FileInputStream configFile = new FileInputStream(filePath);
            Properties config = new Properties();
            config.load(configFile);
            applicationURL = config.getProperty("url");
            browser=config.getProperty("browser");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            System.out.println("WebHook enabled");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    private void loadTestUrl(String url){
        driver.get(url);
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {

        this.browser = browser;
    }
}

