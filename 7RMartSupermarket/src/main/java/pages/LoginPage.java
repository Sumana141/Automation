package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);//to initialise web elements.
	}
	
	@FindBy(xpath="//input[@name='username']")private WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']")private WebElement loginbutton;
	
	//Assertion
	@FindBy(xpath = "//p[text()='Dashboard']") private WebElement dashboard;
	
	public void enterUserNameOnUserNameField(String username)
	{
		usernamefield.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
	
	//Assertion
	//public boolean dashboardDisplayed() //boolean is given, because we need answer as true or false.
	//{
		//return dashboard.isDisplayed(); //given to assert true.
	//}
	
	public String dashboardDisplayed() 
	{
		return dashboard.getText(); //asset equal
	}
}
