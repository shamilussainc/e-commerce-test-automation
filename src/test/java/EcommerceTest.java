import commonLib.Browser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EcommerceTest {

    @BeforeClass
    public void openChrome(){
        Browser.openBrowser("Chrome");
    }

    @Test(priority = 1)
    public void gotowebsite(){
        Browser.navigate("http://automationpractice.com/");
    }

                                                                        
}
