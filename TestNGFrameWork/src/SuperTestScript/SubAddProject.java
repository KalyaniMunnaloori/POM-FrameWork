package SuperTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SubAddProject extends SuperTestscript
{
@Test
public void testSubAddProject()
{
	String url=SuperTestScriptExcelOperation.readData("AddProj",1,0);
    String un=SuperTestScriptExcelOperation.readData("AddProj",1,1);
    String pwd=SuperTestScriptExcelOperation.readData("AddProj",1,2);
    String cust=SuperTestScriptExcelOperation.readData("AddProj",1,3);
    String projName=SuperTestScriptExcelOperation.readData("AddProj",1,4);
    String expectedResult=SuperTestScriptExcelOperation.readData("AddProj",1,5);
	f1.findElement(By.name("username")).sendKeys(un);
	f1.findElement(By.name("pwd")).sendKeys(pwd);
	f1.findElement(By.xpath("//input[@type='submit']")).click();
	f1.findElement(By.linkText("Projects & Customers")).click();
	//f1.findElement(By.linkText(cust)).click();
	f1.findElement(By.xpath("//input[@value='Add New Project']")).click();
	WebElement wb=f1.findElement(By.name("customerId"));
	Select s = new Select(wb);
	s.selectByVisibleText(cust);
	f1.findElement(By.name("name")).sendKeys(projName+Keys.ENTER);
	//f1.findElement(By.xpath("//input[@value='Create Project']")).click();			
	///Alert a=f1.switchTo().alert();
	//a.accept();		
	String actualResult=f1.findElement(By.className("successmsg")).getText();
	SuperTestScriptExcelOperation.writeData("AddProj",1,6,actualResult);
	if(expectedResult.equals(actualResult))
	{
		SuperTestScriptExcelOperation.writeData("AddProj",1,7,"Pass");
	}
	else
	{
		SuperTestScriptExcelOperation.writeData("AddProj",1,7,"Fail");
	}

}
}
