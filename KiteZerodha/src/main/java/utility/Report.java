package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
public static ExtentReports createReport()
{
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("extentReport.html");
	ExtentReports report = new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Regression", "Zerodha");
	report.setSystemInfo("Browser", "Chrome");
	return report;
			
}
}
