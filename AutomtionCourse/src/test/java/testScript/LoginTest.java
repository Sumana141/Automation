package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumBasics.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase 
{
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		//WebElement usernamefield = driver.findElement(By.id("user-name"));
		//usernamefield.sendKeys("standard_user");
		//WebElement passwordfield = driver.findElement(By.id("password"));
		//passwordfield.sendKeys("secret_sauce");
		//WebElement loginbutton = driver.findElement(By.id("login-button"));
		//loginbutton.click();
		
		String username = ExcelUtility.getStringData(0,0,"LoginPage");
		String password = ExcelUtility.getStringData(0,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() throws IOException
	{
		//WebElement usernamefield = driver.findElement(By.id("user-name"));
		//usernamefield.sendKeys("standard");
		//WebElement passwordfield = driver.findElement(By.id("password"));
		//passwordfield.sendKeys("secret_sauce");
		//WebElement loginbutton = driver.findElement(By.id("login-button"));
		//loginbutton.click();
		
		String username = ExcelUtility.getStringData(1,0,"LoginPage");
		String password = ExcelUtility.getStringData(1,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithValidUserNameAndInalidPassword() throws IOException
	{
		//WebElement usernamefield = driver.findElement(By.id("user-name"));
		//usernamefield.sendKeys("standard_user");
		//WebElement passwordfield = driver.findElement(By.id("password"));
		//passwordfield.sendKeys("secret_");
		//WebElement loginbutton = driver.findElement(By.id("login-button"));
		//loginbutton.click();
		
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
		//WebElement usernamefield = driver.findElement(By.id("user-name"));
		//usernamefield.sendKeys("_user");
		//WebElement passwordfield = driver.findElement(By.id("password"));
		//passwordfield.sendKeys("secret");
		//WebElement loginbutton = driver.findElement(By.id("login-button"));
		//loginbutton.click();
		
		String username = ExcelUtility.getStringData(3,0,"LoginPage");
		String password = ExcelUtility.getStringData(3,1,"LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
	}
}
