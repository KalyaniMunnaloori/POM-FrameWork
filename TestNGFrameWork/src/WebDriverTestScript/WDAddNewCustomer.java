package WebDriverTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class WDAddNewCustomer extends WDSuperTestScript
{
	@Test
	public void testWDAddNewCustomer()
	{
    String un=WebDriverExcelOperation.readData("AddCust",1,0);
    String pwd=WebDriverExcelOperation.readData("AddCust",1,1);
    String cust=WebDriverExcelOperation.readData("AddCust",1,2);
    String expectedResult=WebDriverExcelOperation.readData("AddCust",1,3);
	driver.findElement(By.name("username")).sendKeys(un);
	driver.findElement(By.name("pwd")).sendKeys(pwd);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.linkText("Projects & Customers")).click();
	driver.findElement(By.xpath("//input[@value='Add New Customer']")).click();
	driver.findElement(By.name("name")).sendKeys(cust);
	driver.findElement(By.name("createCustomerSubmit")).click();
	String actualResult=driver.findElement(By.className("successmsg")).getText();
	WebDriverExcelOperation.writeData("AddCust",1,4,actualResult);
	if(expectedResult.equals(actualResult))
	{
		WebDriverExcelOperation.writeData("AddCust",1,5,"Pass");
	}
	else
	{
		WebDriverExcelOperation.writeData("AddCust",1,5,"Fail");
	}

   }

}
