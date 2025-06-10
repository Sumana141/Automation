package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public WebDriver driver; //it is the global variable we declared. (WebDriver is a predefined interface)
	
	public void initialiseBrowser()
	{
		driver = new ChromeDriver(); //ChromeDriver is the driver class for Chrome. 
		//driver = new FirefoxDriver();
		//driver = new EdgeDriver();
		driver.get("https://selenium.qabible.in/"); //launch an url.
		driver.manage().window().maximize(); //to maximise the window.
	}
	
	public void browserClose()
	{
		driver.quit();
	}
	
	public static void main(String[] args)
	{
		Base base = new Base(); //object creation, give object name as base itself.
		base.initialiseBrowser();
		base.browserClose();
		
	}

}
