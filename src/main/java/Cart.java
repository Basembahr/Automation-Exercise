import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart extends Page_Base{
    public Cart(WebDriver driver) {
        super(driver);
    }

    By check_out_Tap = By.cssSelector("a.btn.btn-default.check_out");



    public void Check_Out_Cart(){
        wait(check_out_Tap);
        Click_Button(check_out_Tap);
    }
}
