package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") private WebElement manageNews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") private WebElement addNews;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement manageNewsAssert; //Assertion
	@FindBy(xpath="//textarea[@placeholder='Enter the news']") private WebElement enterNews;
	@FindBy(xpath = "//button[@class='btn btn-danger']") private WebElement clickSave;
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement clickSearch;
	@FindBy(xpath = "//input[@name='un']") private WebElement enterNewstoSearch;
	@FindBy(xpath = "//button[@name='Search']") private WebElement clickSearchButton;
	@FindBy(xpath = "//h4[text()='Search Manage News']") private WebElement searchNewsAssert; //Assertion
	
	public void clickManageNews()
	{
		manageNews.click();
	}
	
	public void clickAddNews()
	{
		addNews.click();
	}
	
	public void enterNewNews(String newnews)
	{
		enterNews.sendKeys(newnews);
	}
	
	public void clickSaveButton()
	{
		clickSave.click();
	}

	public boolean displayedAlertManageNews() //Assertion
	{
		return manageNewsAssert.isDisplayed();
	}
		
	public void clickSearchButton()
	{
		clickSearch.click();
	}
	
	public void enterNewstobeSearched(String searchnews)
	{
		enterNewstoSearch.sendKeys(searchnews);
	}
	
	public void verifySearch()
	{
		clickSearchButton.click();
	}
	
	public boolean displayedSearchManageNews() //Assertion
	{
		return searchNewsAssert.isDisplayed();
	}
}