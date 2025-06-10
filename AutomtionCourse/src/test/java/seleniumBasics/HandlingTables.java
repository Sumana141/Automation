package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingTables extends Base
{
	public void verifyTableHandling()
	{
		driver.navigate().to("https://money.rediff.com/indices/nse");
		WebElement fullTable = driver.findElement(By.xpath("//table[@id='dataTable']"));
		System.out.println(fullTable.getText()); //will fetch entire data of the table.
		WebElement tableRow = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[2]"));
		System.out.println(tableRow.getText());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingTables tables = new HandlingTables();
		tables.initialiseBrowser();
		tables.verifyTableHandling();
		//tables.browserClose();
	}

}
