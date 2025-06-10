package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base
{
	@Test
	public void verifyAdminUsers() throws IOException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickAdminUsers();
		adminuserspage.verifyNewAdmin();
		String usernameadmin = ExcelUtility.getStringData(0,0,"AdminUsersPage");
		adminuserspage.addUserName(usernameadmin);
		String passwordadmin = ExcelUtility.getStringData(0,1,"AdminUsersPage");
		adminuserspage.addAdminPassword(passwordadmin);
		adminuserspage.selectUserType();
		adminuserspage.clickSaveButton();
		boolean isAlertSuccessDisplayed = adminuserspage.addedAdminUser(); //Assertion
		Assert.assertTrue(isAlertSuccessDisplayed, "User unable to add admin user."); //Assertion
	}
	
	@Test
	public void verifySearchAdminUsers() throws IOException //Incomplete
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickAdminUsers();
		String search = ExcelUtility.getStringData(0,2,"AdminUsersPage");
		adminuserspage.searchAdminUser(search);
		adminuserspage.search();
		
		//Assertion
		String actual = adminuserspage.searchAdminUsersDisplayed();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected, "User unable to sear admin user");
	}
}
