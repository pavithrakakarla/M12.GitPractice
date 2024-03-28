package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1_creatingcontact {

		public static void main(String[] args) throws InterruptedException {
		//step1. Launching Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//step2:Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step3:Navigate to contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step4:Click on Create Contact Lookup image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//Step5:Create contact with Mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys("pvt");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validate for contact
		 String contactHeader=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		 System.out.println(contactHeader);
		 
		 if(contactHeader.contains("pvt"))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 
		//Step7: Logout of App
	
	
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step8:Close the browser
		driver.quit();
		
	}
}
