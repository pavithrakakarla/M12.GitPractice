package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPracticeSoftAssert {
	
	@Test
	public void sample()
	{
		SoftAssert sa=new SoftAssert();
		
		String a ="hi";
		
		 System.out.println("step1");
		 System.out.println("step2");
		 System.out.println("step3");
		 
		 //Double value comparison syntax
		 //Assert.assertEquals(actual, expected);
		 sa.assertEquals(0, 1); //fail
		 
		//single value comparison syntax
		 //Assert.assertTrue(condition);
		 sa.assertTrue(a.contains("e"));
		 
		 System.out.println("step4");
		 System.out.println("step5");
		 
		 sa.assertAll(); //logs all assertions failures in console
	}

}
