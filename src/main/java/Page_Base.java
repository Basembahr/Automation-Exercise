import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_Base {

    public Page_Base(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void Enter_Text(By elementlocator , String text){
        driver.findElement(elementlocator).sendKeys(text);
   }

   public void Click_Button(By elementlocator ){
        driver.findElement(elementlocator).click();
   }

   public void wait(By elementlocator){
       WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(30));
       wait.until(ExpectedConditions.presenceOfElementLocated(elementlocator));
   }

   public void Select_by_index(By elementlocator , int index ){
       Select select = new Select(driver.findElement(elementlocator));
       select.selectByIndex(index);
   }
   public void Select_by_value (By elementlocator , String value ){
        Select select = new Select(driver.findElement(elementlocator));
        select.selectByValue(value);
   }
   public void Select_by_visible(By elementlocator , String Text ){
        Select select = new Select(driver.findElement(elementlocator));
        select.selectByVisibleText(Text);
   }
    public void enter_text_By_Index(By elementlocator ,int index ,String text) {
        driver.findElements(elementlocator).get(index).sendKeys(text);
    }
    public void click_button_By_Index(By elementlocator ,int index ){
        driver.findElements(elementlocator).get(index).click();
    }
}

