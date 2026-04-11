import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CONTACT_US extends Page_Base{
    public CONTACT_US(WebDriver driver) {
        super(driver);
    }
    By enterName = By.xpath("//input[@data-qa='name']");
    By enterEmail = By.xpath("//input[@data-qa='email']");
    By enterSubject = By.xpath("//input[@data-qa='subject']");
    By enterMessage = By.xpath("//textarea[@data-qa='message']");
    By submit_Tap = By.xpath("//input[@data-qa='submit-button']");
    public void Enter_Name_Contact_us() {
        wait(enterName);
        Enter_Text(enterName,"bassem");
    }
    public void Enter_Email_Contact_us() {
        wait(enterEmail);
        Enter_Text(enterEmail,"beso123456@gmail.com");
    }
    public void Enter_Subject_Contact_us() {
        wait(enterSubject);
        Enter_Text(enterSubject,"Test");
    }
    public void Enter_Message_Contact_us() {
        wait(enterMessage);
        Enter_Text(enterMessage,"Welcome to my project");
    }
    public void Submit_Button_Contact_us() {
        wait(submit_Tap);
        Click_Button(submit_Tap);
    }

}
