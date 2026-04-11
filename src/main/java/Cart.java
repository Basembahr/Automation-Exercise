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
    By prod_Ima =By.xpath("//div[@class='product-image-wrapper'][1]");
    By add_product_Tap = By.xpath("//a[@data-product-id='1']");
    By check_out_Tap = By.cssSelector("a.btn.btn-default.check_out");

    public void Add_product(){
        WebElement productCard = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(prod_Ima));

        new Actions(driver).moveToElement(productCard).perform();

        WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(add_product_Tap));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
    }

    public void Check_Out_Cart(){
        wait(check_out_Tap);
        Click_Button(check_out_Tap);
    }
}
