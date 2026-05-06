import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Valid_User_Register extends Test_Base {
    @Test(priority = 1)
    public void Run_Valid_Create_Account() {
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Sign_Up signUp = new Sign_Up(driver);
        signUp.Enter_name();
        signUp.Enter_Email();
        signUp.signup_Button();
        Enter_Account_Info_Page createAcc = new Enter_Account_Info_Page(driver);
        createAcc.Button_Mr();
        createAcc.Create_Password();
        createAcc.Birth_Date();
        createAcc.Enter_First_Name();
        createAcc.Enter_Last_Name();
        createAcc.Enter_Company_Name();
        createAcc.Enter_Address1();
        createAcc.Enter_Address2();
        createAcc.Enter_Country();
        createAcc.Enter_State();
        createAcc.Enter_City();
        createAcc.Enter_Zipcode();
        createAcc.Enter_Mobile_number();
        createAcc.Button_on_Create_Account();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/account_created",
                "Account Created page URL is not correct");

        By accountCreatedMsg = By.xpath("//b[contains(text(),'Account Created!')]");
        softAssert.assertTrue(driver.findElement(accountCreatedMsg).isDisplayed(),
                "Account Created message is NOT displayed");

        createAcc.Button_on_Continue();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/",
                "User is not redirected to Home page after clicking Continue");

        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void Run_Valid_Login() {
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();
        SoftAssert softAssert = new SoftAssert();

        By logout = By.linkText("Logout");
        By deleteAccount = By.linkText("Delete Account");

        softAssert.assertTrue(driver.findElement(logout).isDisplayed(),
                "Logout button is NOT displayed");

        softAssert.assertTrue(driver.findElement(deleteAccount).isDisplayed(),
                "Delete Account button is NOT displayed");

        softAssert.assertAll();

    }
    @Test(priority = 3)
    public void Run_Valid_LOGOUT(){
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();
        homePage.LOGOUT_TAP();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/login",
                "User is not redirected to Login page after logout");

        By loginButton = By.xpath("//button[@data-qa='login-button']");
        softAssert.assertTrue(driver.findElement(loginButton).isDisplayed(),
                "Login button is NOT displayed after logout");

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void Run_Valid_DELETE_Account() {
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();
        homePage.Delete_ACCOUNT();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/delete_account",
                "Delete Account page URL is not correct");

        By deleteAccountMsg = By.xpath("//b[contains(text(),'Account Deleted!')]");
        softAssert.assertTrue(driver.findElement(deleteAccountMsg).isDisplayed(),
                "Account Deleted message is NOT displayed");

        softAssert.assertAll();
    }



    @Test(priority = 5)
    public void Run_Valid_Search_Products() {
        Home_Page products = new Home_Page(driver);
        products.Products_Tap();

        Products products1 = new Products(driver);
        products1.Search_Product();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products?search=Sleeveless%20Dress", "Sleeveless Dress");

        products1.Add_Product("3");

        WebElement message = driver.findElement(By.className("modal-body"));
        String actualMessage = message.getText();
        softAssert.assertTrue(actualMessage.contains("Your product has been added to cart."), "Product not added message is missing");

        products1.View_Pro();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

    }


    @Test(priority = 6)
    public void Run_Valid_Add_Cart() {

        Home_Page ADD_CART = new Home_Page(driver);
        ADD_CART.Products_Tap();

        Products products1 = new Products(driver);
        products1.Add_Product("2");

        products1.View_Pro();

        Cart cart = new Cart(driver);
        cart.Check_Out_Cart();

        SoftAssert softAssert = new SoftAssert();

        By checkoutPopup = By.className("modal-body");
        String actualPopupMessage = driver.findElement(checkoutPopup).getText();

        softAssert.assertTrue(actualPopupMessage.contains("Register / Login account to proceed on checkout."),
                "Checkout login/register popup message is NOT displayed");

        By continueOnCartButton = By.xpath("//button[contains(text(),'Continue On Cart')]");
        softAssert.assertTrue(driver.findElement(continueOnCartButton).isDisplayed(),
                "Continue On Cart button is NOT displayed");

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/view_cart",
                "User should remain on View Cart page");

        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void Run_Products_TC_003() {

        // Navigate to Login Page
        Home_Page home = new Home_Page(driver);
        home.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();

        // Navigate to Products Page
        home.Products_Tap();
        Products products = new Products(driver);

        // Add first product
        products.Add_Product("1"); // Blue Top
        products.Continue_Shopping();

        // Add second product
        products.Add_Product("2"); // Men Tshirt
        products.Continue_Shopping();

        // Add third product
        products.Add_Product("3"); // Sleeveless Dress
        products.View_Pro(); // View Cart



        SoftAssert softAssert = new SoftAssert();

        //  Verify URL
        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/view_cart",
                "User is NOT redirected to View Cart page");

        //  Verify number of products in cart
        int productsCount = driver.findElements(By.xpath("//tr[contains(@id,'product-')]")).size();

        softAssert.assertEquals(productsCount, 3,
                "Cart does NOT contain 3 products");

        //  Verify product names
        String pageSource = driver.getPageSource();

        softAssert.assertTrue(pageSource.contains("Blue Top"),
                "Blue Top is missing");

        softAssert.assertTrue(pageSource.contains("Men Tshirt"),
                "Men Tshirt is missing");

        softAssert.assertTrue(pageSource.contains("Sleeveless Dress"),
                "Sleeveless Dress is missing");

        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void Run_Valid_Contact_us() {
        Home_Page contact_us = new Home_Page(driver);
        contact_us.Contact_US();
        CONTACT_US contactus = new CONTACT_US(driver);
        contactus.Enter_Name_Contact_us();
        contactus.Enter_Email_Contact_us();
        contactus.Enter_Subject_Contact_us();
        contactus.Enter_Message_Contact_us();
        contactus.Submit_Button_Contact_us();
        SoftAssert softAssert = new SoftAssert();

        By successMessage = By.xpath("//div[contains(@class,'status') and contains(text(),'Success! Your details have been submitted successfully.')]");

        softAssert.assertTrue(driver.findElement(successMessage).isDisplayed(),
                "Contact Us success message is NOT displayed");

        softAssert.assertTrue(driver.findElement(successMessage).getText()
                        .contains("Success! Your details have been submitted successfully."),
                "Contact Us success message text is incorrect");

        softAssert.assertAll();
    }

}

