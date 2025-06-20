package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePagePage 
{
	public WebDriver driver;
	public HomePagePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//to initialise web elements.
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement adminbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")private WebElement logoutoption;
	
	//Chaining
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") private WebElement adminUsers;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement manageCategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") private WebElement manageNews;
		
	public HomePagePage clickAdminButton()
	{
		adminbutton.click();
		return this;
	}
	
	public LoginPage selectLogout()
	{
		logoutoption.click();
		return new LoginPage(driver);
	}
	
	
	//Chaining of AdminUsersPage
	public AdminUsersPage clickAdminUsers()
	{
		adminUsers.click();
		return new AdminUsersPage(driver);
	}
	
	//chaining of ManageCategoryPage
	public ManageCategoryPage clickManageCategory()
	{
		manageCategory.click();
		return new ManageCategoryPage(driver);
	}
	
	//chaining of ManageNewsPage
	public ManageNewsPage clickManageNews()
	{
		manageNews.click();
		return new ManageNewsPage(driver);
	}
}
