package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility 
{
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() 
	{
	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //folder name and file name given.
	reporter.config().setReportName("7RMartSupermarket"); //To set report name.
	extentReports.attachReporter(reporter);
	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", "Sumana"); 
	return extentReports;
	}
}
