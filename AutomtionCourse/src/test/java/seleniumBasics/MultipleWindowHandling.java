package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipleWindowHandling extends Base
{
	public void multipleWindow()
	{
		driver.navigate().to("https://demo.guru99.com/popup.php");
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHere.click();
		//Refer Collections topics in Java
		Set<String> handleids = driver.getWindowHandles();
		System.out.println(handleids);
		//Refer iterator interface in topic Collections in Java
		Iterator<String> it = handleids.iterator(); 
		while(it.hasNext())
		{
			String currentId = it.next(); //next method used to fetch value from iterator, if any.
			if(!currentId.equals(parentWindow)) // ! & . means not equal
			{
				driver.switchTo().window(currentId);
				WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
				email.sendKeys("test@gmail.com");
				WebElement submitButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submitButton.click();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultipleWindowHandling window = new MultipleWindowHandling();
		window.initialiseBrowser();
		window.multipleWindow();
		//window.browserClose();
	}

}
