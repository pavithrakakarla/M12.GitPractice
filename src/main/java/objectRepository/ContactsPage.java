package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//1. Create separate POM class for every web page
	
		//2. Identify all the web elements using @FindBy and make them private
		@FindBy(xpath ="//img[@title=\'Create Contact...\']")
		private WebElement createContactLookUpImg;
				
		//3.Create a constructor for initialization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Rule 4: Provide Getters

		public WebElement getCreateContactLookUpImg() {
			return createContactLookUpImg;
		}
		
		//Rule 5 :Business Library - generic method
		/**
		 * This mehtod will click on create contact lookup image
		 */
		public void clickoncreateContactLookUpImg() {
			createContactLookUpImg.click();
		}
	
		
}
