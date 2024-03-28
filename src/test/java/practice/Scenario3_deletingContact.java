package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3_deletingContact {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		driver.findElement(By.xpath("//a[.=\"Contacts\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
		driver.findElement(By.xpath("(//a[.=\"del\"])[1]")).click();
		
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		
		
		
	}

}
