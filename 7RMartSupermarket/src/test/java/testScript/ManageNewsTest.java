package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test
	public void verifyAddNews() throws IOException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNews();
		managenewspage.clickAddNews();
		String newnews = ExcelUtility.getStringData(1,0,"ManageNewsPage");
		managenewspage.enterNewNews(newnews);
		managenewspage.clickSaveButton();
		boolean isManageNewsDisplayed = managenewspage.displayedAlertManageNews(); //Assertion
		Assert.assertTrue(isManageNewsDisplayed, "User unable to add news."); //Assertion
	}
	
	@Test
	public void verifySearchNews() throws IOException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickManageNews();
		managenewspage.clickSearchButton();
		String searchnews = ExcelUtility.getStringData(1,1,"ManageNewsPage");
		managenewspage.enterNewstobeSearched(searchnews);
		managenewspage.verifySearch();
		boolean isSearchNewsDisplayed = managenewspage.displayedSearchManageNews(); //Assertion
		Assert.assertTrue(isSearchNewsDisplayed, "User unable to search news."); //Assertion
	}
}
