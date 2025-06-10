package seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebElementCommands extends Base
{
	public void verifyWebElementCommands()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement messageBox = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		//to input a value - use webelement sendKeys
		messageBox.sendKeys("Sumana");
		
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //duration given for explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(showMessageButton)); //specified the condition of explicit wait.
		//fluent wait code
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.elementToBeClickable(showMessageButton));
		//to click the button use webelement click
		showMessageButton.click();
		
		System.out.println(showMessageButton.isDisplayed());
		System.out.println(showMessageButton.isEnabled());
		
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		//to get message or output printed in console use getText
		System.out.println(yourMessage.getText());
		
		//to clear the message, use web element clear.
		messageBox.clear();
		
		WebElement valueA = driver.findElement(By.id("value-a"));
		System.out.println(valueA.getTagName()); //to get the tag name.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingWebElementCommands webElements = new HandlingWebElementCommands();
		webElements.initialiseBrowser();
		webElements.verifyWebElementCommands();
		//webElements.browserClose();
	}

}
