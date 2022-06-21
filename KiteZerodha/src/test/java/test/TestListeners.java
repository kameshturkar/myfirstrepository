package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.Screenshot;

public class TestListeners extends DeclaireDriver implements ITestListener {
public void onTestStart(ITestResult result)
{
	System.out.println(result.getName()+"Test has Started");
}

public void onTestSuccess(ITestResult result)
{
	System.out.println(result.getName()+"Test has succesfully completed");
}

public void onTestFailure(ITestResult result)
{
	try {
		Screenshot.screenshot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public void onTestSckipped(ITestResult result)
{
	System.out.println(result.getName()+"Test has Sckipped");
}
}
