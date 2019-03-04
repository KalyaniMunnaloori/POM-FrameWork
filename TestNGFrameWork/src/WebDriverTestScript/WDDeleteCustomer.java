package WebDriverTestScript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WDDeleteCustomer extends WDSuperTestScript
{
	@Test
	 public void testSubDeleteCust()
	 {
	     String un=WebDriverExcelOperation.readData("DeleteCust",1,0);
	     String pwd=WebDriverExcelOperation.readData("DeleteCust",1,1);
	     String cust=WebDriverExcelOperation.readData("DeleteCust",1,2);
	     String expectedResult=WebDriverExcelOperation.readData("DeleteCust",1,3);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();
		WebElement wb=driver.findElement(By.name("selectedCustomer"));
		Select s = new Select(wb);
		s.selectByVisibleText(cust);		
		driver.findElement(By.xpath("//input[@value='  Show  ']")).click();
		driver.findElement(By.linkText(cust)).click();
		driver.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
		Alert a=driver.switchTo().alert();
		a.accept();				
		String actualResult=driver.findElement(By.className("successmsg")).getText();
		System.out.println(actualResult);
		WebDriverExcelOperation.writeData("DeleteCust",1,4,actualResult);
		if(expectedResult.equals(actualResult))
		{
			WebDriverExcelOperation.writeData("DeleteCust",1,5,"Pass");
		}
		else
		{
			WebDriverExcelOperation.writeData("DeleteCust",1,5,"Fail");
		}


	 }

}
