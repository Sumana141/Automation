package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		//String username = ExcelUtility.getStringData(10,0,"LoginPage"); //eg to check working of screenshot utility.
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		//Assertion - True
		//boolean isDashboardDisplayed = loginpage.dashboardDisplayed();
		//Assert.assertTrue(isDashboardDisplayed, "User was unable to login with valid credential."); 
		//Above is the assertion. Assert True, here we need to login, but if it fails it will display the error message given in double quotes.
		//Assert True, here we must get the condition true.
		
		//Assert Equal
		String actual = loginpage.dashboardDisplayed();
		String expected = "Dashboard"; //it is the text we need to match with actual.
		//String expected = "Dashboar"; //while we give the text wrongly we will get error message.
		Assert.assertEquals(actual, expected, "User was unable to login with valid credential.");
		//If it pass that means actual matches with expected.
	}
	
	@Test
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(1,0,"LoginPage");
		String password = ExcelUtility.getStringData(1,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		//boolean isDashboardDisplayed = loginpage.dashboardDisplayed();
		//Assert.assertFalse(isDashboardDisplayed, "User was unable to login with valid credential.");
		//Assert False, here we need condition as false.
	}
	
	@Test
	public void verifyUserLoginWithValidUserNameAndInalidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(2,0,"LoginPage");
		String password = ExcelUtility.getStringData(2,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String username = ExcelUtility.getStringData(3,0,"LoginPage");
		String password = ExcelUtility.getStringData(3,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
	}
}
