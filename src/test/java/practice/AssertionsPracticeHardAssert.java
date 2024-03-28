package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPracticeHardAssert {
	
	@Test
	public void sample()
	{
		String a ="hi";
		 System.out.println("step1");
		 System.out.println("step2");
		 System.out.println("step3");
		 
		 //Double value comparison syntax
		 //Assert.assertEquals(actual, expected);
		 Assert.assertEquals(0, 1);
		 
		//single value comparison syntax
		 //Assert.assertTrue(condition);
		 Assert.assertTrue(a.contains("i"));
		 
		 System.out.println("step4");
		 System.out.println("step5");
		 
		
	}

}
