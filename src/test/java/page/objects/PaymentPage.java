package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

    @FindBy(id = "cartur")
    public WebElement cartBadge;
    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderBtn;

    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(id = "country")
    public WebElement countryBox;

    @FindBy(id = "city")
    public WebElement cityBox;

    @FindBy(id = "card")
    public WebElement cardBox;

    @FindBy(id = "month")
    public WebElement monthBox;

    @FindBy(id = "year")
    public WebElement yearBox;

    @FindBy(xpath = "//button[text()='Purchase']")
    public WebElement purchasePayBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    public WebElement txtSuccess;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setOrder(String name, String country, String city,
                         String creditCard, String month, String year) {

        cartBadge.click();
        placeOrderBtn.click();

        nameBox.click();
        nameBox.clear();
        nameBox.sendKeys(name);

        countryBox.click();
        countryBox.clear();
        countryBox.sendKeys(country);

        cityBox.click();
        cityBox.clear();
        cityBox.sendKeys(city);

        cardBox.click();
        cardBox.clear();
        cardBox.sendKeys(creditCard);

        monthBox.click();
        monthBox.clear();
        monthBox.sendKeys(month);

        yearBox.click();
        yearBox.clear();
        yearBox.sendKeys(year);

        purchasePayBtn.click();

    }

    public String checkOrder() {

        return txtSuccess.getText();
    }

}
