package practice;

import org.testng.annotations.Test;

public class TestNgPractice {

	@Test(priority = 2)
	public void createCustomer()
	{
		System.out.println("create");
	}
	@Test(priority = -2)
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
