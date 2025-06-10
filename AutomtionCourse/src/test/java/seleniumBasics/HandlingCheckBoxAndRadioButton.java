package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingCheckBoxAndRadioButton extends Base
{
	public void verifyCheckBox()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement checkBox = driver.findElement(By.xpath("//input[@value='option-1']"));
		//System.out.println(checkBox.isSelected()); - since it is given before the .click output will be false because checkbox is not clicked.
		checkBox.click();
		System.out.println(checkBox.isSelected()); //here it is given after .click(), so we will get output as true which means it is clicked.
	}
	public void verifyRadioButton()
	{
		//driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		WebElement radioButton = driver.findElement(By.xpath("//input[@value='orange']"));
		radioButton.click();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingCheckBoxAndRadioButton checkBoxAndRadioButton =new HandlingCheckBoxAndRadioButton();
		checkBoxAndRadioButton.initialiseBrowser();
		checkBoxAndRadioButton.verifyCheckBox();
		//checkBoxAndRadioButton.verifyRadioButton();
		//checkBoxAndRadioButton.browserClose();
	}

}
