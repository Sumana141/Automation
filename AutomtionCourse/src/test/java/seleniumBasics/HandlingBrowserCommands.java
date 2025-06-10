package seleniumBasics;

public class HandlingBrowserCommands extends Base 
{
	public void verifyBrowserCommand()
	{
		System.out.println(driver.getTitle()); //To get the page title
		System.out.println(driver.getCurrentUrl()); //To get the url of the page
		System.out.println(driver.getPageSource()); //To get the source code of the page
		System.out.println(driver.getWindowHandle()); //To get the unique handle id of the respective page
	}
	public static void main(String[] args)
	{
		HandlingBrowserCommands browser = new HandlingBrowserCommands();
		browser.initialiseBrowser();
		browser.verifyBrowserCommand();
		//browser.browserClose();
		
	}

}
