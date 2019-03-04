package WebDriverTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class WDLogInLogOut extends WDSuperTestScript
{
	@Test
	public void testWDLoginLogout()
	{
	    String un=WebDriverExcelOperation.readData("LoginLogout",1,0);
	    String pwd=WebDriverExcelOperation.readData("LoginLogout",1,1);
	    String expectedResult=WebDriverExcelOperation.readData("LoginLogout",1,2);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualResult=driver.getTitle();
		WebDriverExcelOperation.writeData("LoginLogout",1,3,actualResult);
		if(expectedResult.equals(actualResult))
		{
			WebDriverExcelOperation.writeData("LoginLogout",1,4,"Pass");
		}
		else
		{
			WebDriverExcelOperation.writeData("LoginLogout",1,4,"Fail");
		}
	}

}
