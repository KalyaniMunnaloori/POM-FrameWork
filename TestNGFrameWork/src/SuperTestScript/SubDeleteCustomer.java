package SuperTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class SubDeleteCustomer extends SuperTestscript
{
 @Test
 public void testSubDeleteCust()
 {
	 String url=SuperTestScriptExcelOperation.readData("DeleteCust",1,0);
     String un=SuperTestScriptExcelOperation.readData("DeleteCust",1,1);
     String pwd=SuperTestScriptExcelOperation.readData("DeleteCust",1,2);
     String cust=SuperTestScriptExcelOperation.readData("DeleteCust",1,3);
     String expectedResult=SuperTestScriptExcelOperation.readData("DeleteCust",1,4);
	f1.findElement(By.name("username")).sendKeys(un);
	f1.findElement(By.name("pwd")).sendKeys(pwd);
	f1.findElement(By.xpath("//input[@type='submit']")).click();
	f1.findElement(By.linkText("Projects & Customers")).click();
	WebElement wb=f1.findElement(By.name("selectedCustomer"));
	Select s = new Select(wb);
	s.selectByVisibleText(cust);		
	f1.findElement(By.xpath("//input[@value='  Show  ']")).click();
	f1.findElement(By.linkText(cust)).click();
	f1.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
	Alert a=f1.switchTo().alert();
	a.accept();				
	String actualResult=f1.findElement(By.className("successmsg")).getText();
	System.out.println(actualResult);
	SuperTestScriptExcelOperation.writeData("DeleteCust",1,5,actualResult);
	if(expectedResult.equals(actualResult))
	{
		SuperTestScriptExcelOperation.writeData("DeleteCust",1,6,"Pass");
	}
	else
	{
		SuperTestScriptExcelOperation.writeData("DeleteCust",1,6,"Fail");
	}


 }
}
