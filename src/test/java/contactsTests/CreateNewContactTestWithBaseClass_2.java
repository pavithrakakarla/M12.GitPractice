package contactsTests;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactTestWithBaseClass_2 extends BaseClass {

	@Test	
	public void createContactWithMandatoryfields() throws IOException, InterruptedException  {
		
		//Create object of All Utility classes
		//PropertyFileUtility pUtil=new PropertyFileUtility();
		//ExcelFileUtility eUtil=new ExcelFileUtility();
		//SeleniumUtility sUtil=new SeleniumUtility();
		
		
		//Step1: Read the required data
		
		/* Read Data from Property file */
		//String URL = pUtil.readDataFromPropertyFile("url");
		//String USERNAME = pUtil.readDataFromPropertyFile("username");
		//String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/* Read Data from Excel file */		
		
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		
		//step1. Launching Browser
		/*WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		*/
				
		//step2:Login to application using POM class-Business Logic
		/*LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		*/
		
		//Step3:Navigate to contacts Link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Step4:Click on Create Contact Lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickoncreateContactLookUpImg();
		
		//Step5:Create contact with Mandatory fields and save
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//step 6: Validate for contact
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String contactHeader = cip.captureHeaderText();
		 
		 System.out.println(contactHeader);
		 
		 if(contactHeader.contains(LASTNAME))
		 {
			 System.out.println("PASS");
		 }
		 else
		 {
			 System.out.println("FAIL");
		 }
		 
		 /*
		//Step7: Logout of App	
		hp.logoutOfApp(driver);
		
		//Step8:Close the browser
		driver.quit();
		*/
	}
}
