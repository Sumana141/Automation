package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage 
{
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") private WebElement adminUsers;
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
	
	public void clickAdminUsers()
	{
		adminUsers.click();
	}
	
	public void verifyNewAdmin()
	{
		newAdmin.click();
	}
	
	public void addUserName(String usernameadmin)
	{
		adminusername.sendKeys(usernameadmin);
	}

	
	public void addAdminPassword(String passwordadmin)
	{
		adminpassword.sendKeys(passwordadmin);
	}
	
	public void selectUserType()
	{
		Select select = new Select(usertypedropdown);
		select.selectByIndex(2);
	}
	
	public void clickSaveButton()
	{
		save.click();
	}
	
	public boolean addedAdminUser() //assertion
	{
		return addAdminAssert.isDisplayed();
	}
	
	public void searchAdminUser(String search)
	{
		searchButton.click();
		username.sendKeys(search);
		Select select = new Select(dropdown);
		select.selectByIndex(2);
	}
	
	public void search()
	{
		search.click();
	}
	
	public String searchAdminUsersDisplayed() //assertion
	{
		return searchAdminAssert.getText();
	}
}
