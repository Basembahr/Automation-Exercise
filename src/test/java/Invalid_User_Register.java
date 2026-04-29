import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Invalid_User_Register extends Test_Base{
    @Test (priority = 1)
    public void Run_Invalid_user_register(){
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Sign_Up signUp = new Sign_Up(driver);
        signUp.Invalid_Enter_name();
        signUp.Invalid_Enter_Email();
        signUp.signup_Button();

        SoftAssert softAssert = new SoftAssert();

        By emailField = By.xpath("//input[@data-qa='signup-email']");
        String actualMessage = driver.findElement(emailField).getAttribute("validationMessage");

        softAssert.assertTrue(
                actualMessage.contains("Please enter a part followed by '@'"),
                " Main validation message is missing!");

        softAssert.assertTrue(
                actualMessage.contains("incomplete"),
                " Email format validation is incorrect!");

        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(
                currentUrl.contains("login") || currentUrl.contains("signup"),
                " System allowed invalid email format!");
    }
    @Test(priority = 2)
    public void Run_Existing_Email() {

        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();

        Sign_Up signUp = new Sign_Up(driver);
        signUp.Enter_name();
        signUp.Existing_Email();
        signUp.signup_Button();

        SoftAssert softAssert = new SoftAssert();

        By errorMessage = By.xpath("//p[contains(text(),'Email Address already exist!')]");
        String actualMessage = driver.findElement(errorMessage).getText();

        softAssert.assertTrue(actualMessage.contains("Email Address already exist!"),
                "Error message is NOT displayed correctly");

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void Run_Empty_Fields() {

        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();

        Sign_Up signUp = new Sign_Up(driver);
        signUp.signup_Button();

        SoftAssert softAssert = new SoftAssert();

        By emailField = By.xpath("//input[@data-qa='signup-email']");

        String validationMessage = driver.findElement(emailField)
                .getAttribute("validationMessage");

        softAssert.assertTrue(validationMessage.contains("Please fill out this field."),
                "Validation message is NOT displayed!");

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void Run_Empty_Email() {

        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();

        Sign_Up signUp = new Sign_Up(driver);
        signUp.Enter_name();
        signUp.signup_Button();

        SoftAssert softAssert = new SoftAssert();

        By emailField = By.xpath("//input[@data-qa='signup-email']");

        String validationMessage = driver.findElement(emailField)
                .getAttribute("validationMessage");

        softAssert.assertTrue(validationMessage.contains("Please fill out this field."),
                "Email validation message is NOT displayed!");

        softAssert.assertAll();
    }
}
