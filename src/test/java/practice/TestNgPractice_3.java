package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice_3 {

	@Test
	public void createCustomer()
	{
		System.out.println("create");
	}
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	@Test 
	public void deleteCustomer()
	{
		System.out.println("delete");
	}
}
