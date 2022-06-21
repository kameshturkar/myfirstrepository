package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
public static void screenshot(WebDriver driver,String b) throws IOException
{
	String date = Screenshot.Datetime();
	System.out.println(date);
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination = new File("C:\\Users\\hp\\Documents\\Screenshotoftesting"+ b +date+".jpg");
	FileHandler.copy(source, destination);
}
 
public static String Datetime()
{
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss"); // formate the time date and time
//	LocalDateTime currenttime = LocalDateTime.now(); // return current time
//	String date = dtf.format(currenttime); // format the time given by now() method in required format and return in String
//	return date;
	String date = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss").format(LocalDateTime.now());
	return date;
	
}

}
