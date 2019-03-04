package WebDriverTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WDAddProject extends WDSuperTestScript
{
	@Test
	public void testWDAddProject()
	{
	    String un=WebDriverExcelOperation.readData("AddProj",1,0);
	    String pwd=WebDriverExcelOperation.readData("AddProj",1,1);
	    String cust=WebDriverExcelOperation.readData("AddProj",1,2);
	    String projName=WebDriverExcelOperation.readData("AddProj",1,3);
	    String expectedResult=WebDriverExcelOperation.readData("AddProj",1,4);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();
		//driver.findElement(By.linkText(cust)).click();
		driver.findElement(By.xpath("//input[@value='Add New Project']")).click();
		WebElement wb=driver.findElement(By.name("customerId"));
		Select s = new Select(wb);
		s.selectByVisibleText(cust);
		driver.findElement(By.name("name")).sendKeys(projName+Keys.ENTER);
		//driver.findElement(By.xpath("//input[@value='Create Project']")).click();			
		///Alert a=driver.switchTo().alert();
		//a.accept();		
		String actualResult=driver.findElement(By.className("successmsg")).getText();
		WebDriverExcelOperation.writeData("AddProj",1,5,actualResult);
		if(expectedResult.equals(actualResult))
		{
			WebDriverExcelOperation.writeData("AddProj",1,6,"Pass");
		}
		else
		{
			WebDriverExcelOperation.writeData("AddProj",1,6,"Fail");
		}

	}

}
