import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sign_Up extends Page_Base{

    By name = By.xpath("//input[@data-qa='signup-name']");
    By Email = By.xpath("//input[@data-qa='signup-email']");
    By Button_on_signup = By.xpath("//button[@data-qa='signup-button']");

    public Sign_Up(WebDriver driver) {
        super(driver);
    }

    public void Enter_name(){
        wait(name);
        Enter_Text(name,"Bassem");
    }

    public void Enter_Email(){
        wait(Email);
        Enter_Text(Email,"Beso123456445781@gamil.com");
    }

    public void signup_Button(){
        wait(Button_on_signup);
        Click_Button(Button_on_signup);
    }

    public void Invalid_Enter_name(){
        wait(name);
        Enter_Text(name,"@@@@@@");
    }

    public void Invalid_Enter_Email(){
        wait(Email);
        Enter_Text(Email,"@@@@@@");
    }

    public void Existing_Email(){
        wait(Email);
        Enter_Text(Email,"Beso123456445781@gamil.com");

    }

}
