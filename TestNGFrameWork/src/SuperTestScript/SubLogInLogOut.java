package SuperTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SubLogInLogOut extends SuperTestscript
{
@Test
public void testSubLogInLogOut()
{
	String url=SuperTestScriptExcelOperation.readData("LogInLogOut",1,0);
    String un=SuperTestScriptExcelOperation.readData("LogInLogOut",1,1);
    String pwd=SuperTestScriptExcelOperation.readData("LogInLogOut",1,2);
    String expectedResult=SuperTestScriptExcelOperation.readData("LogInLogOut",1,3);
	f1.findElement(By.name("username")).sendKeys(un);
	f1.findElement(By.name("pwd")).sendKeys(pwd);
	f1.findElement(By.xpath("//input[@type='submit']")).click();
	String actualResult=f1.getTitle();
	SuperTestScriptExcelOperation.writeData("LogInLogOut",1,4,actualResult);
	if(expectedResult.equals(actualResult))
	{
		SuperTestScriptExcelOperation.writeData("LogInLogOut",1,5,"Pass");
	}
	else
	{
		SuperTestScriptExcelOperation.writeData("LogInLogOut",1,5,"Fail");
	}
}

}
