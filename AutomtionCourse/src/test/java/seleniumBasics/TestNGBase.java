package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase 
{
public WebDriver driver; //it is the global variable we declared. (WebDriver is a predefined interface)
	
	@BeforeMethod
	public void initialiseBrowser()
	{
		driver = new ChromeDriver(); //ChromeDriver is the driver class for Chrome. 
		//driver = new FirefoxDriver();
		//driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/v1/"); //launch an url. (here for demo pjt).
		driver.manage().window().maximize(); //to maximise the window.
	}
	
	@AfterMethod
	public void browserClose()
	{
		//driver.quit();
	}
}
