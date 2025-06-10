package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePagePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base
{
	@Test
	public void verifyUserLogout() throws IOException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		HomePagePage homepage = new HomePagePage(driver);
		homepage.clickAdminButton();
		homepage.selectLogout();
	}
}
