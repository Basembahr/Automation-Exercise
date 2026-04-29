import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Page_Base {
    By log_Email = By.xpath("//input[@data-qa='login-email']");
    By log_Password = By.xpath("//input[@data-qa='login-password']");
    By log_Tap = By.xpath("//button[@data-qa='login-button']");
    public Login(WebDriver driver) {
        super(driver);
    }

    public void login_Email(){
        wait(log_Email);
        Enter_Text(log_Email, "Beso123456445781@gamil.com");
    }

    public void login_Password(){
        wait(log_Password);
        Enter_Text(log_Password, "1234567");
    }
    public void Login_Button(){
        wait(log_Tap);
        Click_Button(log_Tap);
    }

}
