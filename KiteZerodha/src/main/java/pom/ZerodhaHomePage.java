package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import utility.Waitapply;

public class ZerodhaHomePage {
    
	@FindBy(xpath="//input[@icon='search']") private WebElement search ;
	@FindBy(xpath="//span[text()='TATAPOWER']") private WebElement   sharename;
	@FindBy(xpath="//span[@data-balloon='Buy (B)']") private WebElement firstbuy;
	@FindBy(xpath="(//button[@class='button-blue'])[1]") private WebElement buy;
	@FindBy(xpath="(//input[@type='number'])[1]") private WebElement quantity;
	@FindBy(xpath="(//label[@class='su-radio-label'])[9]") private WebElement market;
	@FindBy(xpath="//button[@type='submit']") private WebElement finalbuy;
	@FindBy(xpath="//button[@class= 'button-outline cancel']") private WebElement cancel;
	@FindBy(xpath="//span[@class='nice-name']") private List<WebElement> watchList;
	@FindBy(xpath="//span[@class='icon icon-trending-up']") private WebElement chartbutton ;
	@FindBy(xpath="//div[text()='High']") private WebElement chartTemplate;
	@FindBy(xpath="//iframe[@name='tradingview_bec27']") private WebElement frame;
	
	
	public ZerodhaHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonSearch(String sharename)
	{
		search.sendKeys(sharename);
	}
	
	public void clickonfirstBuy(WebDriver driver)
	{
		Waitapply.waitApply(firstbuy, driver);
		firstbuy.click();
	}
	
	public void clickonsharebuy(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(sharename);
		action.perform();
		action.moveToElement(buy);
		action.perform();
		buy.click();
	}
	
	public void addQuantityofshare(String numbershare)
	{
		quantity.clear();
		quantity.sendKeys(numbershare);
	}
	
	public void clickonRadiobuttonmarket()
	{
		market.click();
	}
	
	public void clickonFinalbuy()
	{
		finalbuy.click();
		//cancel.click();
	}
	
	 public void homepagebuyfromwatchlist(WebDriver driver) throws InterruptedException
	 {
		
		 int num = watchList.size();
		 for(int i = 0; i<=num-1; i++)
		 {
			 WebElement search = watchList.get(i);
			 String text = search.getText();
			 System.out.println(text);
			 if(text.equalsIgnoreCase("TATAPOWER"))
			 {
				 System.out.println(text);
				 Actions action = new Actions(driver);
				 action.moveToElement(search);
				 action.perform();
				// Waitapply.waitApply(firstbuy, driver);
//				 FluentWait<WebDriver> waitt = new FluentWait<WebDriver>(driver);
//				 waitt.withTimeout(Duration.ofMillis(3000));
//				 waitt.pollingEvery(Duration.ofMillis(100));
//				 waitt.ignoring(Exception.class);
//				 waitt.until(ExpectedConditions.visibilityOf(firstbuy));
				 
				//firstbuy.click();
				 
				 
			 }
		 }
		 
	 }
	 
	 public void clickOnChartButton()
	 {
		 chartbutton.click();
	 }
	 
	 public String gettextOfchartTemplete(WebDriver driver)
	 {
		 //driver.switchTo().frame(frame);
		 Waitapply.waitApply(chartTemplate, driver);
		 chartTemplate.click();
		 String text = chartTemplate.getText();
		 return text;
	 }
}
