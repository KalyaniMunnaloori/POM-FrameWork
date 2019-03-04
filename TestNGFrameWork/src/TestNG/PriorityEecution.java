package TestNG;

import org.testng.annotations.Test;

public class PriorityEecution
{
	@Test(priority=3)
public void testPriorityEecution3()
{
	System.out.println("test3 Executing");
}
	@Test(priority=1)
public void testPriorityEecution1()
{
	System.out.println("test1 Executing");
}
	@Test(priority=2	)
public void testPriorityEecution2()
{
	System.out.println("test2 Executing");
}

}
