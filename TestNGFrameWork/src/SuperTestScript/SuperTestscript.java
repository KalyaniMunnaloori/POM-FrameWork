package SuperTestScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SuperTestscript
{
    public static FirefoxDriver f1;
	@BeforeTest
	public void preConfig()
	{
		System.setProperty("webdriver.gecko.driver","G:\\64bitAutomationSW\\geckodriver.exe" );
		f1 = new FirefoxDriver();
		f1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		f1.get("http://127.0.0.1/login.do");

	}
	@AfterTest
	public void postConfig()
	{
		f1.close();
	}


}
