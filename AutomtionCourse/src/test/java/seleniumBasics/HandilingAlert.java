package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandilingAlert extends Base
{
	public void verifySimpleAlert()
	{
		driver.navigate().to("https://demoqa.com/alerts");
		//simple Alert (first click button)
		WebElement simpleAlert = driver.findElement(By.id("alertButton"));
		simpleAlert.click();
		Alert alerts = driver.switchTo().alert();
		alerts.accept();//to press ok in alert box.
	}
	
	public void verifyConfirmAlert()
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
		confirmAlert.click();
		Alert alerts = driver.switchTo().alert();
		alerts.accept();
		//alerts.dismiss(); //to press Cancel button in alert box
	}
	
	public void verifyPromptAlert()
	{
		driver.navigate().to("https://demoqa.com/alerts");
		WebElement promptAlert = driver.findElement(By.id("promtButton"));
		promptAlert.click();
		Alert alerts = driver.switchTo().alert();
		alerts.sendKeys("Sumana");
		alerts.accept();
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandilingAlert alert = new HandilingAlert();
		alert.initialiseBrowser();
		//alert.verifySimpleAlert();
		//alert.verifyConfirmAlert();
		alert.verifyPromptAlert();
		//alert.browserClose();
	}

}
