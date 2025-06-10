package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFrames extends Base
{
	public void verifyFrames()
	{
		driver.navigate().to("https://demoqa.com/frames");
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		System.out.println(totalFrames.size());
		
		WebElement mainFrame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(mainFrame); //to change driver control to our particular frame.
		WebElement tableHeading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(tableHeading.getText());
		driver.switchTo().defaultContent(); //driver control will return back to initial position where it was.
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingFrames frames = new HandlingFrames();
		frames.initialiseBrowser();
		frames.verifyFrames();
		//frames.browserClose();
	}

}
