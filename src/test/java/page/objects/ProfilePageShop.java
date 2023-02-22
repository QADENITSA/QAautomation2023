package page.objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePageShop extends BasePage {

    @FindBy(id = "cat")
    public WebElement categories;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    public WebElement addToCart;

    @FindBy(xpath = "//a[text()='Home ']")
    public WebElement homeBtn;

    @FindBy(id = "cartur")
    public WebElement cartBadge;


    public ProfilePageShop(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToTheCart(String itemName) {
        categories.click();
        WebElement itemToClick = driver.findElement(By.xpath(itemName));
        itemToClick.click();
        addToCart.click();
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait10.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        homeBtn.click();

    }

    public int getItemsInTheCart() {
       int count = 0;

        cartBadge.click();
        
        WebElement t = driver.findElement(By.id("tbodyid"));
        
        List<WebElement> rws = t.findElements(By.tagName("tr"));
        int rws_cnt = rws.size();

        for (int i = 0; i < rws_cnt; i++) {
            List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
            ++count;
           // System.out.println("The cell value is: " + c);
        }return count;

    }

}
