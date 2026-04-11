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
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/account_created");
        createAcc.Button_on_Continue();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        /*String actualTittle = driver.getTitle();
        softAssert.assertEquals(actualTittle,"https://automationexercise.com/account_created","Automation Exercise - Account Created");*/
        /*WebElement h2 = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        softAssert.assertTrue(h2.getText().contains("Account Created"), "Not Account Created");*/
        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void Run_Valid_Search_Products() {
        Home_Page products = new Home_Page(driver);
        products.Products_Tap();

        Products products1 = new Products(driver);
        products1.Search_Product();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/products?search=Sleeveless%20Dress", "Sleeveless Dress");

        products1.Add_Cart();

        WebElement message = driver.findElement(By.className("modal-body"));
        String actualMessage = message.getText();
        softAssert.assertTrue(actualMessage.contains("Your product has been added to cart."), "Product not added message is missing");

        products1.View_Pro();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart");


        //products1.Delete_Cart();

        //products1.Check_Out_Cart();

        /*products1.Continue_Shopping();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/products?search=Sleeveless%20Dress");*/
        //softAssert.assertAll();
    }

    @Test(priority = 3)
    public void Run_Valid_Add_Cart() {
        Home_Page ADD_CART = new Home_Page(driver);
        ADD_CART.Products_Tap();
        Cart cart = new Cart(driver);
        cart.Add_product();
        ADD_CART.Button_on_Cart();
        cart.Check_Out_Cart();
    }
    @Test(priority = 4)
    public void Run_Valid_Contact_us() {
        Home_Page contact_us = new Home_Page(driver);
        contact_us.Contact_US();
        CONTACT_US contactus = new CONTACT_US(driver);
        contactus.Enter_Name_Contact_us();
        contactus.Enter_Email_Contact_us();
        contactus.Enter_Subject_Contact_us();
        contactus.Enter_Message_Contact_us();
        contactus.Submit_Button_Contact_us();


    }

}
