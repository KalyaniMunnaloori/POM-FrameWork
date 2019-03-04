package TestNG;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class LogInLogOutTC_01 
{
	@Test
	public void testLogInLogOutTC_01()
	{
	String url=TestNGExcelOperation.readData("TC_01",1,0);
    String un=TestNGExcelOperation.readData("TC_01",1,1);
    String pwd=TestNGExcelOperation.readData("TC_01",1,2);
    String expectedResult=TestNGExcelOperation.readData("TC_01",1,3);
    System.setProperty("webdriver.gecko.driver","G:\\64bitAutomationSW\\geckodriver.exe" );
	FirefoxDriver f1 = new FirefoxDriver();
	f1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	f1.get(url);
	f1.findElement(By.name("username")).sendKeys(un);
	f1.findElement(By.name("pwd")).sendKeys(pwd);
	f1.findElement(By.xpath("//input[@type='submit']")).click();
	String actualResult=f1.getTitle();
	TestNGExcelOperation.writeData("TC_01",1,4,actualResult);
	if(expectedResult.equals(actualResult))
	{
		TestNGExcelOperation.writeData("TC_01",1,5,"Pass");
	}
	else
	{
		TestNGExcelOperation.writeData("TC_01",1,5,"Fail");
	}

	}
}
