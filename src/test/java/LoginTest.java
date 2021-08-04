import commonLib.Browser;
import locator.Locator;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeClass
    public void openChrome(){
        Browser.openBrowser("Chrome");
        Browser.navigate("http://automationpractice.com/");
        Browser.driver.findElement(By.xpath(Locator.signInNavItem)).click();
    }

    @Test(priority = 1)
    public static void noPasswordNoUsername(){
        System.out.println("this is a login test!");
    }

}
