package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.WaitUtility;

public class ManageCategoryPage 
{
	public WebDriver driver;
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement manageCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") private WebElement newCategory;
	@FindBy(id = "category") private WebElement category;
	@FindBy(xpath = "//span[text()='discount']") private WebElement group;
	@FindBy(id = "main_img") private WebElement chooseFile;
	//@FindBy(xpath = "//input[@name='main_img']") private WebElement chooseFile;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']") private WebElement topMenu;
	@FindBy(xpath = "//input[@value='no' and @name='show_home']") private WebElement leftMenu;
	@FindBy(xpath = "//button[@type='submit']") private WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") private WebElement assertCategoryAdd;
	
	@FindBy(xpath = "//a[@onclick='click_button(2)']") private WebElement search;
	@FindBy(xpath = "//input[@placeholder='Category']") private WebElement searchCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix' or @class='alert alert-danger alert-dismissible']") private WebElement searchButton;
	@FindBy(xpath = "//h4[@text()='List Categories']") private WebElement assertSearchCategory; //assertion
	
	/*public void clickManageCategory()
	{
		manageCategory.click();
	}*/
	
	public ManageCategoryPage clickNewCategory()
	{
		newCategory.click();
		return this;
	}
	
	public ManageCategoryPage addCategory()
	{
		//category.sendKeys(entercategory);
		category.sendKeys(Constant.NEWCATEGORYNAME);
		return this;
	}
	
	public ManageCategoryPage selectGroup()
	{
		group.click();
		return this;
	}
	
	public ManageCategoryPage clickChooseFile() throws AWTException
	{
		chooseFile.sendKeys(Constant.IMAGEFILE1);
		return this;
	}
	
	public ManageCategoryPage topMenuRadiobutton()
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(topMenu)).click();
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, topMenu);		
		return this;
	}
	
	public ManageCategoryPage leftMenuRadiobutton()
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(leftMenu)).click();
		
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, leftMenu);
		return this;
	}
	
	public ManageCategoryPage clickSave()
	{
		save.click();
		return this;
	}
	
	public boolean categoryAdded() //Assertion
	{
		return assertCategoryAdd.isDisplayed();
	}
	
	public ManageCategoryPage clickSearch()
	{
		search.click();
		return this;
	}
	
	public ManageCategoryPage enterCategory(String search_cat)
	{
		searchCategory.sendKeys(search_cat);
		return this;
	}
	
	public ManageCategoryPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public String categorySearched()//assertion
	{
		return assertSearchCategory.getText();
	}
}
