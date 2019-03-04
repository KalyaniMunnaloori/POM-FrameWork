package WebDriverTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class WDSuperTestScript 
{
	 public static WebDriver driver; 
		@BeforeTest
		public void preConfig()
		{
			String browser=WebDriverExcelOperation.readData("PreConfig",1,0);
			String url=WebDriverExcelOperation.readData("PreConfig",1,1);			
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","G:\\64bitAutomationSW\\geckodriver.exe" );
		    driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","G:\\64bitAutomationSW\\chromedriver.exe" );
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("Invalid Browser");
		}
	}
		@AfterTest
		public void postConfig()
		{
			//driver.close();
		}

}