public class Valid_User_Register extends Test_Base {
    @Test(priority = 1)
    public void Run_Valid_Create_Account() {
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Sign_Up signUp = new Sign_Up(driver);
        signUp.Enter_name();
        signUp.Enter_Email();
        signUp.signup_Button();
        Enter_Account_Info_Page createAcc = new Enter_Account_Info_Page(driver);
        createAcc.Button_Mr();
        createAcc.Create_Password();
        createAcc.Birth_Date();
        createAcc.Enter_First_Name();
        createAcc.Enter_Last_Name();
        createAcc.Enter_Company_Name();
        createAcc.Enter_Address1();
        createAcc.Enter_Address2();
        createAcc.Enter_Country();
        createAcc.Enter_State();
        createAcc.Enter_City();
        createAcc.Enter_Zipcode();
        createAcc.Enter_Mobile_number();
        createAcc.Button_on_Create_Account();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/account_created",
                "Account Created page URL is not correct");

        By accountCreatedMsg = By.xpath("//b[contains(text(),'Account Created!')]");
        softAssert.assertTrue(driver.findElement(accountCreatedMsg).isDisplayed(),
                "Account Created message is NOT displayed");

        createAcc.Button_on_Continue();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/",
                "User is not redirected to Home page after clicking Continue");

        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void Run_Valid_Login() {
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();
        SoftAssert softAssert = new SoftAssert();

        By logout = By.linkText("Logout");
        By deleteAccount = By.linkText("Delete Account");

        softAssert.assertTrue(driver.findElement(logout).isDisplayed(),
                "Logout button is NOT displayed");

        softAssert.assertTrue(driver.findElement(deleteAccount).isDisplayed(),
                "Delete Account button is NOT displayed");

        softAssert.assertAll();

    }
    @Test(priority = 3)
    public void Run_Valid_LOGOUT(){
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();
        homePage.LOGOUT_TAP();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/login",
                "User is not redirected to Login page after logout");

        By loginButton = By.xpath("//button[@data-qa='login-button']");
        softAssert.assertTrue(driver.findElement(loginButton).isDisplayed(),
                "Login button is NOT displayed after logout");

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void Run_Valid_DELETE_Account() {
        Home_Page homePage = new Home_Page(driver);
        homePage.Signup_Tap();
        Login login = new Login(driver);
        login.login_Email();
        login.login_Password();
        login.Login_Button();
        homePage.Delete_ACCOUNT();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/delete_account",
                "Delete Account page URL is not correct");

        By deleteAccountMsg = By.xpath("//b[contains(text(),'Account Deleted!')]");
        softAssert.assertTrue(driver.findElement(deleteAccountMsg).isDisplayed(),
                "Account Deleted message is NOT displayed");

        softAssert.assertAll();
    }



    @Test(priority = 5)
    public void Run_Valid_Search_Products() {
        Home_Page products = new Home_Page(driver);
        products.Products_Tap();

        Products products1 = new Products(driver);
        products1.Search_Product();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products?search=Sleeveless%20Dress", "Sleeveless Dress");

        products1.Add_Product("3");

        WebElement message = driver.findElement(By.className("modal-body"));
        String actualMessage = message.getText();
        softAssert.assertTrue(actualMessage.contains("Your product has been added to cart."), "Product not added message is missing");

        products1.View_Pro();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

    }


    @Test(priority = 6)
    public void Run_Valid_Add_Cart() {

        Home_Page ADD_CART = new Home_Page(driver);
        ADD_CART.Products_Tap();

        Products products1 = new Products(driver);
        products1.Add_Product("2");

        products1.View_Pro();

        Cart cart = new Cart(driver);
        cart.Check_Out_Cart();

        SoftAssert softAssert = new SoftAssert();

        By checkoutPopup = By.className("modal-body");
        String actualPopupMessage = driver.findElement(checkoutPopup).getText();

        softAssert.assertTrue(actualPopupMessage.contains("Register / Login account to proceed on checkout."),
                "Checkout login/register popup message is NOT displayed");

        By continueOnCartButton = By.xpath("//button[contains(text(),'Continue On Cart')]");
        softAssert.assertTrue(driver.findElement(continueOnCartButton).isDisplayed(),
                "Continue On Cart button is NOT displayed");

        softAssert.assertEquals(driver.getCurrentUrl(),
                "https://automationexercise.com/view_cart",
                "User should remain on View Cart page");

        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void Run_Valid_Contact_us() {
        Home_Page contact_us = new Home_Page(driver);
        contact_us.Contact_US();
        CONTACT_US contactus = new CONTACT_US(driver);
        contactus.Enter_Name_Contact_us();
        contactus.Enter_Email_Contact_us();
        contactus.Enter_Subject_Contact_us();
        contactus.Enter_Message_Contact_us();
        contactus.Submit_Button_Contact_us();
        SoftAssert softAssert = new SoftAssert();

        By successMessage = By.xpath("//div[contains(@class,'status') and contains(text(),'Success! Your details have been submitted successfully.')]");

        softAssert.assertTrue(driver.findElement(successMessage).isDisplayed(),
                "Contact Us success message is NOT displayed");

        softAssert.assertTrue(driver.findElement(successMessage).getText()
                        .contains("Success! Your details have been submitted successfully."),
                "Contact Us success message text is incorrect");

        softAssert.assertAll();
    }

}
