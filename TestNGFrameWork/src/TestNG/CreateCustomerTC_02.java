package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateCustomerTC_02
{
 @Test
public void testCreateCustomerTC_02()
{
	  String url=TestNGExcelOperation.readData("TC_02",1,0);
	     String un=TestNGExcelOperation.readData("TC_02",1,1);
	     String pwd=TestNGExcelOperation.readData("TC_02",1,2);
	     String cust=TestNGExcelOperation.readData("TC_02",1,3);
	     String expectedResult=TestNGExcelOperation.readData("TC_02",1,4);
	     System.setProperty("webdriver.gecko.driver","G:\\64bitAutomationSW\\geckodriver.exe" );
		FirefoxDriver f1 = new FirefoxDriver();
		f1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		f1.get(url);
		f1.findElement(By.name("username")).sendKeys(un);
		f1.findElement(By.name("pwd")).sendKeys(pwd);
		f1.findElement(By.xpath("//input[@type='submit']")).click();
		f1.findElement(By.linkText("Projects & Customers")).click();
		f1.findElement(By.xpath("//input[@value='Add New Customer']")).click();
		f1.findElement(By.name("name")).sendKeys(cust);
		f1.findElement(By.name("createCustomerSubmit")).click();
		String actualResult=f1.findElement(By.className("successmsg")).getText();
		TestNGExcelOperation.writeData("TC_02",1,5,actualResult);
		if(expectedResult.equals(actualResult))
		{
			TestNGExcelOperation.writeData("TC_02",1,6,"Pass");
		}
		else
		{
			TestNGExcelOperation.writeData("TC_02",1,6,"Fail");
		}

}
}
