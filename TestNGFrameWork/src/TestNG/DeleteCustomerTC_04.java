package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DeleteCustomerTC_04 
{
@Test
public void testDeleteCustomerTC_04()
{
	String url=TestNGExcelOperation.readData("TC_04",1,0);
    String un=TestNGExcelOperation.readData("TC_04",1,1);
    String pwd=TestNGExcelOperation.readData("TC_04",1,2);
    String cust=TestNGExcelOperation.readData("TC_04",1,3);
    String expectedResult=TestNGExcelOperation.readData("TC_04",1,4);
    System.setProperty("webdriver.gecko.driver","G:\\64bitAutomationSW\\geckodriver.exe" );
	FirefoxDriver f1 = new FirefoxDriver();
	f1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	f1.get(url);
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
	TestNGExcelOperation.writeData("TC_04",1,5,actualResult);
	if(expectedResult.equals(actualResult))
	{
		TestNGExcelOperation.writeData("TC_04",1,6,"Pass");
	}
	else
	{
		TestNGExcelOperation.writeData("TC_04",1,6,"Fail");
	}


}
}
