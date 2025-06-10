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
		
	public void clickAdminButton()
	{
		adminbutton.click();
	}
	
	public void selectLogout()
	{
		logoutoption.click();
	}
}
