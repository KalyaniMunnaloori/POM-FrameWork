package ValidOperationtestScript;

import org.testng.Assert;

public class ValidationOperation
{
public static String verify(String expectedResult, String actualResult)
{
	try
	{
		Assert.assertEquals(expectedResult, actualResult);
		return "Pass";
	}
	catch(AssertionError a)
	{
		return "Fail";
	}
}
}
