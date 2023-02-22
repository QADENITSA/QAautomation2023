package course.work;

import Base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginWithAddToCart;
import page.objects.ProfilePageShop;

public class ShopItem extends TestUtil {

    @Test
    public void addItemInTheCart() {
        LoginWithAddToCart loginWithAddToCart = new LoginWithAddToCart(driver);
        ProfilePageShop prPage = loginWithAddToCart.login("123d", "d321");

        prPage.addItemToTheCart("//a[text()='Samsung galaxy s6']");
        prPage.addItemToTheCart("//a[text()='Sony vaio i5']");
      // System.out.println("test-"+prPage.getItemsInTheCart());
       Assert.assertEquals( prPage.getItemsInTheCart(),2);


    }
}
