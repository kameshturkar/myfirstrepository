package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POJO.Browser;
import pom.ZerodhaLoginPage;
import utility.Parameterise;

@Listeners(TestListeners.class)

public class ZerodhaLoginpagetest extends DeclaireDriver {
     
	//WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = Browser.browser();
	}
	
	@Test
	public void loginWithValidCredentialtest() throws EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String userid =  Parameterise.Exceldata(0, 1);
		String pass = Parameterise.Exceldata(1, 1);
		zerodhaLoginPage.UserId(userid);
		zerodhaLoginPage.Password(pass);
		zerodhaLoginPage.Login();
	}
	
	@Test
	public void loginwithoutcredential() throws EncryptedDocumentException, IOException
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.Login();
		String text = zerodhaLoginPage.geterrortext();
		String exceptedvalue = "User ID should be minimum 6 klmjh characters." ;
		Assert.assertEquals(text, exceptedvalue);
		//SoftAssert softassert = new SoftAssert();
		//softassert.assertEquals(text, exceptedvalue);
		String userid =  Parameterise.Exceldata(0, 1);
		String pass = Parameterise.Exceldata(1, 1);
		zerodhaLoginPage.UserId(userid);
		zerodhaLoginPage.Password(pass);
		zerodhaLoginPage.Login();
		//softassert.assertAll();
	}
	
	@Test (dependsOnMethods = {"loginwithoutcredential"})
	public void forgetPasswordLinktest()
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.ForgotPassword();
	}
	
	@Test
	public void signupPagelinktest()
	{
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.signUp();
	}
}
