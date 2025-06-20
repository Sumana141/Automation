package pages;

import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage 
{
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") private WebElement adminUsers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newAdmin;
	@FindBy(id = "username") private WebElement adminusername;
	@FindBy(id = "password") private WebElement adminpassword;
	@FindBy(id = "user_type") private WebElement usertypedropdown;
	@FindBy(xpath = "//button[@name='Create']") private WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement addAdminAssert; //assertion
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement searchButton;
	@FindBy(id = "un") private WebElement username;
	@FindBy(id = "ut") private WebElement dropdown;
	@FindBy(xpath = "//button[@value='sr']") private WebElement search;
	@FindBy(xpath = "//h4[text()='Admin Users']") private WebElement searchAdminAssert; //assertion
	
	/*public void clickAdminUsers()
	{
		adminUsers.click();
	}*/
	
	public AdminUsersPage verifyNewAdmin()
	{
		newAdmin.click();
		return this;
	}
	
	public AdminUsersPage addUserName(String usernameadmin)
	{
		adminusername.sendKeys(usernameadmin);
		return this;
	}

	
	public AdminUsersPage addAdminPassword(String passwordadmin)
	{
		adminpassword.sendKeys(passwordadmin);
		return this;
	}
	
	public AdminUsersPage selectUserType()
	{
		//Select select = new Select(usertypedropdown);
		//select.selectByIndex(2);
		
		PageUtility page=new PageUtility();
		page.selectDropdownWithindex(usertypedropdown, Constant.USERTYPE);
		return this;
	}
	
	public AdminUsersPage clickSaveButton()
	{
		WaitUtility wait=new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, save);
		save.click();
		return this;
	}
	
	public boolean addedAdminUser() //assertion
	{
		return addAdminAssert.isDisplayed();
	}
	
	public AdminUsersPage searchAdminUser(String search)
	{
		searchButton.click();
		username.sendKeys(search);
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		return this;
	}
	
	public AdminUsersPage search()
	{
		search.click();
		return this;
	}
	
	public String searchAdminUsersDisplayed() //assertion
	{
		return searchAdminAssert.getText();
	}
}
