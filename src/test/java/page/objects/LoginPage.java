package page.objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {


    @FindBy (id ="login2")
    public WebElement loginBtnInput;

    @FindBy (id ="loginusername")
    public WebElement userNameInput;

    @FindBy (id ="loginpassword")
    public WebElement passwordInput;
    @FindBy (xpath ="//button[text()='Log in']")
    public WebElement loginBtn;

    @FindBy (id = "logout2")
    public  WebElement logoutBtn;




    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProfilePageShop login (String userName, String password){

        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait10.until(ExpectedConditions.visibilityOf(loginBtnInput));
        loginBtnInput.click();

        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();


        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait11.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();

       return new ProfilePageShop(driver);
    }
}
