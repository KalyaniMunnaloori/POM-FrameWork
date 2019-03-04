package ValidOperationtestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class VOLogInLogOut extends ValidOperationSuperTestScript
{
	@Test
	public void testVOLogInLogOut()
	{
	    String un=ValidationExcelOperation.readData("LoginLogout",1,0);
	    String pwd=ValidationExcelOperation.readData("LoginLogout",1,1);
	    String expectedResult=ValidationExcelOperation.readData("LoginLogout",1,2);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualResult=driver.getTitle();
		ValidationExcelOperation.writeData("LoginLogout",1,3,actualResult);
		String status=ValidationOperation.verify(expectedResult,actualResult);
		System.out.println(status);
		ValidationExcelOperation.writeData("LoginLogout",1,4,status);
		/*if(expectedResult.equals(actualResult))
		{
			ValidationExcelOperation.writeData("LoginLogout",1,4,"Pass");
		}
		else
		{
			ValidationExcelOperation.writeData("LoginLogout",1,4,"Fail");
		}*/
	}

}
