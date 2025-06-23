package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePagePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base
{
	@Test(description = "Adding new users to the users list", retryAnalyzer=retry.Retry.class)
	public void verifyAdminUsers() throws IOException
	{
		HomePagePage homepage;
		AdminUsersPage adminuserspage;
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		//String username = ExcelUtility.getStringData(10,0,"LoginPage"); //for retry
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		//HomePagePage homepage = new HomePagePage(driver);
		//AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		//adminuserspage.clickAdminUsers();
		adminuserspage = homepage.clickAdminUsers();
		RandomDataUtility random = new RandomDataUtility();
		String usernameadmin = random.createRandomUserName(); //test data using faker
		String passwordadmin = random.createRandomPassword();
		adminuserspage.verifyNewAdmin().addUserName(usernameadmin).addAdminPassword(passwordadmin).selectUserType().clickSaveButton();
		
		//String usernameadmin = ExcelUtility.getStringData(0,0,"AdminUsersPage");
		//adminuserspage.addUserName(usernameadmin);
		//String passwordadmin = ExcelUtility.getStringData(0,1,"AdminUsersPage");
		//adminuserspage.addAdminPassword(passwordadmin);
		//adminuserspage.selectUserType();
		//adminuserspage.clickSaveButton();
		boolean isAlertSuccessDisplayed = adminuserspage.addedAdminUser(); //Assertion
		Assert.assertTrue(isAlertSuccessDisplayed, "User unable to add admin user."); //Assertion
	}
	
	@Test(description = "Search for Admin Users")
	public void verifySearchAdminUsers() throws IOException //Incomplete
	{
		HomePagePage homepage;
		AdminUsersPage adminuserspage;
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		//HomePagePage homepage = new HomePagePage(driver);
		//AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		//adminuserspage.clickAdminUsers();
		adminuserspage = homepage.clickAdminUsers();
		String search = ExcelUtility.getStringData(0,2,"AdminUsersPage");
		adminuserspage.searchAdminUser(search).search();
		//adminuserspage.search();
		
		//Assertion
		String actual = adminuserspage.searchAdminUsersDisplayed();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected, "User unable to sear admin user");
	}
}
