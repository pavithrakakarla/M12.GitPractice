package contactsTests;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

public class CreateNewContactTestWithHardAssert_3 extends BaseClass {

	@Test	
	public void createContactWithMandatoryfields() throws IOException, InterruptedException  {
		
		//Step1: Read the required data		
		/* Read Data from Excel file */		
		
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
			
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
		 Assert.assertTrue(contactHeader.contains(LASTNAME));
		 System.out.println(contactHeader);
		 
		 
	}
}
