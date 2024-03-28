package practice;

import org.testng.annotations.Test;

public class TestNgPractice_InvocationCount {

	@Test(invocationCount = 2)
	public void createCustomer()
	{
		System.out.println("create");
	}
	@Test(invocationCount = 0)
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	@Test (enabled = false)
	public void deleteCustomer()
	{
		System.out.println("delete");
	}
}
