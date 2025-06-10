package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class Base 
{

public WebDriver driver; //it is the global variable we declared. (WebDriver is a predefined interface)
	
	@BeforeMethod
	public void initialiseBrowser()
	{
		driver = new ChromeDriver(); //ChromeDriver is the driver class for Chrome. 
		driver.get("https://groceryapp.uniqassosiates.com/admin/login"); //launch an url.
		driver.manage().window().maximize(); //to maximise the window.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait.
	}
	
	@AfterMethod
	/*public void browserClose()
	{
		driver.quit();
	}*/
	
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
	if(iTestResult.getStatus()==ITestResult.FAILURE) //iTestResult is an interface, it manages the life cycle of test result (whether is pass, fail or skip, etc).
	{
	ScreenshotUtility screenShot=new ScreenshotUtility();
	screenShot.getScreenshot(driver, iTestResult.getName()); //here we called the getScreeshot() from Screenshot utility class.
	}
	driver.quit();

	}

}
