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
	
	@FindBy(id="user-name")private WebElement usernamefield;
	@FindBy(id="password")private WebElement passwordfield;
	@FindBy(id="login-button")private WebElement loginbutton;
	
	
	
	
	public void enterUserNameOnUserNameField(String username)
	{
		//usernamefield.sendKeys("standard_user");
		usernamefield.sendKeys(username);
	}
	
	public void enterPasswordOnPasswordField(String password)
	{
		//passwordfield.sendKeys("secret_sauce");
		passwordfield.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
}
