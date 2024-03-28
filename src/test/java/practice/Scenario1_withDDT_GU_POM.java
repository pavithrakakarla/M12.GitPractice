package practice;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1_withDDT_GU_POM {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Create object of All Utility classes
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		
		
		//Step1: Read the required data
		
		/* Read Data from Property file */
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/* Read Data from Excel file */		
		
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		
		//step1. Launching Browser
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
				
		//step2:Login to application
			
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		//step2:Login to application using POM class
		
		//LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys(USERNAME);
		//lp.getPasswordEdt().sendKeys(PASSWORD);
		//lp.getSubmitBtn().click();
		
		//step2:Login to application using POM class-Business Logic
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step3:Navigate to contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step4:Click on Create Contact Lookup image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//Step5:Create contact with Mandatory fields and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validate for contact
		 String contactHeader=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		 System.out.println(contactHeader);
		 
		 if(contactHeader.contains(LASTNAME))
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
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step8:Close the browser
		driver.quit();


	}
	

}
