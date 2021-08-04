package commonLib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browser {
    public static WebDriver driver;

    public static String openBrowser(String bType){
        System.out.println("****************openBrowser********************");
        System.out.println("browser type---"+bType);
        try{
            switch (bType) {
                case "Mozilla" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }
                case "Chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }
                case "IE" -> {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                }
            }
        }
        catch(Exception exception){
            // any error2
            System.out.println(exception);
        }
        return "Fail to open browser";
    }

    public static void navigate(String url){
        try
        {
            System.out.println("\n");
            System.out.println("----------------------------------------------------------");
            System.out.println("\n");
            driver.navigate().to(url);
        }
        catch(Exception Exception)
        {
            System.out.println(Exception);
        }
    }
}
