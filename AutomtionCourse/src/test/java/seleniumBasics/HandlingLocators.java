package seleniumBasics;

import org.openqa.selenium.By;

public class HandlingLocators extends Base 
{
	public void verifyLocators() 
	{
		driver.findElement(By.id("button-one"));
		driver.findElement(By.className("form-group"));
		driver.findElement(By.tagName("button"));
		driver.findElement(By.name("viewport"));
		driver.findElement(By.linkText("Simple Form Demo"));
		driver.findElement(By.partialLinkText("Simple Form"));
		driver.findElement(By.cssSelector("input[id='single-input-field']"));
		driver.findElement(By.xpath("//button[@id='button-one']"));
		driver.findElement(By.xpath("//button[text()='Show Message']"));
		driver.findElement(By.xpath("//button[starts-with(text(),'Show ')]"));
		driver.findElement(By.xpath("//button[@id='button-one' and @type='button']"));
		driver.findElement(By.xpath("//button[@id='button-one' or @id='button-one-electronics']"));
		//xpath access method
		//1. Parent
		driver.findElement(By.xpath("//div[contains (text(), 'Single Input Field')]//parent::div[@class='card']"));
		//2. Child
		driver.findElement(By.xpath("//div[@class='card']//child::button[@id='button-one']"));
		//3. Following
		driver.findElement(By.xpath("//button[@id='button-one']//following::div[@class='card']"));
		//4. Preceeding
		driver.findElement(By.xpath("//button[@id='button-one']//preceding:: div[@class='card']"));
		//5. Ancester
		driver.findElement(By.xpath("//button[@id='button-one']//ancestor::div"));
		//6. Descendant
		driver.findElement(By.xpath("//div[@class='card']//descendant::div"));
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingLocators locators = new HandlingLocators();
		locators.initialiseBrowser();
		locators.verifyLocators();
		//locators.browserClose();
	}

}
