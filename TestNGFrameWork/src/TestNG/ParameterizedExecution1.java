package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedExecution1
{
@Parameters("p1")
@Test
public void testParameterizedExecution(String s)
{
	System.out.println("String1 is :+s");
}
}
