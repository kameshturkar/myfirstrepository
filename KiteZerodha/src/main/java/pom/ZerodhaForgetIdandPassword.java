package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZerodhaForgetIdandPassword {

	@FindBy(xpath="//input[@id='radio-30']") private WebElement irememberRadiob;
	@FindBy(xpath="//input[@id='radio-31']") private WebElement iforgotRadiob;
	@FindBy(xpath="//input[@placeholder='User ID']") private WebElement userId;
	@FindBy(xpath="//input[@placeholder='PAN']") private WebElement pan;
	@FindBy(xpath="//input[@placeholder='E-mail (as on account)']") private WebElement e_mail;
	@FindBy(xpath="//input[@id='radio-35']") private WebElement e_mailRadio;
	@FindBy(xpath="//input[@id='radio-36']") private WebElement smsRadio;
	@FindBy(xpath="//button[@type='submit']") private WebElement reset;
	
	
}
