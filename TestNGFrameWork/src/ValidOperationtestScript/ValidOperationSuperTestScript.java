package ValidOperationtestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


abstract public class ValidOperationSuperTestScript
{
	public static WebDriver driver; 
	@BeforeTest
	public void preConfig()
	{
		String browser=ValidationExcelOperation.readData("PreConfig",1,0);
		String url=ValidationExcelOperation.readData("PreConfig",1,1);			
	if(browser.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver","G:\\64bitAutomationSW\\geckodriver.exe" );
	    driver = new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","G:\\64bitAutomationSW\\chromedriver.exe" );
		driver = new ChromeDriver();
	}
	else
	{
		System.out.println("Invalid Browser");
	}
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	@AfterTest
	public void postConfig()
	{
		//driver.close();
	}

}
