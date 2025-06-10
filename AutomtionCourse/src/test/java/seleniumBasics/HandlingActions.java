package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandlingActions extends Base
{
	public void verifyRightClick()
	{
		//Right Click
		WebElement rightClick = driver.findElement(By.xpath("//a[text()='Home']"));
		Actions actions = new Actions(driver);
		actions.contextClick(rightClick).build().perform(); //for right clicking
		//for right click we use method contextClick() 
		//.build().perform() - for any action to get worked.
	}
	
	public void verifyMouseHover()
	{
		WebElement mouseHover = driver.findElement(By.id("others"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHover).build().perform(); //moveToElement is the method for mouse hover.
	}
	
	public void verifyDragAndDrop()
	{
		driver.navigate().to("https://demoqa.com/droppable");
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop).build().perform();
	}
	
	public void keyBoardAction() throws AWTException
	{
		Robot robot = new Robot(); //here we need to throw.
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingActions action = new HandlingActions();
		action.initialiseBrowser();
		//action.verifyRightClick();
		//action.verifyMouseHover();
		//action.verifyDragAndDrop();
		try {
			action.keyBoardAction();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//action.browserClose();
	}

}
