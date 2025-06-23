package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePagePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base
{
	@Test(description = "Adding new category")
	public void verifyAddNewCategory() throws IOException, AWTException
	{
		HomePagePage homepage;
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		ManageCategoryPage managecategorypage;
		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		//managecategorypage.clickManageCategory();
		
		managecategorypage = homepage.clickManageCategory();
		//String entercategory = ExcelUtility.getStringData(1,0,"ManageCategoryPage");
		managecategorypage.clickNewCategory();
		
		managecategorypage.addCategory().selectGroup().clickChooseFile().topMenuRadiobutton().leftMenuRadiobutton().clickSave();
		//managecategorypage.selectGroup();
		//managecategorypage.clickChooseFile();
		//managecategorypage.topMenuRadiobutton();
		//managecategorypage.leftMenuRadiobutton();
		//managecategorypage.clickSave();
		
		//Assertion
		boolean isCategoryAdded = managecategorypage.categoryAdded();
		Assert.assertTrue(isCategoryAdded, Messages.NEWCATEGORYUPDATEERROR);
	}
	
	@Test(description = "Search for category")
	public void verifySearchCategory() throws IOException
	{
		HomePagePage homepage;
		ManageCategoryPage managecategorypage;
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		//loginpage.enterPasswordOnPasswordField(password);
		homepage = loginpage.clickOnLoginButton();
		
		//ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		//managecategorypage.clickManageCategory();
		managecategorypage = homepage.clickManageCategory();
		String search_cat = ExcelUtility.getStringData(1,1,"ManageCategoryPage");
		managecategorypage.clickSearch().enterCategory(search_cat).clickSearchButton();
		//managecategorypage.enterCategory(search_cat);
		//managecategorypage.clickSearchButton();
		
		//Assertion
		String actual = managecategorypage.categorySearched();
		String expected = "List Categories";
		Assert.assertEquals(actual, expected, Messages.SEARCHCATEGORYERROR);
	}
}
