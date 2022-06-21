package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Waitapply {
public static void waitApply(WebElement element,WebDriver driver)
{
	FluentWait<WebDriver> waitt = new FluentWait<WebDriver>(driver);
	 waitt.withTimeout(Duration.ofMillis(3000));
	 waitt.pollingEvery(Duration.ofMillis(100));
	 waitt.ignoring(Exception.class);
	 waitt.until(ExpectedConditions.visibilityOf(element));
}
}
