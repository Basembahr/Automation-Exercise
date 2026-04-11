import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enter_Account_Info_Page extends Page_Base{

    public Enter_Account_Info_Page(WebDriver driver) {
        super(driver);

    }
    By MrTap = By.id("uniform-id_gender1");
    By password = By.xpath("//input[@data-qa='password']");
    By days = By.xpath("//select[@data-qa='days']");
    By months = By.xpath("//select[@data-qa='months']");
    By Years = By.xpath("//select[@data-qa='years']");
    By first_name = By.xpath("//input[@data-qa='first_name']");
    By last_name = By.xpath("//input[@data-qa='last_name']");
    By company = By.xpath("//input[@data-qa='company']");
    By Adress1 = By.xpath("//input[@data-qa='address']");
    By Address2 = By.xpath("//input[@data-qa='address2']");
    By country = By.xpath("//select[@data-qa='country']");
    By state = By.xpath("//input[@data-qa='state']");
    By city = By.xpath("//input[@data-qa='city']");
    By zipcode = By.xpath("//input[@data-qa='zipcode']");
    By mob_number = By.xpath("//input[@data-qa='mobile_number']");
    By createAccount_Tap = By.xpath("//button[@data-qa='create-account']");
    By continue_Tap = By.xpath("//a[@data-qa='continue-button']");

    public void Button_Mr(){
        wait(MrTap);
        Click_Button(MrTap);
    }
    public void Create_Password(){
        wait(password);
        Enter_Text(password,"1234567");
    }
    public void Birth_Date(){
        wait(days);
        Select_by_index(days,23);
        wait(months);
        Select_by_value(months,"12");
        wait(Years);
        Select_by_visible(Years,"1993");

    }
    public void Enter_First_Name(){
        wait(first_name);
        Enter_Text(first_name,"Bassem");
    }
    public void Enter_Last_Name(){
        wait(last_name);
        Enter_Text(last_name,"Bahr");
    }
    public void Enter_Company_Name(){
        wait(company);
        Enter_Text(company,"MakePlace");
    }
    public void Enter_Address1(){
        wait(Adress1);
        Enter_Text(Adress1,"Naser City");

    }
    public void Enter_Address2(){
        wait(Address2);
        Enter_Text(Address2," 5th New Cairo City");
    }
    public void Enter_Country(){
        wait(country);
        Select_by_value(country,"Canada");
    }
    public void Enter_State(){
        wait(state);
        Enter_Text(state,"statement");
    }
    public void Enter_City(){
        wait(city);
        Enter_Text(city,"Moscow");
    }
    public void Enter_Zipcode(){
        wait(zipcode);
        Enter_Text(zipcode,"12345");
    }
    public void Enter_Mobile_number(){
        wait(mob_number);
        Enter_Text(mob_number,"01094656111");
    }
    public void Button_on_Create_Account(){
        wait(createAccount_Tap);
        Click_Button(createAccount_Tap);
    }
    public void Button_on_Continue(){
        wait(continue_Tap);
        Click_Button(continue_Tap);
    }

}

