import commonLib.Browser;
import input.InputLoginCred;
import locator.Locator;
import locator.LocatorCartTest;
import locator.LocatorLoginTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartTest {

    @BeforeClass
    public void go_to_website(){
        Browser.openBrowser("Chrome");
        Browser.navigate("https://www.flipkart.com/");
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonCloseLoginTab)).click();
    }

    @Test(priority = 1)
    public static void checkCartBeforeLogin(){
        Browser.driver.findElement(By.xpath(LocatorCartTest.navItemCart)).click();
        Assert.assertEquals(Browser.driver.findElement(By.xpath(LocatorCartTest.messageBeforeloginInCart)).getText(),"Login to see the items you added previously");
    }
    @Test(priority = 2)
    public static void loginFromMyCart(){
        Browser.driver.findElement(By.xpath(LocatorCartTest.buttonLoginInMyCart)).click();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhoneInLoginPage)).sendKeys(InputLoginCred.phoneValid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputPasswordInLoginPage)).sendKeys(InputLoginCred.passwordValid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertTrue(Browser.driver.findElement(By.xpath(Locator.navItemUserName)).isDisplayed());
        Assert.assertEquals(Browser.driver.getTitle(),"Shopping Cart | Flipkart.com");
    }
    @Test(priority = 3)
    public static void addItemMyCart(){
        Browser.driver.findElement(By.xpath(LocatorCartTest.buttonShopNowMyCart)).click();
//        need to complete
    }

}
