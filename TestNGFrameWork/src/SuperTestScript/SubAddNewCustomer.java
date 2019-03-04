package SuperTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class SubAddNewCustomer extends SuperTestscript
{
	@Test
	public void testSubAddNewCustomer()
	{
	String url=SuperTestScriptExcelOperation.readData("AddCust",1,0);
    String un=SuperTestScriptExcelOperation.readData("AddCust",1,1);
    String pwd=SuperTestScriptExcelOperation.readData("AddCust",1,2);
    String cust=SuperTestScriptExcelOperation.readData("AddCust",1,3);
    String expectedResult=SuperTestScriptExcelOperation.readData("AddCust",1,4);
	f1.findElement(By.name("username")).sendKeys(un);
	f1.findElement(By.name("pwd")).sendKeys(pwd);
	f1.findElement(By.xpath("//input[@type='submit']")).click();
	f1.findElement(By.linkText("Projects & Customers")).click();
	f1.findElement(By.xpath("//input[@value='Add New Customer']")).click();
	f1.findElement(By.name("name")).sendKeys(cust);
	f1.findElement(By.name("createCustomerSubmit")).click();
	String actualResult=f1.findElement(By.className("successmsg")).getText();
	SuperTestScriptExcelOperation.writeData("AddCust",1,5,actualResult);
	if(expectedResult.equals(actualResult))
	{
		SuperTestScriptExcelOperation.writeData("AddCust",1,6,"Pass");
	}
	else
	{
		SuperTestScriptExcelOperation.writeData("AddCust",1,6,"Fail");
	}

   }

}
