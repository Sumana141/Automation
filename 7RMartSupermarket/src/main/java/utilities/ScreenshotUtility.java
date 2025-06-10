package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility 
{
	public void getScreenshot(WebDriver driver,String failedTestCase) throws IOException
	{
	TakesScreenshot scrShot = (TakesScreenshot) driver; 
	//TakeScreenshot is an interface. As we cannot direct object for interface, we created a reference and casted diver to the interface.
	//TakeScreenshot interface provides methods required to take screenshot.
	
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
	//getScreenshotAs() is a method in interface TakeScreenshot.
	//in that create a file, to save the image files (screenshot). It will be saved inside a file in a folder.
	
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	//Timestamp format is given here.
	
	File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //here we are asking to create a folder in name "OutoutScreenShot". All screenshot files will be saved in this folder.
	if (!f1.exists()) {
	f1.mkdirs(); //this mkdirs()is used because, in case of any reason "OutputScreenShot" folder is not created or existed, then create one.
	}
	String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
	+ ".png"; //how should be our file or screenshot named: "//outputScreenShot//" + failedTestCase + timeStamp + ".png"
	File finalDestination = new File(destination); //save file to its destination.
	FileHandler.copy(screenShot, finalDestination);
	}
}
