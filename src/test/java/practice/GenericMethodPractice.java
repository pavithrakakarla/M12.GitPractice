package practice;

public class GenericMethodPractice {
											//user
	public static void main(String[] args) {//caller function
	
		//int a =20;   Hardcoded
		//int b=30;
		//int c= a+b;
		//System.out.println(c);
		
		int sum=add(19,40);
		System.out.println(sum);
		int data=sum+10;
		System.out.println(data);
		
		double sub=sub(30.00,10.00);
		System.out.println(sub);
		
	}
	 //Parameterization-inputs from caller
	public static int add(int a, int b) //called function - generic methods
	{
		int c= a+b;
		return c; //return the output to the caller
	}
	
	public static double sub(double a, double b) {
		double c=a-b;
		return c;
	}

}
