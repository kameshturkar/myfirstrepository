package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POJO.Browser;
import pom.ZerodhaLoginPage;
import pom.ZerodhaSignUpPage;

public class ZerodhaSignupPagetest extends DeclaireDriver {

	//WebDriver driver;
	@BeforeMethod
	public void OpenBrowser()
	{
		driver = Browser.browser();
	}
	
	@Test
	public void signUpPageOpentest()
	{
		ZerodhaLoginPage zerodhalogicpage = new ZerodhaLoginPage(driver);
		zerodhalogicpage.signUp();
		Set<String> adresses = driver.getWindowHandles();
		Iterator<String> k =  adresses.iterator();
		while(k.hasNext())
		{
			String adress = k.next();
			driver.switchTo().window(adress);
			String currenttitle = driver.getTitle();
			//System.out.println(currenttitle);
			String title = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		    if(currenttitle.equals(title))
		    {
		    	ZerodhaSignUpPage zerodhasignuppage = new ZerodhaSignUpPage(driver);
		    	zerodhasignuppage.entermobileNo("5544663322");
		    	
		    }
		}
	}
}
