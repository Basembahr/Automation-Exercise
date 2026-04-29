import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Products extends Page_Base{

    public Products(WebDriver driver) {super(driver);
    }
    By search = By.className("input-lg");
    By Search_Tap =By.className("btn-lg");
    By cont_shop_Tap = By.xpath("//button[@data-dismiss='modal']");
    By view_cart = new By.ByLinkText("View Cart");
    By delete_Tap =By.cssSelector("i.fa.fa-times");
    public void Search_Product(){
        wait(search);
        Enter_Text(search,"Sleeveless Dress");
        wait(Search_Tap);
        Click_Button(Search_Tap);
    }

    public void Add_Product(String productId){
        addProductToCartById(productId);
    }

    public void View_Pro(){
        WebElement viewCartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(view_cart));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartButton);
    }
    public void Delete_Cart(){
        wait(delete_Tap);
        Click_Button(delete_Tap);
    }

    public void Continue_Shopping(){
        wait(cont_shop_Tap);
        Click_Button(cont_shop_Tap);
    }

    public void addProductToCartById(String productId) {

        By productCard = By.xpath("(//a[@data-product-id='" + productId + "']/ancestor::div[contains(@class,'product-image-wrapper')])[1]");
        By addButtonLocator = By.xpath("(//a[@data-product-id='" + productId + "'])[1]");

        WebElement card = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(productCard));

        new Actions(driver).moveToElement(card).perform();

        WebElement addButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(addButtonLocator));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
    }

}
