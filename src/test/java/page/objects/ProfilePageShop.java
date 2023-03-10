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

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ProfilePageShop extends BasePage {

    @FindBy(id = "cat")
    public WebElement categories;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    public WebElement addToCart;

    @FindBy(xpath = "//a[text()='Home ']")
    public WebElement homeBtn;

    @FindBy(id = "cartur")
    public WebElement cartBadge;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped']/tbody/tr")
    public WebElement table;

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

        cartBadge.click();

        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait10.until(ExpectedConditions.visibilityOf(table));

        WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr")));
        //take element from table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr"));
        return rows.size();

    }

}

