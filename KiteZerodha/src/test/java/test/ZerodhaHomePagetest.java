package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import pom.ZerodhaPinPage;
import utility.Parameterise;
import utility.Report;

@Listeners(TestListeners.class)

public class ZerodhaHomePagetest extends DeclaireDriver {
 
	ExtentReports report;
	ExtentTest test;
	//WebDriver driver;
	
	@BeforeTest
	public void extentReports()
	{
		report = Report.createReport();
	}
	
	 @BeforeMethod
	   public void openBrowser()
	   {
		 driver =   Browser.browser();
	   }
	 
	 @Test
	 public void homepageBuyandselltest() throws EncryptedDocumentException, IOException, InterruptedException
	 {
		 test = report.createTest("homepageBuyandselltest");
		 ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
	      String userId = Parameterise.Exceldata(0, 1);
	      String pass = Parameterise.Exceldata(1, 1);
	      zerodhaloginpage.UserId(userId);
	      zerodhaloginpage.Password(pass);
	      zerodhaloginpage.Login();
	      
	      String pin = Parameterise.Exceldata(2, 1);
	      ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
	      zerodhaPinPage.enterPin(pin,driver);
	      zerodhaPinPage.clicksOnSubmit();
	      ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
	      String sharename = "tatapower";
	      zerodhahomepage.clickonSearch(sharename);
	      zerodhahomepage.clickonsharebuy(driver);
	      String numbershare = "6";
	      zerodhahomepage.addQuantityofshare(numbershare);
	      zerodhahomepage.clickonRadiobuttonmarket();

	      zerodhahomepage.clickonFinalbuy();
	 }
	 
	 @Test
	 public void homepagebuyfromwatchlisttest() throws EncryptedDocumentException, IOException, InterruptedException
	 {
		 test = report.createTest("homepagebuyfromwatchlisttest");
		 ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
	      String userId = Parameterise.Exceldata(0, 1);
	      String pass = Parameterise.Exceldata(1, 1);
	      zerodhaloginpage.UserId(userId);
	      zerodhaloginpage.Password(pass);
	      zerodhaloginpage.Login();
	      
	      String pin = Parameterise.Exceldata(2, 1);
	      ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
	      zerodhaPinPage.enterPin(pin,driver);
	      zerodhaPinPage.clicksOnSubmit();
	      Thread.sleep(3000);
	      ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
	      zerodhahomepage.homepagebuyfromwatchlist(driver);
	      zerodhahomepage.clickonfirstBuy(driver);
	      Thread.sleep(2000);
	      zerodhahomepage.addQuantityofshare("25");
	      zerodhahomepage.clickonRadiobuttonmarket();
	      zerodhahomepage.clickonFinalbuy();
	      
	 }
	 
	 @Test
	 public void homePageChartCheckfromWatchlist() throws EncryptedDocumentException, IOException, InterruptedException
	 {
		 test = report.createTest("homePageChartCheckfromWatchlist");
		 ZerodhaLoginPage zerodhaloginpage = new ZerodhaLoginPage(driver);
	      String userId = Parameterise.Exceldata(0, 1);
	      String pass = Parameterise.Exceldata(1, 1);
	      zerodhaloginpage.UserId(userId);
	      zerodhaloginpage.Password(pass);
	      zerodhaloginpage.Login();
	      
	      String pin = Parameterise.Exceldata(2, 1);
	      ZerodhaPinPage zerodhaPinPage = new ZerodhaPinPage(driver);
	      zerodhaPinPage.enterPin(pin,driver);
	      zerodhaPinPage.clicksOnSubmit();
	      Thread.sleep(3000);
	      ZerodhaHomePage zerodhahomepage = new ZerodhaHomePage(driver);
	      zerodhahomepage.homepagebuyfromwatchlist(driver);
	      zerodhahomepage.clickOnChartButton();
	     // Thread.sleep(6000);
	      //driver.switchTo().frame("tradingview_bec27");
	      String text1 = zerodhahomepage.gettextOfchartTemplete(driver);
	      System.out.println(text1);
	      String currenttext = "High";
	      Assert.assertEquals(text1, currenttext);
	 }
	 
	 @AfterMethod
	 public void closebrowser(ITestResult result)
	 {
		 if(result.getStatus()==ITestResult.FAILURE)
		 {
			 test.log(Status.FAIL, result.getName());
		 }
		 else if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 test.log(Status.PASS, result.getName());
		 }
		 else
		 {
			 test.log(Status.SKIP, result.getName());
		 }
	 }
	 
	 @AfterTest
	 public void flushresult()
	 {
		 report.flush();
	 }
}
