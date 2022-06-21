package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignUpPage {

	@FindBy(xpath="//input[@name='mobile']") private WebElement mobileNo;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	@FindBy(xpath="(//a[text()='Signup'])[1]") private WebElement signUp;
	@FindBy(xpath="(//a[text()='Pricing'])[1]") private WebElement pricing;
	
	public ZerodhaSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void entermobileNo(String mobno)
	{
		mobileNo.sendKeys(mobno);
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	
	public void clickOnSignUP()
	{
		signUp.click();
	}
	
	public void clickOnPricing()
	{
		pricing.click();
	}
}
