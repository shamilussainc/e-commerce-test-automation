import commonLib.Browser;
import input.InputLoginCred;
import locator.LocatorLoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeClass
    public void go_to_webiste(){
        Browser.openBrowser("Chrome");
        Browser.navigate("https://www.flipkart.com/");
    }

    @Test(priority = 1)
    public static void loginwithNoPasswordNoUsername(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Please enter valid Email ID/Mobile number");
    }

    @Test(priority = 2)
    public static void loginWithoutUserNameWithInvalidPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(InputLoginCred.passwordInvalid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Please enter valid Email ID/Mobile number");
    }

    @Test(priority = 3)
    public static void loginWithoutUserNameWithValidPassword() {
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(InputLoginCred.passwordValid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Please enter valid Email ID/Mobile number");
    }

    @Test(priority = 4)
    public static void loginWithInvalidUsernameWithoutPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).sendKeys(InputLoginCred.phoneInvalid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Please enter valid Email ID/Mobile number");
    }

    @Test(priority = 5)
    public static void loginWithInvalidUsernameInvalidPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).sendKeys(InputLoginCred.phoneInvalid);
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(InputLoginCred.passwordInvalid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Please enter valid Email ID/Mobile number");
    }

    @Test(priority = 6)
    public static void loginWithInvalidUsernameValidPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).sendKeys(InputLoginCred.phoneInvalid);
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(InputLoginCred.passwordValid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Please enter valid Email ID/Mobile number");
    }

    @Test(priority = 7)
    public static void loginWithValidUsernameWithoutPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).sendKeys(InputLoginCred.phoneValid);
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(Keys.CONTROL+"a"+Keys.CONTROL+Keys.BACK_SPACE);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        WebElement elementErrorMessage = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorLoginTest.errorMessagePassword)));
        Assert.assertEquals(elementErrorMessage.getText(),"Please enter Password");
    }

    @Test(priority = 8)
    public static void loginWithValidUsernameInvalidPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).sendKeys(InputLoginCred.phoneValid);
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(InputLoginCred.passwordInvalid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertEquals(Browser.driver.findElement(By.cssSelector(LocatorLoginTest.errorMessageEmailOrPhone)).getText(),"Your username or password is incorrect");
    }

    @Test(priority = 9)
    public static void loginWithValidUsernameAndPassword(){
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).clear();
        Browser.driver.findElement(By.xpath(LocatorLoginTest.inputEmailOrPhone)).sendKeys(InputLoginCred.phoneValid);
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).clear();
        Browser.driver.findElement(By.cssSelector(LocatorLoginTest.inputPassword)).sendKeys(InputLoginCred.passwordValid);
        Browser.driver.findElement(By.xpath(LocatorLoginTest.buttonLoginInLoginPage)).click();
        Assert.assertTrue(Browser.driver.findElement(By.xpath(LocatorLoginTest.navItemUserName)).isDisplayed());
    }
}
