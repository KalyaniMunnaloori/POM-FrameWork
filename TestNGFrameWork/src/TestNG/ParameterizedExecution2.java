package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedExecution2 
{
	@Parameters("p2")
	@Test
	public void testParameterizedExecution(String s)
	{
		System.out.println("String2 is :+s");
	}
}
