package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePagePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(priority=1, description = "Login with Valid Credentials", groups = {"smoke"})
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
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);
		//If it pass that means actual matches with expected.
	}
	
	@Test(priority=2, description = "Verifying login with invalid user name and valid password", groups = {"smoke"})
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
	
	@Test(priority=3, description = "Verifying login with valid username and invalid password")
	public void verifyUserLoginWithValidUserNameAndInalidPassword() throws IOException
	{
		String username = ExcelUtility.getStringData(2,0,"LoginPage");
		String password = ExcelUtility.getStringData(2,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
	}
	
	@Test(priority=4, description = "Verifying login with invalid username & password", dataProvider="logindata")
	public void verifyUserLoginWithInvalidCredentials(String username, String password) throws IOException
	{
		HomePagePage homepage;
		//String username = ExcelUtility.getStringData(3,0,"LoginPage");
		//String password = ExcelUtility.getStringData(3,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
	}
	
	@DataProvider(name="logindata")
	public Object[][] getDataFromDataProvider()
	{
		return new Object[][] 
				{
			new Object[] {"Test1","Test2"}, new Object[] {"Test3","Test 4"}};
	}
}
