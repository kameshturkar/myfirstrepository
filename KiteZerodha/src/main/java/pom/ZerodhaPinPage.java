package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaPinPage {
      
	@FindBy(xpath="//input[@id='pin']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	@FindBy(xpath="//a[text()='Forgot 2FA?']") private WebElement forgotpin;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	
	
	public ZerodhaPinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPin(String pinNo,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinNo);
	}
	
	public void clicksOnSubmit()
	{
		submit.click();
	}
	
	public void clicksOnforgotpin()
	{
		forgotpin.click();
	}
	
	public void clicksOnSignUp()
	{
		signUp.click();
	}
}
