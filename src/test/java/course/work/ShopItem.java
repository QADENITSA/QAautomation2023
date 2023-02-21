package course.work;

import Base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import page.objects.ProfilePageShop;

public class ShopItem extends TestUtil {

    @Test
    public void addItemInTheCart() {
        LoginPage lgnPage = new LoginPage(driver);
        ProfilePageShop prPage = lgnPage.login("123d", "d321");

        prPage.addItemToTheCart("//a[text()='Samsung galaxy s6']");
        prPage.addItemToTheCart("//a[text()='Sony vaio i5']");
        System.out.println("iojo-"+prPage.getItemsInTheCart());
//        Assert.assertEquals( prPage.getItemsInTheCart(),"Sony vaio i5");



    }
}
