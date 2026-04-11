import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Invalid_User_Register extends Test_Base{
    @Test
    public void Run_Invalid_user_register(){
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");
        Sign_Up signUp = new Sign_Up(driver);
        signUp.Invalid_Enter_name();
        signUp.Invalid_Enter_Email();
        signUp.signup_Button();
    }
}
