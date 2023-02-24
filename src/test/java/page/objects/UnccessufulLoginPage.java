package page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UnccessufulLoginPage extends BasePage {

    @FindBy(id = "login2")
    public WebElement loginBtnInput;

    @FindBy(id = "loginusername")
    public WebElement userNameInput;

    @FindBy(id = "loginpassword")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginBtn;


    public UnccessufulLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProfilePageShop login(String userName, String password) {

        loginBtnInput.click();

        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait10.until(ExpectedConditions.elementToBeClickable(loginBtn));

        loginBtn.click();


        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


        r.keyPress(KeyEvent.VK_ESCAPE);

        r.delay(1000);

        r.keyPress(KeyEvent.VK_ESCAPE);


        return new ProfilePageShop(driver);
    }

}
