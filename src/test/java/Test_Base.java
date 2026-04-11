import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Test_Base {
    WebDriver driver;
    @BeforeMethod
    public void before_test(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");

    }

    @AfterMethod
    public void After_test() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }
}
