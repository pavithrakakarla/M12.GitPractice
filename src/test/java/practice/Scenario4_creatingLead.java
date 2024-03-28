package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario4_creatingLead {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		driver.findElement(By.xpath("(//a[.=\"Leads\"])[1]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Lead...\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("pvt_lead");
		driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("IBM");
		
		driver.findElement(By.xpath("(//input[@accesskey=\"S\"])[2]")).click();
		driver.findElement(By.xpath("//span[.=\"pvt_lead\"]")).equals("pvt_lead");
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		

	}

}
