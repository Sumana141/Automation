package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown extends Base
{
	public void verifyDropdown()
	{
		driver.navigate().to("https:www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement dropDown = driver.findElement(By.id("dropdowm-menu-1"));
		//All methods for this dropdown are found inside a class called Select.
		Select select = new Select(dropDown);
		//select.selectByIndex(2); // in bracket give the index position of your required option.
		//select.selectByVisibleText("Python"); //here we need to choose the text between tags.
		select.selectByValue("sql"); // here we should select the attribute value of the attribute 'value'.
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingDropdown dropDown = new HandlingDropdown();
		dropDown.initialiseBrowser();
		dropDown.verifyDropdown();
		//dropDown.browserClose();
	}

}
