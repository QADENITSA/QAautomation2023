
import Base.TestUtil2;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginWithAddToCart;
import page.objects.PaymentPage;
import page.objects.ProfilePageShop;

public class TestParallel1 extends TestUtil2 {
    @Test
    public void payment() {

        LoginWithAddToCart loginWithAddToCart = new LoginWithAddToCart(driver);
        ProfilePageShop prPage = loginWithAddToCart.login("div456", "654div");

        prPage.addItemToTheCart("//a[text()='Samsung galaxy s6']");
        prPage.addItemToTheCart("//a[text()='Sony vaio i5']");

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setOrder("Plamen", "Biala", "Bulgaria", "123456789", "02", "2023");

        Assert.assertEquals(paymentPage.checkOrder(), "Thank you for your purchase!");

    }
}
