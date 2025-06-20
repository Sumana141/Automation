package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePagePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test(description = "Adding new news")
	public void verifyAddNews() throws IOException
	{
		HomePagePage homepage;
		ManageNewsPage managenewspage;
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		//HomePagePage homepage = new HomePagePage(driver);
		//ManageNewsPage managenewspage = new ManageNewsPage(driver);
		//managenewspage.clickManageNews();
		managenewspage = homepage.clickManageNews();
		String newnews = ExcelUtility.getStringData(1,0,"ManageNewsPage");
		managenewspage.clickAddNews().enterNewNews(newnews).clickSaveButton();
		//managenewspage.enterNewNews(newnews);
		//managenewspage.clickSaveButton();
		boolean isManageNewsDisplayed = managenewspage.displayedAlertManageNews(); //Assertion
		Assert.assertTrue(isManageNewsDisplayed, "User unable to add news."); //Assertion
	}
	
	@Test(description = "Search for news")
	public void verifySearchNews() throws IOException
	{
		HomePagePage homepage;
		ManageNewsPage managenewspage;
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		//HomePagePage homepage = new HomePagePage(driver);
		//ManageNewsPage managenewspage = new ManageNewsPage(driver);
		//managenewspage.clickManageNews();
		managenewspage = homepage.clickManageNews();
		String searchnews = ExcelUtility.getStringData(1,1,"ManageNewsPage");
		managenewspage.clickSearchButton().enterNewstobeSearched(searchnews).verifySearch();
		//managenewspage.enterNewstobeSearched(searchnews);
		//managenewspage.verifySearch();
		boolean isSearchNewsDisplayed = managenewspage.displayedSearchManageNews(); //Assertion
		Assert.assertTrue(isSearchNewsDisplayed, "User unable to search news."); //Assertion
	}
}
