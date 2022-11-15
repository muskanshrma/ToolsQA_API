package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import Pages.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;

public class BaseClass {

    protected static PageFactory pageFactory;
    static WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public static void setup(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.navigate().to("https://demoqa.com/");
            pageFactory = new PageFactory(driver);
        }
    }
    @AfterClass
    public static void close() {
        driver.close();
    }
}