package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POJO.Browser;
import pom.ZerodhaLoginPage;
import pom.ZerodhaPinPage;
import utility.Parameterise;

@Listeners(TestListeners.class)

public class ZerodhaPinPagetest extends DeclaireDriver {
   //WebDriver driver;
   
   @BeforeMethod
   public void openBrowser()
   {
	 driver =   Browser.browser();
   }
   
   @Test
   public void logintoZerodhawithPintest() throws EncryptedDocumentException, IOException, InterruptedException
   {
      ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
      String userId = Parameterise.Exceldata(0, 1);
      String pass = Parameterise.Exceldata(1, 1);
      zerodhaloginpage.UserId(userId);
      zerodhaloginpage.Password(pass);
      zerodhaloginpage.Login();
      Thread.sleep(2000);
      String pin = Parameterise.Exceldata(2, 1);
      ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
      zerodhaPinPage.enterPin(pin,driver);
      zerodhaPinPage.clicksOnSubmit();
   }
   
   @Test
   public void checkForgetPinlinktest() throws EncryptedDocumentException, IOException, InterruptedException
   {
	   ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
	      String userId = Parameterise.Exceldata(0, 1);
	      String pass = Parameterise.Exceldata(1, 1);
	      zerodhaloginpage.UserId(userId);
	      zerodhaloginpage.Password(pass);
	      zerodhaloginpage.Login();
	      Thread.sleep(2000);
	      ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
	      zerodhaPinPage.clicksOnforgotpin();
   }
   @Test
   public void checkSignUplinktest() throws InterruptedException, EncryptedDocumentException, IOException
   {
	   ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
	      String userId = Parameterise.Exceldata(0, 1);
	      String pass = Parameterise.Exceldata(1, 1);
	      zerodhaloginpage.UserId(userId);
	      zerodhaloginpage.Password(pass);
	      zerodhaloginpage.Login();
	      Thread.sleep(2000);
	      ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
	      zerodhaPinPage.clicksOnSignUp();
   }
}