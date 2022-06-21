package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaLoginPage {
     @FindBy(xpath="//input[@id='userid']") private WebElement userID;
     @FindBy(xpath="//input[@id='password']") private WebElement password;
     @FindBy(xpath="//button[@class='button-orange wide']") private WebElement login;
     @FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement forgotpassword;
     @FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement SignupNow;
     @FindBy(xpath="(//span[@class='su-message'])[1]") private WebElement errortext;
     
     
     public ZerodhaLoginPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
      
     
     
     public void UserId(String username)
     {
    	 userID.sendKeys(username);
     }
     
     public void Password(String pass)
     {
    	 password.sendKeys(pass);
     }
     
     public void Login()
     {
    	 login.click();
     }
     
     public void ForgotPassword()
     {
    	 forgotpassword.click();
     }
     
     public void signUp()
     {
    	 SignupNow.click();
     }
     public String  geterrortext()
     {
    	String text =  errortext.getText();
    	return text;
     }
}
