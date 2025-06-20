package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePagePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base
{
	@Test(description = "Logout from application")
	public void verifyUserLogout() throws IOException
	{
		HomePagePage homepage;
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		//HomePagePage homepage = new HomePagePage(driver);
		homepage.clickAdminButton();
		loginpage = homepage.selectLogout();
	}
}
