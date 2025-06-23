package automationCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base 
{
	Properties prop; //prop is reference for class Properties
	FileInputStream file;
	
	public WebDriver driver; //it is the global variable we declared. (WebDriver is a predefined interface)
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initialiseBrowser(String browsers) throws Exception
	{
		prop = new Properties(); //object creation for Properties
		file = new FileInputStream(Constant.CONFIGFILE);
		prop.load(file); //to load the file
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browsers.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
		//driver = new ChromeDriver(); //ChromeDriver is the driver class for Chrome. 
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login"); //launch an url.
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize(); //to maximise the window.
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait.
		WaitUtility wait=new WaitUtility();
		wait.implicitWait(driver);
	}
	
	
	/*public void browserClose()
	{
		driver.quit();
	}*/
	
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE) //iTestResult is an interface, it manages the life cycle of test result (whether is pass, fail or skip, etc).
	{
	ScreenshotUtility screenShot=new ScreenshotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName()); //here we called the getScreeshot() from Screenshot utility class.
	}
	//driver.quit();

	}

}
