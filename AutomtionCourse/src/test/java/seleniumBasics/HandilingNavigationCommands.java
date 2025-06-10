package seleniumBasics;

public class HandilingNavigationCommands extends Base 
{
	public void verifyNavigationCommands()
	{
		driver.navigate().to("https://www.amazon.in/"); //To navigate from one page to other.
		driver.navigate().back(); //To move back or previous page.
		driver.navigate().forward(); //To move to forward.
		driver.navigate().refresh(); //To refresh the page.
	}
	public static void main(String[] args) 
	{
		HandilingNavigationCommands navigate = new HandilingNavigationCommands();
		navigate.initialiseBrowser();
		navigate.verifyNavigationCommands();
		//navigate.browserClose();
		// TODO Auto-generated method stub

	}

}
