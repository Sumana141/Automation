package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base
{
	@Test
	public void verifyAddNewCategory() throws IOException, AWTException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickManageCategory();
		managecategorypage.clickNewCategory();
		String entercategory = ExcelUtility.getStringData(1,0,"ManageCategoryPage");
		managecategorypage.addCategory(entercategory);
		managecategorypage.selectGroup();
		managecategorypage.clickChooseFile();
		managecategorypage.topMenuRadiobutton();
		managecategorypage.leftMenuRadiobutton();
		managecategorypage.clickSave();
		
		//Assertion
		boolean isCategoryAdded = managecategorypage.categoryAdded();
		Assert.assertTrue(isCategoryAdded, "Admin was unable to add the category");
	}
	
	@Test
	public void verifySearchCategory() throws IOException
	{
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,0,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickManageCategory();
		managecategorypage.clickSearch();
		String search_cat = ExcelUtility.getStringData(1,1,"ManageCategoryPage");
		managecategorypage.enterCategory(search_cat);
		managecategorypage.clickSearchButton();
		
		//Assertion
		String actual = managecategorypage.categorySearched();
		String expected = "List Categories";
		Assert.assertEquals(actual, expected, "User unable to search category.");
	}
}
