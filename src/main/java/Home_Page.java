import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page extends Page_Base{
    By homeTap = By.cssSelector("i.fa.fa-home");
    By signupTap = By.cssSelector(".fa.fa-lock");
    By productsTap = By.cssSelector("i.material-icons.card_travel");
    By cart_Tap = By.cssSelector("i.fa.fa-shopping-cart");
    By logoutTap = By.cssSelector("i.fa.fa-lock");
    By deleteACC_Tap =By.cssSelector("i.fa.fa-trash-o");
    By contactUs_Tap = By.cssSelector("i.fa.fa-envelope");
    public Home_Page(WebDriver driver) {
        super(driver);
    }

    public void Home_TAP(){
        wait(homeTap);
        Click_Button(homeTap);
    }

    public void Signup_Tap(){
        wait(signupTap);
        Click_Button(signupTap);
    }
    public void Products_Tap(){
        wait(productsTap);
        Click_Button(productsTap);
    }
    public void Button_on_Cart(){
        wait(cart_Tap);
        Click_Button(cart_Tap);
    }
    public void LOGOUT_TAP(){
        wait(logoutTap);
        Click_Button(logoutTap);
    }
    public void Delete_ACCOUNT(){
        wait(deleteACC_Tap);
        Click_Button(deleteACC_Tap);
    }
    public void Contact_US(){
        wait(contactUs_Tap);
        Click_Button(contactUs_Tap);
    }



}
