package POJO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver browser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\AotomationChrome\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();//class of Selenium
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://kite.zerodha.com/?next=%2Fdashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		return driver ;
	}

}
